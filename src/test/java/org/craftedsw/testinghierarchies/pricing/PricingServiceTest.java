package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;
import org.craftedsw.testinghierarchies.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.testinghierarchies.builder.ProductBuilder.aProduct;
import static org.craftedsw.testinghierarchies.builder.ShoppingBasketBuilder.aShoppingBasket;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class PricingServiceTest {

    private static final String NO_VOUCHER = "";
    private static final String FIVE_POUNDS_VOUCHER = "5";

    private PricingService pricingService = new PricingService();
    private ShoppingBasket shoppingBasket;

    @Mock private PricingCalculation pricingCalculation;
    @Mock private VoucherDiscountCalculation voucherDiscountCalculation;
    @Mock private PrimeUserDiscountCalculation primeUserDiscountCalculation;

    @Before
    public void initialise() {
        this.pricingService.setPriceCalculation(pricingCalculation);
        this.pricingService.setVoucherDiscountCalculation(voucherDiscountCalculation);
        this.pricingService.setPrimerUserDiscountCalculation(primeUserDiscountCalculation);
    }

    @Test
    public void
    should_calculate_price_of_all_products() {
        Product book = aProduct().named("book").costing(10).build();
        Product kindle = aProduct().named("kindle").costing(80).build();
        shoppingBasket = aShoppingBasket()
                .with(2, book)
                .with(3, kindle)
                .build();

        double price = pricingService.calculatePrice(shoppingBasket, new User(), NO_VOUCHER);

        verify(pricingCalculation, times(1)).calculateProductPrice(book, 2);
        verify(pricingCalculation, times(1)).calculateProductPrice(kindle, 3);
    }

    @Test public void
    should_calculate_voucher_discount() {
        Product book = aProduct().named("book").costing(10).build();
        when(pricingCalculation.calculateProductPrice(book, 2)).thenReturn(20D);
        shoppingBasket = aShoppingBasket()
                .with(2, book)
                .build();

        double price = pricingService.calculatePrice(shoppingBasket, new User(), FIVE_POUNDS_VOUCHER);

        verify(voucherDiscountCalculation, times(1)).calculateVoucherDiscount(20, FIVE_POUNDS_VOUCHER);
    }

    @Test public void
    should_calculate_prime_user_discount() {
        Product book = aProduct().named("book").costing(10).build();
        shoppingBasket = aShoppingBasket()
                .with(2, book)
                .build();
        when(pricingCalculation.calculateProductPrice(book, 2)).thenReturn(20D);
        shoppingBasket = aShoppingBasket()
                .with(2, book)
                .build();

        double price = pricingService.calculatePrice(shoppingBasket, null, null);

        verify(primeUserDiscountCalculation, times(1)).calculateDiscount(null);
    }
}
