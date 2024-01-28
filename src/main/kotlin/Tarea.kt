import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Tarea(val id: Int, var descripcion: String, var estado: EstadoTarea, var fechaRealizacion: LocalDateTime?) {

    init {
        if (estado == EstadoTarea.REALIZADA && fechaRealizacion == null) {
            fechaRealizacion = LocalDateTime.now()
        }
    }

    override fun toString(): String {
        return when (estado) {
            EstadoTarea.PENDIENTE -> "$id - $descripcion (Pendiente)"
            EstadoTarea.REALIZADA -> {
                val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                "$id - $descripcion (Realizada el ${fechaRealizacion?.format(formatter)})"
            }
        }
    }
}