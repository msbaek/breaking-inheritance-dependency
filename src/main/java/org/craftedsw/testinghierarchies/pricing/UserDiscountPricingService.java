package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.User;

public abstract class UserDiscountPricingService extends  PricingService {
    @Override
    protected double calculateDiscount(User user) {
        int discount = 0;
        if (user.isPrime()) {
            discount = 10;
        }
        return discount;
    }
}
