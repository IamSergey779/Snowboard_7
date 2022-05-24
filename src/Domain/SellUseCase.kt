package Domain

import RepositoryImpl

class SellUseCase(val product: RepositoryImpl) {
    fun sellUseCase(name: String): List<Product> {
        return product.sell(name)
    }
}