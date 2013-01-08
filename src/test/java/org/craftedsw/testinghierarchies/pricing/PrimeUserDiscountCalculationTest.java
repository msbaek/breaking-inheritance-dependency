package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.craftedsw.testinghierarchies.builder.UserBuilder.aUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeUserDiscountCalculationTest {
    private PrimeUserDiscountCalculation primeUserDiscountCalculation;
    private User noPrimeUser;
    private User primeUser;

    @Before
    public void initialize() {
        primeUserDiscountCalculation = new PrimeUserDiscountCalculation();
        noPrimeUser = aUser()
                .prime(false)
                .build();
        primeUser = aUser()
                .prime(true)
                .build();
    }

    @Test
    public void
    should_not_apply_discount_if_user_is_not_prime_user() {
        double returnedValue = primeUserDiscountCalculation.calculateDiscount(noPrimeUser);
        assertThat(returnedValue, is(0d));
    }

    @Test
    public void
    should_apply_discount_if_user_is_not_prime_user() {
        double returnedValue = primeUserDiscountCalculation.calculateDiscount(primeUser);
        assertThat(returnedValue, is(10d));
    }
}
