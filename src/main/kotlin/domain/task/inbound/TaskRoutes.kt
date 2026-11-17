// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.task.inbound

import domain.task.dto.TaskCreateRequest
import domain.task.dto.TaskUpdateRequest
import domain.task.model.Task
import domain.task.service.ServiceException
import domain.task.service.TaskNotFoundException
import domain.task.service.TaskService
import domain.task.service.ValidationException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.taskRoutes(taskService: TaskService) {
    route("/tasks") {
      TODO("reto: route")
    }
}

private fun Route.createTask(taskService: TaskService) {
  TODO("reto: createTask")
}

private fun Route.listTasks(taskService: TaskService) {
  TODO("reto: listTasks")
}

private fun Route.updateTask(taskService: TaskService) {
    put("/{id}") {
      TODO("reto: put")
    }
}