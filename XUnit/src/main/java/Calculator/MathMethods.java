package Calculator;

public class MathMethods {
    public static double sumOfTwoValues(double firstValue, double secondValue) {
        return firstValue + secondValue;
    }

    public static double differenceBetweenTwoValues(double firstValue, double secondValue) {
        return firstValue - secondValue;
    }

    public static double  multiplyTwoValues(double firstValue, double secondValue) {
        return firstValue * secondValue;
    }

    public static double  divisionOfTwoValues(double firstValue, double secondValue) {
        if (secondValue == 0)
            throw new IllegalArgumentException("Can't be divided by zero");
        return firstValue / secondValue;
    }

    public static double  moduloOfTwoValues(double firstValue, double secondValue) {
        return firstValue % secondValue;
    }

    public static double  squaringValue(double firstValue) {
        return Math.pow(firstValue, 2);
    }

    public static double  sinOfValue(double firstValue) {
        return Math.sin(firstValue);
    }

    public static double  cosOfValue(double firstValue) {
        return Math.cos(firstValue);
    }

    public static double tanOfValue(double firstValue) {
        return Math.tan(firstValue);
    }

    public static double ctanOfValue(double firstValue) {
        return Math.tan(1/firstValue);
    }
}
