package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;
import org.junit.Test;

import static org.craftedsw.testinghierarchies.builder.ProductBuilder.aProduct;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StandardPriceCalculationTest {
    private StandardPriceCalculation standardPriceCalculation = new StandardPriceCalculation();

    @Test
    public void
    should_return_product_price_when_quantity_is_one() {
        Product book = aProduct().costing(10).build();

        double price = standardPriceCalculation.calculateProductPrice(book, 1);

        assertThat(price, is(10D));
    }

    @Test public void
    should_return_product_price_multiplied_by_quantity() {
        Product book = aProduct().costing(10).build();

        double price = standardPriceCalculation.calculateProductPrice(book, 3);

        assertThat(price, is(30D));
    }

    @Test public void
    should_return_zero_when_quantity_is_zero() {
        Product book = aProduct().costing(10).build();

        double price = standardPriceCalculation.calculateProductPrice(book, 0);

        assertThat(price, is(0D));
    }
}
