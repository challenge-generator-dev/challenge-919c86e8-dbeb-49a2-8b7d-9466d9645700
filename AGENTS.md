# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de una API REST para gestión de tareas**.

| | |
|---|---|
| Tema | API REST de tareas con Kotlin y Ktor |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Kotlin + Ktor |
| Stack | Kotlin / Ktor 2.3.12 |
| Patron arquitectonico | capas estándar (inbound-adapter, core, outbound-adapter) |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `manifiesto de dependencias y build de Kotlin en la raiz (segun las convenciones idiomaticas de Kotlin/Ktor)`
- `punto de entrada de la aplicacion (segun las convenciones idiomaticas de Kotlin/Ktor)`
- `capa de dominio con entidades y puertos (segun las convenciones idiomaticas de Kotlin/Ktor)`
- `capa de aplicacion con casos de uso (segun las convenciones idiomaticas de Kotlin/Ktor)`
- `capa de infraestructura con los adaptadores y los handlers HTTP de Ktor (segun las convenciones idiomaticas de Kotlin/Ktor)`

Trampas conocidas:

- Todo el codigo, el manifiesto y los tests son de Kotlin/Ktor; no mezclar otro lenguaje ni otro runtime.

Dependencias:

- io.ktor:ktor-server-core-jvm 2.3.12
- io.ktor:ktor-server-netty-jvm 2.3.12
- org.jetbrains.kotlin:kotlin-test-junit 1.9.22
- io.ktor:ktor-serialization-kotlinx-json-jvm 2.3.12
- io.ktor:ktor-server-content-negotiation-jvm 2.3.12
- io.ktor:ktor-server-status-pages-jvm 2.3.12
- org.jetbrains.kotlinx:kotlinx-serialization-json 1.6.3
- org.jetbrains.kotlin:kotlin-maven-serialization 1.9.22

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración inicial y creación de endpoint para crear tareas**: Proyecto configurado con Ktor y kotlinx.serialization, y endpoint POST para crear tareas.
- **Fase 2 — Creación de endpoint para listar tareas**: Endpoint GET para listar todas las tareas.
- **Fase 3 — Creación de endpoint para actualizar tareas**: Endpoint PUT para actualizar una tarea existente.
- **Fase 4 — Pruebas de aceptación y verificación de restricciones**: Pruebas de aceptación implementadas y verificadas.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/kotlin/domain/task/service/TaskService.kt` — La pieza p1 (Creación de tareas con validación de datos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/kotlin/domain/task/outbound/TaskRepositoryImpl.kt` — La pieza p2 (Persistencia en memoria de tareas, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — La pieza p3 (Manejo de rutas HTTP para creación de tareas, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/kotlin/domain/core/ErrorMapper.kt` — La pieza p11 (Mapeo de excepciones a respuestas HTTP, fase f4) vive aqui: este archivo es su unico dueno (blueprint v2).

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

## Pruebas de aceptacion y ubicacion de la logica

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

La logica de cada pieza va en su archivo; no la muevas a otro.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Usar kotlinx.serialization para el JSON (plugin o dependencia en el build) | chequeo estatico (manifest): exige `kotlinx.serialization`, `json` | Restriccion no verificada en chequeo estatico (manifest): exige `kotlinx.serialization`, `json` |
| No usar Exposed ni otro ORM; el repositorio es en memoria | chequeo estatico (code): prohibe `Exposed`, `Hibernate`, `Room`, `JPA` | Verificada |
| Las rutas responden 404 cuando la tarea no existe y las pruebas de aceptacion lo verifican | sin ubicar | Restriccion no verificada en sin ubicar |

## Lo que falta y tenes que completar

### 1. Referencias colgando (3)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/kotlin/domain/task/service/TaskService.kt` — `domain.task.model.Task`
      El import domain.task.model.Task usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/kotlin/domain/task/outbound/TaskRepositoryImpl.kt` — `domain.task.model.Task`
      El import domain.task.model.Task usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `domain.task.model.Task`
      El import domain.task.model.Task usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.

### Imports sin uso (5) — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos.

- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `TaskCreateRequest`
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `TaskUpdateRequest`
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `ServiceException`
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `TaskNotFoundException`
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt` — `ValidationException`

### Presentes (15)

- `pom.xml`
- `src/main/kotlin/com/example/Application.kt`
- `mvnw`
- `mvnw.cmd`
- `.mvn/wrapper/maven-wrapper.properties`
- `src/main/kotlin/domain/task/model/Task.kt`
- `src/main/kotlin/domain/task/dto/TaskCreateRequest.kt`
- `src/main/kotlin/domain/task/dto/TaskUpdateRequest.kt`
- `src/main/kotlin/domain/task/repository/TaskRepository.kt`
- `src/main/kotlin/domain/task/service/TaskService.kt`
- `src/main/kotlin/domain/task/outbound/TaskRepositoryImpl.kt`
- `src/main/kotlin/domain/task/inbound/TaskRoutes.kt`
- `src/main/kotlin/domain/core/ErrorMapper.kt`
- `src/main/kotlin/domain/test/kotlin/domain/task/TaskAcceptanceTest.kt`
- `src/main/kotlin/domain/Application.kt`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/kotlin/domain/core` (presente)
- `src/main/kotlin/domain/inbound` (ausente)
- `src/main/kotlin/domain/outbound` (ausente)
- `src/main/kotlin/domain/dto` (ausente)
- `src/main/kotlin/domain/model` (ausente)
- `src/test/kotlin/domain` (ausente)

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar (inbound-adapter, core, outbound-adapter)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Kotlin, Senior L2
- Brecha que el reto ataca: Construir una API REST en Kotlin con Ktor para gestionar tareas
- Mision: Exponer la gestion de tareas por HTTP

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
