package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;

public class StandardPricingService extends VoucherPricingService {
    private final StandardPriceCalculation standardPriceCalculation = new StandardPriceCalculation();

    @Override
    protected double calculateProductPrice(Product product, int quantity) {
        return standardPriceCalculation.calculateProductPrice(product, quantity);
    }
}
