package br.com.diogoritmos

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val diogo = DisherMan()

    val plate = Dish("Plate")
    val fork = Dish("Fork")
    val knife = Dish("Knife")
    val coffeeMaker = Dish("Coffee Maker")

    diogo.addDish(plate)
    diogo.addDish(fork)
    diogo.addDish(knife)

    var counter = 0

    while (true) {
        try {
            diogo.doWork()
            counter++

            if (counter == 8) {
                diogo.addDish(coffeeMaker, true)
            }

            Thread.sleep(100)
        } catch (e: IllegalStateException) {
            println("The job is done!")
            break
        }
    }
}