package org.craftedsw.testinghierarchies.pricing;

public abstract class VoucherPricingService extends UserDiscountPricingService {

    private VoucherService voucherService;

    @Override
    protected double applyAdditionalDiscounts(double total, String voucher) {
        VoucherDiscountCalculation voucherDiscountCalculation = new VoucherDiscountCalculation(voucherService);
        return voucherDiscountCalculation.calculateVoucherDiscount(total, voucher);
    }

    public void setVoucherService(VoucherService voucherService) {
        this.voucherService = voucherService;
    }
}
