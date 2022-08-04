package org.lendingworks

class Checkout {
    val products: MutableList<Char> = mutableListOf()
    fun total(): Int {
        return products.size * 75
    }

    fun add(sku: Char) {
        products.add(sku)
    }
}