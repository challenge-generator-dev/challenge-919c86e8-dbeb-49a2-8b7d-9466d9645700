package domain.task.model

import kotlinx.serialization.Serializable

/**
 * Estados posibles de una tarea.
 */
@Serializable
enum class TaskStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED
}