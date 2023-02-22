package org.fluro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

class CheckoutTests {
    private Checkout checkout = new Checkout(
            new Stock(
                    new HashSet<>(Arrays.asList(new Item('A', 50))
                    )
            ));

    @Test
    public void canCheckoutSingleItem() {
        checkout.scanItem('A');

        assert (checkout.total() == 50);
    }

    @Test
    public void canScanMultipleItems() {
        checkout.scanItem('A')
                .scanItem('A');

        assert (checkout.total() == 100);
    }

    @Test
    public void totalThrowsAnErrorIfSkuIsNotInStock() {
        checkout.scanItem('Z');
        Assertions.assertThrows(RuntimeException.class, () ->
                checkout.total()
        );
    }
}
