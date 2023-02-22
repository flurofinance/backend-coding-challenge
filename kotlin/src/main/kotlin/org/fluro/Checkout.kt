package org.fluro

data class Item(val sku: Char, val priceInPence: Int)

data class Stock(private val items: Set<Item>) {
    fun unitPrice(sku: Char) =
        items.firstOrNull { it.sku == sku }?.priceInPence
            ?: throw RuntimeException("sku $sku not found")
}

class Checkout(private val stock: Stock) {
    private val basket = mutableListOf<Char>()

    fun total(): Int = basket.sumOf { stock.unitPrice(it) }

    fun scanItem(sku: Char): Checkout {
        basket.add(sku)
        return this
    }
}
