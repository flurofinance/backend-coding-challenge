package org.lendingworks

class Prices {
    val products: MutableList<Char> = mutableListOf()
    fun total(): Int {
        var total = 0
        for (item in products) {
            if (item == 'A') {
                total += 50
            } else if (item == 'B') {
                total += 75
            } else if (item == 'C') {
                total += 25
            } else if (item == 'D') {
                total += 150
            } else if (item == 'E') {
                total += 200
            }
        }
            total -= 25 * products.filter{it == 'B'}.count() / 2
            total -= 25 * products.filter{it == 'C'}.count() / 4
            total -= 50 * minOf(products.filter{it == 'D'}.count(),products.filter{it == 'E'}.count())
        return total
    }

    fun add(sku: Char) {
        products.add(sku)
    }
}