package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;

public class BoxingDayPricingCalculation {
    public static final double BOXING_DAY_DISCOUNT = 0.60;

    public BoxingDayPricingCalculation() {
    }

    public double calculateProductPrice(Product product, int quantity) {
        return ((product.getPrice() * quantity) * BOXING_DAY_DISCOUNT);
    }
}