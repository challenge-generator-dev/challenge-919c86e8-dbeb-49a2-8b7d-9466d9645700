# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/kotlin/domain/task/service/TaskService.kt` — La pieza p1 (Creación de tareas con validación de datos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/kotlin/domain/task/outbound/TaskRepositoryImpl.kt` — La pieza p2 (Persistencia en memoria de tareas, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — La pieza p3 (Manejo de rutas HTTP para creación de tareas, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/kotlin/domain/core/ErrorMapper.kt` — La pieza p11 (Mapeo de excepciones a respuestas HTTP, fase f4) vive aqui: este archivo es su unico dueno (blueprint v2).

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/kotlin/domain/task/service/TaskService.kt` — `domain.task.model.Task`: El import domain.task.model.Task usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/kotlin/domain/task/outbound/TaskRepositoryImpl.kt` — `domain.task.model.Task`: El import domain.task.model.Task usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `domain.task.model.Task`: El import domain.task.model.Task usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.

### Imports sin uso — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos:

- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `TaskCreateRequest`
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `TaskUpdateRequest`
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `ServiceException`
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `TaskNotFoundException`
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `ValidationException`

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Kotlin, Senior L2

### Brecha de conocimiento
Construir una API REST en Kotlin con Ktor para gestionar tareas

### Misión / candidato
Exponer la gestion de tareas por HTTP

### Reto
- Tema: API REST de tareas con Kotlin y Ktor
- Seniority: senior-l2
- Tipo: practical
- Título: Implementación de una API REST para gestión de tareas
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración inicial y creación de endpoint para crear tareas — objetivo: Configurar el proyecto y crear el endpoint para crear tareas. — entregable (NO resolver): Proyecto configurado con Ktor y kotlinx.serialization, y endpoint POST para crear tareas.
- Fase 2: Creación de endpoint para listar tareas — objetivo: Crear el endpoint para listar todas las tareas almacenadas. — entregable (NO resolver): Endpoint GET para listar todas las tareas.
- Fase 3: Creación de endpoint para actualizar tareas — objetivo: Crear el endpoint para actualizar una tarea existente. — entregable (NO resolver): Endpoint PUT para actualizar una tarea existente.
- Fase 4: Pruebas de aceptación y verificación de restricciones — objetivo: Implementar pruebas de aceptación y verificar que se cumplan las restricciones del solicitante. — entregable (NO resolver): Pruebas de aceptación implementadas y verificadas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>ktor-skeleton</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>
  
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <kotlin.version>1.9.22</kotlin.version>
    <ktor.version>2.3.12</ktor.version>
    <jvm.target>21</jvm.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>io.ktor</groupId>
      <artifactId>ktor-server-core-jvm</artifactId>
      <version>${ktor.version}</version>
    </dependency>
    <dependency>
      <groupId>io.ktor</groupId>
      <artifactId>ktor-server-netty-jvm</artifactId>
      <version>${ktor.version}</version>
    </dependency>
    <dependency>
      <groupId>org.jetbrains.kotlin</groupId>
      <artifactId>kotlin-test-junit</artifactId>
      <version>${kotlin.version}</version>
      <scope>test</scope>
    </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-serialization-kotlinx-json-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-server-content-negotiation-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-server-status-pages-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
      <dependency>
          <groupId>org.jetbrains.kotlinx</groupId>
          <artifactId>kotlinx-serialization-json</artifactId>
          <version>1.6.3</version>
      </dependency>
  </dependencies>

  <build>
    <sourceDirectory>${project.basedir}/src/main/kotlin</sourceDirectory>
    <testSourceDirectory>${project.basedir}/src/test/kotlin</testSourceDirectory>
    <plugins>
      <plugin>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-maven-serialization-plugin</artifactId>
        <version>${kotlin.version}</version>
      </plugin>
      <plugin>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-maven-plugin</artifactId>
        <version>${kotlin.version}</version>
        <configuration>
          <compilerPlugins>
            <plugin>kotlinx-serialization</plugin>
          </compilerPlugins>
        </configuration>
        <dependencies>
          <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-serialization</artifactId>
            <version>${kotlin.version}</version>
          </dependency>
        </dependencies>
        <executions>
          <execution>
            <id>compile</id>
            <goals>
              <goal>compile</goal>
            </goals>
          </execution>
          <execution>
            <id>test-compile</id>
            <goals>
              <goal>test-compile</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.11.0</version>
        <configuration>
          <source>${jvm.target}</source>
          <target>${jvm.target}</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>

