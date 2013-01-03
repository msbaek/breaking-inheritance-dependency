package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;

public class StandardPricingService extends VoucherPricingService {
    @Override
    protected double calculateProductPrice(Product product, int quantity) {
        return product.getPrice() * quantity;
    }
}
