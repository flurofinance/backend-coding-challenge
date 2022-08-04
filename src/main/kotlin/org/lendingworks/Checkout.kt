package org.lendingworks

class Checkout {
    val products: MutableList<Char> = mutableListOf()
    fun total(): Int {
        var total = 0
        for (item in products) {
            if (item == 'A') {
                total += 50
            } else if (item == 'B') {
                total += 75
            }
        }
        return total
    }

    fun add(sku: Char) {
        products.add(sku)
    }
}