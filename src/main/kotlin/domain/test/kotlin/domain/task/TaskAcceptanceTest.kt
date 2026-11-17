package domain.test.kotlin.domain.task

import kotlin.test.Test
import kotlin.test.assertEquals
import domain.task.service.ValidationException
import domain.task.service.TaskNotFoundException
import domain.core.ErrorMapper

/**
 * Pruebas de aceptación para el flujo completo de Task.
 * Verifica el mapeo correcto de excepciones a códigos HTTP.
 */
class TaskAcceptanceTest {

    @Test
    fun `should map validation exception to 400`() {
        val validationException = ValidationException("El título es obligatorio y no puede estar vacío")
        
        val response = ErrorMapper.mapToHttpResponse(validationException)
        
        assertEquals(400, response.status.value)
        assertEquals("El título es obligatorio y no puede estar vacío", response.message)
    }

    @Test
    fun `should map not found exception to 404`() {
        val notFoundException = TaskNotFoundException("Tarea con ID 123 no encontrada")
        
        val response = ErrorMapper.mapToHttpResponse(notFoundException)
        
        assertEquals(404, response.status.value)
        assertEquals("Tarea con ID 123 no encontrada", response.message)
    }

    @Test
    fun `should map generic exception to 500`() {
        val genericException = RuntimeException("Error inesperado")
        
        val response = ErrorMapper.mapToHttpResponse(genericException)
        
        assertEquals(500, response.status.value)
        assertEquals("Error interno del servidor", response.message)
    }
}