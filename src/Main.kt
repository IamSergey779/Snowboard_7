import Domain.*
import Presenter.Presenter
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val listOfProduct = RepositoryImpl()
    val listProduct = ListUseCase(listOfProduct)
    val sortedProduct = SortedUseCase(listOfProduct)
    val addProduct = AddUseCase(listOfProduct)
    val sellProduct = SellUseCase(listOfProduct)
    val presenter = Presenter(listProduct, sortedProduct, addProduct, sellProduct)

    while (true) {
        println("Please enter one command: list, sorted, add, sell, exit")
        val userInput = readln().lowercase()
        println(userInput)
        val result = presenter.ProcessingError(userInput)
        if (result.isEmpty()) {
            exitProcess(1)
        } else {
            println(result)
        }
    }
}