class ListaTareas {
    private val tareas: MutableList<Tarea> = mutableListOf()
    private var ultimoId: Int = 0

    fun agregarTarea(descripcion: String) {
        val nuevaTarea = Tarea(++ultimoId, descripcion, EstadoTarea.PENDIENTE, null)
        tareas.add(nuevaTarea)
        println("Tarea agregada: $nuevaTarea")
    }

    fun eliminarTarea(id: Int) {
        val tareaAEliminar = tareas.find { it.id == id }
        if (tareaAEliminar != null) {
            tareas.remove(tareaAEliminar)
            println("Tarea eliminada: $tareaAEliminar")
        } else {
            println("No se encontró una tarea con el ID $id")
        }
    }

    fun cambiarEstadoTarea(id: Int, nuevoEstado: EstadoTarea) {
        val tarea = tareas.find { it.id == id }
        if (tarea != null) {
            tarea.estado = nuevoEstado
            println("Estado de la tarea cambiado a $nuevoEstado: $tarea")
        } else {
            println("No se encontró una tarea con el ID $id")
        }
    }

    fun mostrarListaCompleta() {
        println("Lista completa de tareas:")
        tareas.forEach { println(it) }
    }

    fun mostrarTareasPendientes() {
        val tareasPendientes = tareas.filter { it.estado == EstadoTarea.PENDIENTE }
        println("Tareas pendientes:")
        tareasPendientes.forEach { println(it) }
    }

    fun mostrarTareasRealizadas() {
        val tareasRealizadas = tareas.filter { it.estado == EstadoTarea.REALIZADA }
        println("Tareas realizadas:")
        tareasRealizadas.forEach { println(it) }
    }
}