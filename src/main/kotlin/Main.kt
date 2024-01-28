fun main() {
    val listaTareas = ListaTareas()

    while (true) {
        println("\n--- Menú ---")
        println("1. Agregar tarea")
        println("2. Eliminar tarea")
        println("3. Cambiar estado de tarea")
        println("4. Mostrar lista completa")
        println("5. Mostrar tareas pendientes")
        println("6. Mostrar tareas realizadas")
        println("0. Salir")

        print("Seleccione una opción: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Ingrese la descripción de la tarea: ")
                val descripcion = readLine() ?: ""
                listaTareas.agregarTarea(descripcion)
            }
            2 -> {
                print("Ingrese el ID de la tarea a eliminar: ")
                val idEliminar = readLine()?.toIntOrNull() ?: 0
                listaTareas.eliminarTarea(idEliminar)
            }
            3 -> {
                print("Ingrese el ID de la tarea: ")
                val idCambiarEstado = readLine()?.toIntOrNull() ?: 0
                print("Ingrese el nuevo estado (PENDIENTE o REALIZADA): ")
                val nuevoEstadoStr = readLine() ?: ""
                val nuevoEstado = try {
                    EstadoTarea.valueOf(nuevoEstadoStr.uppercase())
                } catch (e: IllegalArgumentException) {
                    null
                }
                if (nuevoEstado != null) {
                    listaTareas.cambiarEstadoTarea(idCambiarEstado, nuevoEstado)
                } else {
                    println("Estado inválido. Debe ser PENDIENTE o REALIZADA.")
                }
            }
            4 -> listaTareas.mostrarListaCompleta()
            5 -> listaTareas.mostrarTareasPendientes()
            6 -> listaTareas.mostrarTareasRealizadas()
            0 -> break
            else -> println("Opción inválida. Por favor, seleccione una opción válida.")
        }
    }
}
