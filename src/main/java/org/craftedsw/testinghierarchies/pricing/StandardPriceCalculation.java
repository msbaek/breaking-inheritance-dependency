package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;

public class StandardPriceCalculation implements PricingCalculation {
    public StandardPriceCalculation() {
    }

    public double calculateProductPrice(Product product, int quantity) {
        return product.getPrice() * quantity;
    }
}