# Implementación de una API REST para gestión de tareas

Construye una API REST en Kotlin con Ktor para gestionar tareas. La API debe permitir crear, listar y actualizar tareas. Usa kotlinx.serialization para el JSON y no utilices ORM; el repositorio será en memoria. Las rutas deben responder 404 cuando la tarea no existe.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | API REST de tareas con Kotlin y Ktor |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Stack

- **Lenguaje:** Kotlin
- **Framework:** Ktor 2.3.12
- **Version:** Kotlin 1.9.22

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn clean compile` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn clean compile`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Configuración inicial y creación de endpoint para crear tareas

**Objetivo:** Configurar el proyecto y crear el endpoint para crear tareas.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configura el proyecto con Ktor y kotlinx.serialization.
- Crea un endpoint POST para crear una nueva tarea.
- Verifica que el endpoint responda correctamente y que la tarea se almacene en memoria.

**Entregable:** Proyecto configurado con Ktor y kotlinx.serialization, y endpoint POST para crear tareas.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda usar kotlinx.serialization para el JSON.
- El repositorio debe ser en memoria.

</details>

### Fase 2: Creación de endpoint para listar tareas

**Objetivo:** Crear el endpoint para listar todas las tareas almacenadas.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Crea un endpoint GET para listar todas las tareas.
- Verifica que el endpoint responda con la lista de tareas almacenadas.

**Entregable:** Endpoint GET para listar todas las tareas.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que el repositorio es en memoria.

</details>

### Fase 3: Creación de endpoint para actualizar tareas

**Objetivo:** Crear el endpoint para actualizar una tarea existente.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Crea un endpoint PUT para actualizar una tarea existente.
- Verifica que el endpoint responda con la tarea actualizada si existe, o con un error 404 si no existe.

**Entregable:** Endpoint PUT para actualizar una tarea existente.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que las rutas deben responder 404 cuando la tarea no existe.

</details>

### Fase 4: Pruebas de aceptación y verificación de restricciones

**Objetivo:** Implementar pruebas de aceptación y verificar que se cumplan las restricciones del solicitante.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Implementa pruebas de aceptación para los endpoints creados.
- Verifica que las rutas respondan 404 cuando la tarea no existe.

**Entregable:** Pruebas de aceptación implementadas y verificadas.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que las pruebas de aceptación deben verificar que las rutas respondan 404 cuando la tarea no existe.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una API REST y cuál es su propósito en este reto?
- **paraQueSirve**: ¿Para qué sirve el endpoint PUT en este reto?
- **comoSeUsa**: ¿Cómo se usa kotlinx.serialization en este reto?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar una API REST y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de una API REST en este reto?

## Criterios de Evaluacion

