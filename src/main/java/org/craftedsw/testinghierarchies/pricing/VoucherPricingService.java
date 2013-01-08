package org.craftedsw.testinghierarchies.pricing;

public abstract class VoucherPricingService extends UserDiscountPricingService {

    private VoucherService voucherService;

    @Override
    protected double applyAdditionalDiscounts(double total, String voucher) {
        double voucherValue = voucherService.getVoucherValue(voucher);
        double totalAfterValue = total - voucherValue;
        return (totalAfterValue > 0) ? totalAfterValue : 0;
    }

    public void setVoucherService(VoucherService voucherService) {
        this.voucherService = voucherService;
    }
}

