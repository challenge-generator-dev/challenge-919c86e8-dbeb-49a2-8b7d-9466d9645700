package domain.task.dto

import kotlinx.serialization.Serializable
import domain.task.model.TaskStatus

/**
 * DTO para la creación de una nueva tarea.
 * Este archivo consume la pieza p1 que define la lógica completa.
 */
@Serializable
data class TaskCreateRequest(
    val title: String,
    val description: String,
    val status: TaskStatus = TaskStatus.PENDING
)