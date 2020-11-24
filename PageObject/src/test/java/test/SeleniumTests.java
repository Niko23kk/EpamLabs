package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTests {
    @Test
    public void checkSaleWithPromocode(){
        Assert.assertTrue(orderPrice.getText().replaceAll("[^\\d.]", "").equals(
                Integer.toString(Integer.parseInt(orderSale.getText().replaceAll("[^\\d.]","")) * 10)));
    }
}
