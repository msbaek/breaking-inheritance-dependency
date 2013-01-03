package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;
import org.craftedsw.testinghierarchies.domain.User;

public abstract class PricingService {
    public double calculatePrice(ShoppingBasket shoppingBasket, User user, String voucher) {
        double discount = calculateDiscount(user);
        double total = 0;
        for (ShoppingBasket.Item item : shoppingBasket.items()) {
            total += calculateProductPrice(item.getProduct(), item.getQuantity());
        }
        total = applyAdditionalDiscounts(total, user, voucher);
        return total * ((100 - discount) / 100);
    }

    protected abstract double calculateDiscount(User user);

    protected abstract double calculateProductPrice(Product product, int quantity);

    protected abstract double applyAdditionalDiscounts(double total, User user, String voucher);
}

