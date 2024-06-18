package br.com.diogoritmos

class Dish(private var name: String) {
    private var state: DishState = DishState.DIRTY;

    enum class DishState {
        DIRTY, SCRAPED, WASHED, RINSED, DRY;
    }

    fun getName(): String {
        return name
    }

    fun getState(): DishState {
        return state
    }

    fun setState(state: DishState) {
        this.state = state
    }
}