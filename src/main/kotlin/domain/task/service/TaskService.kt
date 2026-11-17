// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.task.service

import domain.task.dto.TaskCreateRequest
import domain.task.dto.TaskUpdateRequest
import domain.task.model.Task
import domain.task.repository.TaskRepository
import java.util.UUID

class TaskService(private val taskRepository: TaskRepository) {

    fun createTask(taskData: TaskCreateRequest): Task {
      TODO("reto: createTask")
    }

    fun listTasks(): List<Task> {
      TODO("reto: listTasks")
    }

    fun updateTask(id: String, taskData: TaskUpdateRequest): Task {
      TODO("reto: updateTask")
    }
}

class ServiceException(message: String, cause: Throwable? = null) : Exception(message, cause)
class TaskNotFoundException(message: String) : Exception(message)
class ValidationException(message: String) : Exception(message)