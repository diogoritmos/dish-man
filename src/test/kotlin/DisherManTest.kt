import br.com.diogoritmos.Dish
import br.com.diogoritmos.DisherMan
import kotlin.test.Test

class DisherManTest {
    @Test
    fun addDishWhenItIsPriorityAddsAnItemToToyotaDishes() {
        val fordDishes = mutableListOf<Dish>()
        val toyotaDishes = mutableListOf<Dish>()

        val disherMan = DisherMan(fordDishes, toyotaDishes)

        disherMan.addDish(Dish("Plate"), true)

        assert(fordDishes.size == 0)
        assert(toyotaDishes.size == 1)
    }

    @Test
    fun addDishWhenItIsNotPriorityAddsAnItemToFordDishes() {
        val fordDishes = mutableListOf<Dish>()
        val toyotaDishes = mutableListOf<Dish>()

        val disherMan = DisherMan(fordDishes, toyotaDishes)

        disherMan.addDish(Dish("Plate"))

        assert(fordDishes.size == 1)
        assert(toyotaDishes.size == 0)
    }
}