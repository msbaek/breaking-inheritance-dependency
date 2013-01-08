package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.User;

public abstract class PricingService {
    private PricingCalculation pricingCalculation;
    private VoucherDiscountCalculation voucherDiscountCalculation;

    public double calculatePrice(ShoppingBasket shoppingBasket, User user, String voucher) {
        double discount = calculateDiscount(user);
        double total = 0;
        for (ShoppingBasket.Item item : shoppingBasket.items()) {
            total += pricingCalculation.calculateProductPrice(item.getProduct(), item.getQuantity());
        }
        total = voucherDiscountCalculation.calculateVoucherDiscount(total, voucher);
        return total * ((100 - discount) / 100);
    }

    protected abstract double calculateDiscount(User user);

    protected abstract double applyAdditionalDiscounts(double total, String voucher);

    public void setPriceCalculation(PricingCalculation pricingCalculation) {
        this.pricingCalculation = pricingCalculation;
    }

    public void setVoucherDiscountCalculation(VoucherDiscountCalculation voucherDiscountCalculation) {
        this.voucherDiscountCalculation = voucherDiscountCalculation;
    }
}

