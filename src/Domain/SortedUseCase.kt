package Domain

import RepositoryImpl

class SortedUseCase(val product: RepositoryImpl) {
    fun sortedUseCase(): List<Product>{
        return product.listAndSort().sortedByDescending { it.name }
    }
}