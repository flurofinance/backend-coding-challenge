package org.lendingworks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckoutTests {
    @Test
    fun `can create empty checkout`() {
        // given
        val checkout = Checkout()
        // when
        val total = checkout.total()
        // then
        assertEquals(0, total)
    }

    @Test
    fun `can add a single product`() {
        // given
        val checkout = Checkout()
        // when
        checkout.add('A')
        // then
        assertEquals(50, checkout.total())
    }

    @Test
    fun `can add multiple of the same product`() {
        // given
        val checkout = Checkout()
        // when
        checkout.add('A')
        checkout.add('A')
        checkout.add('A')
        // then
        assertEquals(150, checkout.total())
    }

    @Test
    fun `can add multiple different types of product`() {
        // given
        val checkout = Checkout()
        // when
        checkout.add('A')
        checkout.add('A')
        checkout.add('B')
        checkout.add('B')
        // then
        assertEquals(225, checkout.total())
    }

    @Test fun `can apply a single discount to a single product`() {
        // given
        val checkout = Checkout()
        // when
        checkout.add('B')
        checkout.add('B')
        // then
        assertEquals(125, checkout.total())
    }

    @Test fun `can apply multiple discounts to a single product`() {
        // given
        val checkout = Checkout()
        // when
        checkout.add('B')
        checkout.add('B')
        checkout.add('B')
        checkout.add('B')
        // then
        assertEquals(250, checkout.total())
}

    @Test fun `can apply multiple discounts to multiple products`() {
        // given
        val checkout = Checkout()
        // when
        checkout.add('B')
        checkout.add('B')
        checkout.add('B')
        checkout.add('B')
        checkout.add('C')
        checkout.add('C')
        checkout.add('C')
        checkout.add('C')
        // then
        assertEquals(325, checkout.total())
    }

    @Test fun `can apply 'meal-deal' discount to multiple products`() {
        // given
        val checkout = Checkout()
        // when
        checkout.add('D')
        checkout.add('E')
        // then
        assertEquals(300, checkout.total())
    }
}