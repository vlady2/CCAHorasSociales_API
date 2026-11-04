# Contrato inicial para la aplicación móvil CCA

## Estado
Este paquete añade endpoints iniciales para que el equipo móvil pueda integrar las pantallas de horarios, lista de estudiantes y captura de asistencia. La API usa el proyecto actual Java/Spring Boot/MySQL. El documento original pide Node.js/Express/TypeScript/PostgreSQL; el cambio de stack debe ser aprobado por el equipo responsable.

**Importante:** esta versión todavía no es apta para desplegarse públicamente. `SecurityConfig` actualmente permite todas las peticiones y no hay autenticación JWT operativa. Los parámetros `docenteId` y `registradoPor` son identificadores enviados por el cliente y no prueban identidad. Úsese solo en entorno local de desarrollo con datos de prueba. Antes de usar datos reales se debe implementar login/JWT, autorización en servidor basada en el usuario autenticado, MFA donde corresponda, límites de petición y pruebas de seguridad.

Base local: `http://localhost:8080`. Prefijo de estos endpoints: `/api/movil`.

## 1. Horarios del docente
`GET /api/movil/docentes/{docenteId}/horarios`

Opcional: `?diaSemana=1` a `?diaSemana=5` (lunes a viernes).

Respuesta: arreglo con `id`, `seccionId`, `diaSemana`, `numeroPeriodo`, `horaInicio`, `horaFin`, `asignatura`.

## 2. Estudiantes activos de una sección
`GET /api/movil/secciones/{seccionId}/estudiantes`

Solo devuelve estudiantes con matrícula `ACTIVA` en la sección. Respuesta: arreglo con `id`, `nie`, `nombres`, `apellidos`.

## 3. Registrar asistencia por lote
`POST /api/movil/asistencia/lote`
`Content-Type: application/json`

Ejemplo para ENTRADA:

```json
{
  "seccionId": "UUID-DE-SECCION",
  "anioLectivoId": "UUID-DEL-ANIO",
  "fecha": "2026-10-26",
  "momento": "ENTRADA",
  "horarioId": null,
  "docenteId": "UUID-DEL-DOCENTE",
  "registros": [
    {
      "estudianteId": "UUID-DEL-ESTUDIANTE",
      "estado": "PRESENTE",
      "clientUuid": "UUID-UNICO-GENERADO-POR-EL-TELEFONO",
      "justificacion": null
    },
    {
      "estudianteId": "UUID-OTRO-ESTUDIANTE",
      "estado": "LLEGADA_TARDIA",
      "clientUuid": "OTRO-UUID-UNICO",
      "justificacion": null
    }
  ]
}
```

Ejemplo para CLASE: `momento` debe ser `CLASE` y `horarioId` debe ser el horario asignado al docente y a la sección. Estados aceptados: `PRESENTE`, `AUSENTE_INJUSTIFICADO`, `PERMISO_JUSTIFICADO`, `LLEGADA_TARDIA`, `EVASION`. `LLEGADA_TARDIA` solo aplica a ENTRADA; `EVASION` solo a CLASE y requiere una ENTRADA previa en estado `PRESENTE` o `LLEGADA_TARDIA`. `PERMISO_JUSTIFICADO` requiere texto en `justificacion`.

Respuesta de éxito:

```json
{
  "guardados": 2,
  "duplicadosIgnorados": 0,
  "mensaje": "Registros procesados"
}
```

`clientUuid` debe generarse una sola vez por registro en el dispositivo y conservarse al reintentar la sincronización. El servidor ignora identificadores de cliente ya procesados y también evita duplicar el mismo estudiante/fecha/momento/horario.

## Errores previstos
- `400`: campos inválidos, estado desconocido, matrícula no activa o combinación de datos incorrecta.
- `403`: el horario no pertenece al docente o el docente no tiene asignación válida.
- `422`: regla de negocio incumplida, por ejemplo EVASION sin ENTRADA previa.

## Configuración y pruebas
1. Iniciar MySQL y confirmar que existe la base `sistema_escolar` con el esquema del proyecto.
2. Configurar la conexión local en `src/main/resources/application.yaml`; no compartir contraseñas reales.
3. Ejecutar `mvn spring-boot:run` (o `mvnw.cmd spring-boot:run` en Windows).
4. Probar primero horarios y estudiantes; luego enviar el lote desde Postman.
5. Para Android Emulator, `localhost` del emulador no es el PC; normalmente se usa `http://10.0.2.2:8080`. En un teléfono físico, usar la IP local del PC y que ambos estén en la misma red.

## Pendiente antes de considerar la API lista
- Autenticación JWT y renovación de sesión.
- Autorización por identidad autenticada; nunca confiar en `docenteId` enviado por el móvil.
- Consultar estudiantes/horarios con restricciones por año lectivo y permisos completos.
- Reglas de asistencia adicionales del documento, creación automática de banderas/actas, auditoría y sincronización probada.
- Contrato OpenAPI completo y pruebas automatizadas contra MySQL.
