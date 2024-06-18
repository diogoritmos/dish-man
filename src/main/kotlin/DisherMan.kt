package br.com.diogoritmos

import br.com.diogoritmos.Dish.DishState

class DisherMan(
    private val fordDishes: MutableList<Dish> = mutableListOf(),
    private val toyotaDishes: MutableList<Dish> = mutableListOf()
) {
    fun addDish(dish: Dish, priority: Boolean = false) {
        if (priority) {
            toyotaDishes.add(dish)
        } else {
            fordDishes.add(dish)
        }
    }

    fun doWork() {
        val dishAndPriorityToWork = getDishAndPriorityToWork()
        val dish = dishAndPriorityToWork.first
        val dishesList = if (dishAndPriorityToWork.second) toyotaDishes else fordDishes

        if (dish.getState() == DishState.DRY) {
            println("Dish ${dish.getName()} has been cleaned")
            return
        }

        val nextState = when (dish.getState()) {
            DishState.DIRTY -> DishState.SCRAPED
            DishState.SCRAPED -> DishState.WASHED
            DishState.WASHED -> DishState.RINSED
            DishState.RINSED -> DishState.DRY
            DishState.DRY -> TODO()
        }

        println("Dish ${dish.getName()} was ${dish.getState()} and now is $nextState")

        dishesList.add(dish.apply { setState(nextState) })
    }

    private fun getDishAndPriorityToWork(): Pair<Dish, Boolean> {
        return if (toyotaDishes.isNotEmpty()) {
            Pair(toyotaDishes.removeAt(0), true)
        } else if (fordDishes.isNotEmpty()) {
            Pair(fordDishes.removeAt(0), false)
        } else {
            throw IllegalStateException("No dishes to work")
        }
    }
}