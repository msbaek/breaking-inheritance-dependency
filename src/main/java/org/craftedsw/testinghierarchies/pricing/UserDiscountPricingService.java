package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.User;

public class UserDiscountPricingService extends  PricingService {
    @Override
    protected double calculateDiscount(User user) {
        PrimeUserDiscountCalculation primeUserDiscountCalculation = new PrimeUserDiscountCalculation();
        return primeUserDiscountCalculation.calculateDiscount(user);
    }
}
