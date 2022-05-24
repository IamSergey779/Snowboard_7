package Presenter

import Domain.*
import kotlin.system.exitProcess

class Presenter(
    val listProduct: ListUseCase,
    val sortedProduct: SortedUseCase,
    val addProduct: AddUseCase,
    val sellProduct: SellUseCase
) {
    fun ProcessingError(userInput: String): List<Product> {
        try {
            return PerfomUserCommand(userInput)
        } catch (E: IndexOutOfBoundsException) {
            println("Incorrect input!")
            exitProcess(1)
        }
    }

    fun PerfomUserCommand(userInput: String): List<Product> {
        if (userInput == "list") {
            return listProduct.listUseCase()
        } else if (userInput == "sorted") {
            return sortedProduct.sortedUseCase()
        } else if (userInput.startsWith("add")) {
            val array = userInput.split(' ')
            val nameAdd = array[1].replaceFirstChar { it.uppercase() }
            val priceAdd = array[2].toInt()
            val product = Product(nameAdd, priceAdd)
            return addProduct.addUseCase(product)
        } else if (userInput.startsWith("sell")) {
            val array = userInput.split(' ')
            val name = array[1].replaceFirstChar { it.uppercase() }
            return sellProduct.sellUseCase(name)
        } else if (userInput == "exit") {
            println("Exit progress!")
            exitProcess(0)
        } else {
            println("Exit program!")
            return listOf()
        }
    }
}