// === ARCHIVO: src/main/kotlin/com/example/Application.kt ===
package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.routing.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.response.*
import kotlinx.serialization.json.Json
import domain.task.inbound.taskRoutes
import domain.task.outbound.TaskRepositoryImpl
import domain.task.service.TaskService
import domain.task.service.TaskNotFoundException
import domain.core.ErrorMapper

class TaskNotFoundException(val id: String) : Exception("Task with id $id not found")

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
            coerceInputValues = true
            encodeDefaults = true
        })
    }

    install(StatusPages) {
        exception<TaskNotFoundException> { call, cause ->
            call.respond(io.ktor.http.HttpStatusCode.NotFound, mapOf("error" to cause.message))
        }
        exception<Exception> { call, cause ->
            call.respond(ErrorMapper.mapToHttpResponse(cause))
        }
    }

    routing {
        taskRoutes(taskService)
    }
}

// === ARCHIVO: mvnw ===
#!/bin/sh
"exec" "$(dirname "$0")/mvnw" "$@"

// === ARCHIVO: mvnw.cmd ===
@REM
@REM Copyright 2007 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM     http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.

@IF "%MAVEN_SKIP_RC%" == "" @
@call :chkMHome
@IF ERRORLEVEL 1 @
@call "%MAVEN_PROJECTBASEDIR%\.mvn\jvm.config" %MAVEN_CMD_LINE_ARGS%
@goto :continue

@:chkMHome
@REM Check for Maven home defined inside Maven wrapper distribution
@IF "%MAVEN_HOME%" == "" (
  @SET MAVEN_HOME=%~dp0\.mvn\wrapper\maven-wrapper
)

@:continue
@set CMD_LINE_ARGS=%*
@set MAVEN_JAVA_EXE="%JAVA_HOME%\bin\java.exe"
@set WRAPPER_JAR="%MAVEN_HOME%\maven-wrapper.jar"
@set WRAPPER_PROPS="%MAVEN_HOME%\maven-wrapper.properties"
@set WRAPPER_LOG="%MAVEN_HOME%\maven-wrapper.log"

@if exist %MAVEN_JAVA_EXE% (
  if exist %WRAPPER_JAR% (
    %MAVEN_JAVA_EXE% %MAVEN_OPTS% -classpath %WRAPPER_JAR% -Dmaven.multiModuleProjectDirectory="%MAVEN_PROJECTBASEDIR%" org.apache.maven.wrapper.MavenWrapperMain %CMD_LINE_ARGS%
  ) else (
    @echo Could not locate maven-wrapper.jar, using basic mvn commands
    @call mvn %CMD_LINE_ARGS%
  )
) else (
  @echo Could not locate java.exe, please check JAVA_HOME
)

// === ARCHIVO: .mvn/wrapper/maven-wrapper.properties ===
distributionUrl=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip
wrapperUrl=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.0/maven-wrapper-3.3.0.jar

// === ARCHIVO: src/main/kotlin/domain/task/model/Task.kt ===
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

// === ARCHIVO: src/main/kotlin/domain/task/dto/TaskCreateRequest.kt ===
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

// === ARCHIVO: src/main/kotlin/domain/task/dto/TaskUpdateRequest.kt ===
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

// === ARCHIVO: src/main/kotlin/domain/task/repository/TaskRepository.kt ===
package domain.task.repository

/**
 * Interfaz del repositorio para operaciones de persistencia de tareas.
 * Este archivo consume la pieza p2 que define la implementación completa.
 * La interfaz TaskRepository está definida en la pieza TaskRepositoryImpl.
 */
interface TaskRepository

// === ARCHIVO: src/main/kotlin/domain/task/service/TaskService.kt ===
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

// === ARCHIVO: src/main/kotlin/domain/task/outbound/TaskRepositoryImpl.kt ===
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

// === ARCHIVO: src/main/kotlin/domain/task/inbound/TaskRoutes.kt ===
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

// === ARCHIVO: src/main/kotlin/domain/core/ErrorMapper.kt ===
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

// === ARCHIVO: src/main/kotlin/domain/test/kotlin/domain/task/TaskAcceptanceTest.kt ===
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

// === ARCHIVO: src/main/kotlin/domain/Application.kt ===
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
```
