package domain.task.dto

import kotlinx.serialization.Serializable
import domain.task.model.TaskStatus

/**
 * DTO para la actualización de una tarea existente.
 * Este archivo consume la pieza p7 que define la lógica completa.
 */
@Serializable
data class TaskUpdateRequest(
    val title: String? = null,
    val description: String? = null,
    val status: TaskStatus? = null
)