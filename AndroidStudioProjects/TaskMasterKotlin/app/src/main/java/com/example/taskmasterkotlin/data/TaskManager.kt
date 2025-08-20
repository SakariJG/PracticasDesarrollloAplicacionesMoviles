package com.example.taskmasterkotlin.data

object TaskManager {
    private val tasks = mutableListOf<Task>()

    // Parámetro variable + lambda de éxito
    fun addTasks(vararg newTasks: Task, onSuccess: () -> Unit) {
        tasks.addAll(newTasks.toList())
        onSuccess()
    }

    // Función de orden superior para filtrar
    fun filterTasks(predicate: (Task) -> Boolean): List<Task> {
        return tasks.filter(predicate)
    }

    // Posible null con operador seguro
    fun findTaskById(id: Int): Task? = tasks.find { it.id == id }

    // Lanzar error si no existe y marcar como completada
    fun completeTask(id: Int) {
        val task = findTaskById(id) ?: throw IllegalArgumentException("ID $id no existe")
        task.isCompleted = true
    }
}
