package Domain

import RepositoryImpl

class ListUseCase(val product: RepositoryImpl) {
    fun listUseCase(): List<Product>{
        return product.listAndSort().shuffled()
    }
}