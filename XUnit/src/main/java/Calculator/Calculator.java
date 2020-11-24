package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operator = 0;
        double firstValue = 0;
        double secondValue = 0;

        Scanner input = new Scanner(System.in);
        MathMethods mathMethods = new MathMethods();


        System.out.println("1. +\n2. -\n3. *\n4. /\n5. %\n6. ^2\n7. sin\n8. cos\n9. tan\n0. exit");

        do {System.out.print("\nInput first number: ");
            firstValue = input.nextDouble();
            System.out.print("Input second number: ");
            secondValue  = input.nextDouble();
            System.out.println("Enter the operator!\n");
            operator = input.nextInt();
            switch(operator) {
                case 1: System.out.println(firstValue + " + " + secondValue + " = " + mathMethods.sumOfTwoValues(firstValue, secondValue) + "\n");
                    break;
                case 2: System.out.println(firstValue + " - " + secondValue + " = " + mathMethods.differenceBetweenTwoValues(firstValue, secondValue) + "\n");
                    break;
                case 3: System.out.println(firstValue + " * " + secondValue + " = " + mathMethods.multiplyTwoValues(firstValue, secondValue) + "\n");
                    break;
                case 4: System.out.println(firstValue + " / " + secondValue + " = " + mathMethods.divisionOfTwoValues(firstValue, secondValue) + "\n");
                    break;
                case 5: System.out.println(firstValue + " % " + secondValue + " = " + mathMethods.moduloOfTwoValues(firstValue, secondValue) + "\n");
                    break;
                case 6: System.out.println(firstValue + " ^2 = " + mathMethods.squaringValue(firstValue) + "\n");
                    break;
                case 7: System.out.println("sin(" + firstValue + ")" + " = " + mathMethods.sinOfValue(firstValue) + "\n");
                    break;
                case 8: System.out.println("cos(" + firstValue + ")" + " = " + mathMethods.cosOfValue(firstValue) + "\n");
                    break;
                case 9: System.out.println("tan(" + firstValue + ")" + " = " + mathMethods.tanOfValue(firstValue) + "\n");
                    break;
                default:  System.out.printf("Error! Enter correct operator.\n");
                    return;
            }
        } while (operator != 0);
    }
}
