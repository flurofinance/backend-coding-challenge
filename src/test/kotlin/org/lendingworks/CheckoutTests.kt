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

//    @Test
//    fun test1() {
//        Checkout('C', 'C', 'C') == 0.75
//    }
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