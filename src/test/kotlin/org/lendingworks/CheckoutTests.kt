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
        assertEquals(250, checkout.total())
    }
//
//    @Test
//    fun test2() {
//        Checkout('C', 'C', 'C') == 1.25
//    }
//
//    @Test
//    fun test1() {
//        Checkout('C', 'C', 'C') == 0.75
//    }
}