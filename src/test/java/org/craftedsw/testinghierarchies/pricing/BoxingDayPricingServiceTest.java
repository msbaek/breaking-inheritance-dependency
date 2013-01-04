package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;
import org.junit.Test;

import static org.craftedsw.testinghierarchies.builder.ProductBuilder.aProduct;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoxingDayPricingServiceTest {
    private TestableBoxingDayPricingService boxingDayPricingService = new TestableBoxingDayPricingService();

    @Test
    public void
    should_apply_boxing_day_discount_on_product_price() {
        Product book = aProduct().costing(10).build();

        double price = boxingDayPricingService.calculateProductPrice(book, 1);

        assertThat(price, is(6D));
    }

    @Test public void
    should_apply_boxing_day_discount_on_product_price_and_multiply_by_quantity() {
        Product book = aProduct().costing(10).build();

        double price = boxingDayPricingService.calculateProductPrice(book, 3);

        assertThat(price, is(18D));
    }

    private class TestableBoxingDayPricingService extends BoxingDayPricingService {

        @Override
        protected double calculateProductPrice(Product product, int quantity) {
            return super.calculateProductPrice(product, quantity);
        }

    }
}
