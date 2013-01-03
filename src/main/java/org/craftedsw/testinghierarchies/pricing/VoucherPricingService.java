package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.User;

public abstract class VoucherPricingService extends UserDiscountPricingService {

    private VoucherService voucherService;

    @Override
    protected double applyAdditionalDiscounts(double total, User user, String voucher) {
        double voucherValue = voucherService.getVoucherValue(voucher);
        double totalAfterValue = total - voucherValue;
        return (totalAfterValue > 0) ? totalAfterValue : 0;
    }

    public void setVoucherService(VoucherService voucherService) {
        this.voucherService = voucherService;
    }
}

