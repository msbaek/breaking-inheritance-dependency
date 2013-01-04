package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;

public class BoxingDayPricingService extends VoucherPricingService {
    private final BoxingDayPricingCalculation boxingDayPricingCalculation = new BoxingDayPricingCalculation();

    @Override
    protected double calculateProductPrice(Product product, int quantity) {
        return boxingDayPricingCalculation.calculateProductPrice(product, quantity);
    }
}
