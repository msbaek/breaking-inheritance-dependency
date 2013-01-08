package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VoucherPricingServiceTest {
    private static final User UNUSED_USER = null;
    private static final String NO_VOUCHER = null;
    private static final String TWENTY_POUNDS_VOUCHER = "20";

    @Mock
    private VoucherService voucherService;
    private TestableVoucherPricingService voucherPricingService;

    @Before
    public void initialise() {
        voucherPricingService = new TestableVoucherPricingService();
        voucherPricingService.setVoucherService(voucherService);
        when(voucherService.getVoucherValue(TWENTY_POUNDS_VOUCHER)).thenReturn(20D);
    }

    @Test
    public void
    should_not_apply_discount_if_no_voucher_is_received() {
        double returnedAmount = voucherPricingService.applyAdditionalDiscounts(1000, UNUSED_USER, NO_VOUCHER);

        assertThat(returnedAmount, is(1000D));
    }

    @Test public void
    should_subtract_voucher_value_from_total() {
        double returnedAmount = voucherPricingService.applyAdditionalDiscounts(30D, UNUSED_USER, TWENTY_POUNDS_VOUCHER);

        assertThat(returnedAmount, is(equalTo(10D)));
    }

    @Test public void
    shoudl_return_zero_if_voucher_value_is_higher_than_total() {
        double returnedAmount = voucherPricingService.applyAdditionalDiscounts(10D, UNUSED_USER, TWENTY_POUNDS_VOUCHER);

        assertThat(returnedAmount, is(equalTo(0D)));
    }


    private class TestableVoucherPricingService extends VoucherPricingService {

        @Override
        protected double applyAdditionalDiscounts(double total, User user, String voucher) {
            return super.applyAdditionalDiscounts(total, user, voucher);
        }
    }
}
