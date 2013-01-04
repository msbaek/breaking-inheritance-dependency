package org.craftedsw.testinghierarchies.pricing;

import org.craftedsw.testinghierarchies.domain.Product;

/**
 * Created with IntelliJ IDEA.
 * User: msbaek
 * Date: 13. 01. 04.금요일
 * Time: 오후 1:57
 * To change this template use File | Settings | File Templates.
 */
public interface PricingCalculation {
    double calculateProductPrice(Product product, int quantity);
}
