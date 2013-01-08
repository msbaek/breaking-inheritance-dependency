package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.craftedsw.testinghierarchies.builder.UserBuilder.aUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDiscountPricingServiceTest {
    private UserDiscountPricingService userDiscountPricingService;
    private User noPrimeUser;
    private User primeUser;

    @Before
    public void initialize() {
        userDiscountPricingService = new UserDiscountPricingService();
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
        double returnedValue = userDiscountPricingService.calculateDiscount(noPrimeUser);
        assertThat(returnedValue, is(0d));
    }

    @Test
    public void
    should_apply_discount_if_user_is_not_prime_user() {
        double returnedValue = userDiscountPricingService.calculateDiscount(primeUser);
        assertThat(returnedValue, is(10d));
    }
}

