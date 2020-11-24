import Calculator.MathMethods;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests {
    @DataProvider(name = "DataTwoValuesTest")
    public static Object[][] dataToSumDifMultDivTwoValues() {
        return new Object[][] {{2, 5.001}, {-5.02, -5}, {23456, -1234}, {0.123, -0.123},{0.0000001,0.1231231}};
    }

    @DataProvider(name = "TrigonometryOperationData")
    public static Object[] trigonometryOperationData() {
        return new Object[] {2, -0.6};
    }

    @Test(dataProvider = "DataTwoValuesTest")
    public void sumOfTwoValuesTest(double x,double y) {
        Assert.assertEquals(x+y, MathMethods.sumOfTwoValues(x, y), 0.00001);
    }

    @Test(dataProvider = "DataTwoValuesTest")
    public void differenceOfTwoValuesTest(double x,double y) {
        Assert.assertEquals(x-y, MathMethods.differenceBetweenTwoValues(x, y), 0.00001);
    }

    @Test(dataProvider = "DataTwoValuesTest")
    public void multiplyTwoValuesTest(double x,double y) {
        Assert.assertEquals(x*y, MathMethods.multiplyTwoValues(x, y), 0.00001);
    }

    @Test(dataProvider = "DataTwoValuesTest")
    public void divisionOfTwoPositiveValuesTest(double x,double y) {
        Assert.assertEquals(x/y, MathMethods.divisionOfTwoValues(x, y), 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void divideByZeroTest() {
        MathMethods.divisionOfTwoValues(1, 0);
    }

    @Test
    public void moduloOfTwoValuesTest() {
        Assert.assertEquals(1, MathMethods.moduloOfTwoValues(25, 4), 0.00001);
    }

    @Test
    public void squaringOfNegativeValueTest() {
        Assert.assertEquals(625, MathMethods.squaringValue(-25), 0.00001);
    }

    @Test(dataProvider = "TrigonometryOperationData")
    public void sinValueTest(double value) {
        Assert.assertEquals(Math.sin(value), MathMethods.sinOfValue(value), 0.01);
    }

    @Test(dataProvider = "TrigonometryOperationData")
    public void cosValueTest( double value) {
        Assert.assertEquals(Math.cos(value), MathMethods.cosOfValue(value), 0.01);
    }

    @Test(dataProvider = "TrigonometryOperationData")
    public void tanValueTest(double value) {
        Assert.assertEquals(Math.tan(value), MathMethods.tanOfValue(value), 0.01);
    }

    @Test(dataProvider = "TrigonometryOperationData")
    public void ctanValueTest(double value) {
        Assert.assertEquals(Math.tan(1/value), MathMethods.ctanOfValue(value), 0.01);
    }
}
