import Domain.Product

interface Repository {
    fun listAndSort(): List<Product>
    fun add(addProduct: Product): List<Product>
    fun sell(name: String): List<Product>
}

class RepositoryImpl() : Repository {
    val snowboard_1 = Product("Joint", 47)
    val snowboard_2 = Product("Atom", 44)
    val snowboard_3 = Product("Solomon", 51)
    val snowboard_4 = Product("Burton", 52)

    var listOfProduct = mutableListOf<Product>(snowboard_1, snowboard_2, snowboard_3, snowboard_4)

    override fun listAndSort(): List<Product> {
        return listOfProduct
    }

    override fun add(addProduct: Product): List<Product> {
        listOfProduct.add(addProduct)
        return listOfProduct
    }

    override fun sell(name: String): List<Product> {
        val sellProduct = listOfProduct.find { it.name == name }
        listOfProduct.remove(sellProduct)
        return listOfProduct
    }
}