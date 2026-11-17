package domain

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import domain.task.inbound.taskRoutes
import domain.task.outbound.TaskRepositoryImpl
import domain.task.service.TaskService
import domain.task.service.TaskNotFoundException
import domain.core.ErrorMapper

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    val taskService = TaskService(TaskRepositoryImpl())

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }

    install(StatusPages) {
        exception<TaskNotFoundException> { call, cause ->
            call.respond(io.ktor.http.HttpStatusCode.NotFound, mapOf("error" to cause.message))
        }
        exception<Exception> { call, exception ->
            call.respond(ErrorMapper.mapToHttpResponse(exception))
        }
    }

    routing {
        taskRoutes(taskService)
    }
}