- Configuración correcta del proyecto con Ktor y kotlinx.serialization.
- Creación de endpoint POST para crear tareas.
- Creación de endpoint GET para listar tareas.
- Creación de endpoint PUT para actualizar tareas.
- Implementación de pruebas de aceptación y verificación de restricciones.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Configuración inicial y creación de endpoint para crear tareas | Creación de tareas con validación de datos | `src/main/kotlin/domain/task/service/TaskService.kt:TaskService.createTask` | El proyecto está configurado con Ktor y kotlinx.serialization; El endpoint POST /tasks crea una tarea con los datos proporcionados; El endpoint responde con el código HTTP adecuado y la tarea creada | — | — |
| f1 — Configuración inicial y creación de endpoint para crear tareas | Persistencia en memoria de tareas | `src/main/kotlin/domain/task/outbound/TaskRepositoryImpl.kt:TaskRepositoryImpl.save` | El proyecto está configurado con Ktor y kotlinx.serialization; El endpoint POST /tasks crea una tarea con los datos proporcionados; El endpoint responde con el código HTTP adecuado y la tarea creada | — | — |
| f1 — Configuración inicial y creación de endpoint para crear tareas | Manejo de rutas HTTP para creación de tareas | `src/main/kotlin/domain/task/inbound/TaskRoutes.kt:TaskRoutes.createTask` | El proyecto está configurado con Ktor y kotlinx.serialization; El endpoint POST /tasks crea una tarea con los datos proporcionados; El endpoint responde con el código HTTP adecuado y la tarea creada | — | — |
| f2 — Creación de endpoint para listar tareas | Listado de tareas con manejo de errores | `src/main/kotlin/domain/task/service/TaskService.kt:TaskService.listTasks` | El endpoint GET /tasks lista todas las tareas almacenadas; El endpoint responde con el código HTTP adecuado y la lista de tareas; El endpoint maneja correctamente el caso en que no hay tareas; El endpoint maneja errores internos y responde con el código HTTP adecuado | — | — |
| f2 — Creación de endpoint para listar tareas | Recuperación de tareas desde memoria | `src/main/kotlin/domain/task/outbound/TaskRepositoryImpl.kt:TaskRepositoryImpl.findAll` | El endpoint GET /tasks lista todas las tareas almacenadas; El endpoint responde con el código HTTP adecuado y la lista de tareas; El endpoint maneja correctamente el caso en que no hay tareas; El endpoint maneja errores internos y responde con el código HTTP adecuado | — | — |
| f2 — Creación de endpoint para listar tareas | Manejo de rutas HTTP para listado de tareas | `src/main/kotlin/domain/task/inbound/TaskRoutes.kt:TaskRoutes.listTasks` | El endpoint GET /tasks lista todas las tareas almacenadas; El endpoint responde con el código HTTP adecuado y la lista de tareas; El endpoint maneja correctamente el caso en que no hay tareas; El endpoint maneja errores internos y responde con el código HTTP adecuado | — | — |
| f3 — Creación de endpoint para actualizar tareas | Actualización de tareas con validación y manejo de errores | `src/main/kotlin/domain/task/service/TaskService.kt:TaskService.updateTask` | El endpoint PUT /tasks/{id} actualiza una tarea existente con los datos proporcionados; El endpoint responde con el código HTTP adecuado y la tarea actualizada; El endpoint responde con 404 cuando la tarea no existe; El endpoint maneja errores de validación y responde con el código HTTP adecuado | — | — |
| f3 — Creación de endpoint para actualizar tareas | Actualización de tareas en memoria | `src/main/kotlin/domain/task/outbound/TaskRepositoryImpl.kt:TaskRepositoryImpl.update` | El endpoint PUT /tasks/{id} actualiza una tarea existente con los datos proporcionados; El endpoint responde con el código HTTP adecuado y la tarea actualizada; El endpoint responde con 404 cuando la tarea no existe; El endpoint maneja errores de validación y responde con el código HTTP adecuado | — | — |
| f3 — Creación de endpoint para actualizar tareas | Manejo de rutas HTTP para actualización de tareas | `src/main/kotlin/domain/task/inbound/TaskRoutes.kt:TaskRoutes.updateTask` | El endpoint PUT /tasks/{id} actualiza una tarea existente con los datos proporcionados; El endpoint responde con el código HTTP adecuado y la tarea actualizada; El endpoint responde con 404 cuando la tarea no existe; El endpoint maneja errores de validación y responde con el código HTTP adecuado | — | — |
| f4 — Pruebas de aceptación y verificación de restricciones | Pruebas de aceptación para la API de tareas | — | Todas las pruebas de aceptación están implementadas y pasan; Las restricciones del solicitante se verifican en las pruebas; Los casos de borde y errores están cubiertos | — | — |
| f4 — Pruebas de aceptación y verificación de restricciones | Mapeo de excepciones a respuestas HTTP | `src/main/kotlin/domain/core/ErrorMapper.kt:ErrorMapper` | Todas las pruebas de aceptación están implementadas y pasan; Las restricciones del solicitante se verifican en las pruebas; Los casos de borde y errores están cubiertos | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Usar kotlinx.serialization para el JSON (plugin o dependencia en el build) | chequeo estatico (manifest): exige `kotlinx.serialization`, `json` | Restriccion no verificada en chequeo estatico (manifest): exige `kotlinx.serialization`, `json` |
| No usar Exposed ni otro ORM; el repositorio es en memoria | chequeo estatico (code): prohibe `Exposed`, `Hibernate`, `Room`, `JPA` | Verificada |
| Las rutas responden 404 cuando la tarea no existe y las pruebas de aceptacion lo verifican | sin ubicar | Restriccion no verificada en sin ubicar |

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
