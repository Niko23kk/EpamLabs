package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello " + name);

        for (String arg : args) {
            System.out.println(arg);
        }

        System.out.println("Введите число от 1 до 12");

        int n;

        try {
            n = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Не число");
            return;
        }

        for (int k = 0; k <= n; k++) {
            System.out.print(k + " ");
        }

        for (int k = 0; k <= n; k++) {
            System.out.println(k);
        }

        int sum = 0;
        for (String k : args) {
            try {
                sum += Integer.parseInt(k);
            } catch (Exception e) {
                System.out.println("Не число");
            }
        }

        String[] month = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        System.out.println(month[n - 1]);

        /*Oprional Task 1 */
        int[] array = {45, 12, 34, 97, 102, 5, 9, 55,222};
        int max = 0;
        int min = Integer.toString(array[0]).length();

        for (int num : array) {
            if (Integer.toString(num).length() > Integer.toString(max).length()) {
                max = num;
            }

            if (Integer.toString(num).length() < Integer.toString(min).length()) {
                min = num;
            }
        }

        System.out.println("Max " + max + " " + Integer.toString(max) + "\n" + "Min " + min + " " + Integer.toString(min));

        int t;
        int[] asc =new int[array.length];
        int[] desc = new int[array.length];
        System.arraycopy(array,0,asc,0,array.length);
        System.arraycopy(array,0,desc,0,array.length);
        int sumarray = 0;


        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if (asc[j] < asc[i]) {
                    t = asc[i];
                    asc[i] = asc[j];
                    asc[j] = t;
                }
                if (desc[j] > desc[i]) {
                    t = desc[i];
                    desc[i] = desc[j];
                    desc[j] = t;
                }
            }
            sumarray += Integer.toString(array[i]).length();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(asc[i]);
        }
        for (int i = 0; i < array.length ; i++) {
            System.out.println(desc[i]);
        }

        System.out.println();

        for (int num : array) {
            if (Integer.toString(num).length() < (double) sumarray / array.length)
                System.out.println(num);
        }

        for (int num : array) {
            if (Integer.toString(num).length() > (double) sumarray / array.length)
                System.out.println(num);
        }

        System.out.println();
        int[] count=new int[array.length];

        for (int k=0;k<array.length;k++) {
            StringBuilder str=new StringBuilder(Integer.toString(array[k]));
            count[k]=(int)str.chars().distinct().count();
        }

        int indexMinLenght=0;
        int minelement=count[0];
        for (int k=1;k<array.length;k++) {
            if(count[k]<count[k-1]) {
                indexMinLenght = k;
            }
        }
        System.out.println("С наименьшим количесвтом цифр число- "+ array[indexMinLenght]);

        /*Optional Task 2 */
        int[][] a=new int[n][n];
        Random rand=new Random();
        int startrand=-10,endrand=10;

        for (int i=0;i<a.length;i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = startrand+rand.nextInt(endrand - startrand - 1);
            }
        }
        for (int i=0;i<a.length;i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        int countasc=0;
        int curcountascrow;
        int curcountasccolumn;

        for (int i=0;i<a.length;i++) {
            curcountascrow=0;
            curcountasccolumn=0;
            for (int j = 1; j < a.length; j++) {
                if(a[i][j-1]<a[i][j])
                    curcountascrow++;
            }
            for (int j = 1; j < a.length; j++) {
                if(a[j-1][i]<a[j][i])
                    curcountasccolumn++;
            }
            if(curcountascrow>countasc)
            {
                countasc=curcountascrow;
            }
            if(curcountascrow>countasc)
            {
                countasc=curcountasccolumn;
            }
        }

        System.out.print(countasc);

        int [] arraysum=new int[n];
        int indexstart,indexend;

        for (int i=0;i<a.length;i++) {
            indexstart=0;
            indexend=0;

            for (int j=0;j<a.length && indexstart==0;j++) {
                if (a[i][j] % 2 == 0) {
                    indexstart = j;
                }
            }

            for (int j = a.length-1 ; j >= 0 && indexend==0; j--) {
                if(a[i][j]%2==0)
                {
                    indexend=j;
                }
            }

            if(indexstart<indexend)
            {
                for(++indexstart;indexstart<indexend;indexstart++)
                {
                    arraysum[i]+=a[i][indexstart];
                }
            }
            else
                arraysum[i]=0;
        }

        for(int k : arraysum)
        {
            System.out.println(k);
        }
    }
}
