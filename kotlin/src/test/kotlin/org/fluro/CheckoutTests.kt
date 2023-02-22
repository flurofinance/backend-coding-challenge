package org.fluro

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CheckoutTests {
    private val checkout = Checkout(
        Stock(
            setOf(Item('A', 50))
        )
    )

    @Test
    fun `can checkout single item`() {
        checkout.scanItem('A')

        assert(checkout.total() == 50)
    }

    @Test
    fun `can scan multiple items`() {
        checkout
            .scanItem('A')
            .scanItem('A')

        assert(checkout.total() == 100)
    }

    @Test
    fun `total throws an error if sku is not in stock`() {
        checkout.scanItem('Z')
        assertThrows<RuntimeException> {
            checkout.total()
        }
    }
}
