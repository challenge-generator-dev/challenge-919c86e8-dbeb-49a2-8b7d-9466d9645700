// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.task.outbound

import domain.task.model.Task
import domain.task.repository.TaskRepository
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

class TaskRepositoryImpl : TaskRepository {
    private val tasks = ConcurrentHashMap<String, Task>()
    private val idGenerator = AtomicLong(1)

    override suspend fun save(task: Task): Task {
      TODO("reto: ConcurrentHashMap")
    }

    override suspend fun findById(id: String): Task? {
        return tasks[id]
    }

    override suspend fun findAll(): List<Task> {
      TODO("reto: findAll")
    }

    override suspend fun update(task: Task): Task {
      TODO("reto: update")
    }

    override suspend fun delete(id: String) {
      TODO("reto: delete")
    }

    private fun generateId(): String {
      TODO("reto: generateId")
    }
}