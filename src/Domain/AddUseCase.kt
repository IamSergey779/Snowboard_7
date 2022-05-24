package Domain

import RepositoryImpl

class AddUseCase(val product: RepositoryImpl) {
    fun addUseCase(addProduct: Product): List<Product>{
        return product.add(addProduct)
    }
}