package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;

public class StandardPriceCalculation {
    public StandardPriceCalculation() {
    }

    public double calculateProductPrice(Product product, int quantity) {
        return product.getPrice() * quantity;
    }
}