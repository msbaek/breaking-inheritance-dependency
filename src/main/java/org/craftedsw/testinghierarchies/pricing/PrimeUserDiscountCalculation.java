package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.User;

public class PrimeUserDiscountCalculation {
    public double calculateDiscount(User user) {
        int discount = 0;
        if (user.isPrime()) {
            discount = 10;
        }
        return discount;
    }
}
