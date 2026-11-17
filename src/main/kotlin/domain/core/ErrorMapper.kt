// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.core

import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.http.*

/**
 * Mapea excepciones de dominio a respuestas HTTP estandarizadas.
 * Proporciona manejo consistente de errores en toda la aplicación.
 */
object ErrorMapper {

    /**
     * Mapea una excepción a una respuesta HTTP apropiada.
     * @param exception La excepción a mapear.
     * @return HttpResponse con el código de estado y cuerpo apropiados.
     */
    fun mapToHttpResponse(exception: Exception): HttpResponse {
      TODO("reto: mapToHttpResponse")
    }

    /**
     * Maneja la excepción y envía la respuesta HTTP al cliente.
     * @param call El contexto de la llamada HTTP.
     * @param exception La excepción a manejar.
     */
    suspend fun handleException(call: ApplicationCall, exception: Exception) {
      TODO("reto: handleException")
    }
}

/**
 * Representa una respuesta HTTP con código de estado y mensaje.
 * @property status Código de estado HTTP.
 * @property message Mensaje de la respuesta.
 */
data class HttpResponse(
    val status: HttpStatusCode,
    val message: String
)