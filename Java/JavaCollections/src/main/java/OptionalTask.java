import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class OptionalTask {
    public static void firstTask() {

        ArrayList<String> stringsList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("D:\\Учеба\\5 сем\\EPAM\\EpamLabs\\Java\\JavaCollections\\text.txt")) {

            int c;
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            StringBuilder word = new StringBuilder();

            while ((c = isr.read()) != -1) {
                word.append((char) c);
            }

            stringsList= Arrays.stream(word.toString().split("\n")).collect(Collectors.toCollection(()->new ArrayList<>()));

            for (int i = stringsList.size()-1; i >= 0; i--) {
                System.out.println(stringsList.get(i));
            }

            try (FileOutputStream fos = new FileOutputStream("D:\\Учеба\\5 сем\\EPAM\\EpamLabs\\Java\\JavaCollections\\newtext.txt")) {

                for (int i = stringsList.size()-1; i >= 0; i--) {
                    fos.write(stringsList.get(i).getBytes());
                }

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void secondTask()
    {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> numberStack=new Stack<Integer>();
        int number= scanner.nextInt();

        for (String strNumber:Integer.toString(number).split("")) {
            numberStack.add(Integer.parseInt(strNumber));
        }

        for (int i=0;i<Integer.toString(number).split("").length;i++) {
            System.out.print(numberStack.pop());
        }
        System.out.println();
    }

    public static void sevenTask() {
        Stack<Character> stack = new Stack<>();
        String str = "(({{[][]()}}{}))";
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    System.out.println("there are more end brackets than start brackets");
                    return;
                }
                if (stack.peek() == '(' && c != ')' || stack.peek() == '[' && c != ']' || stack.peek() == '{' && c != '}') {
                    System.out.println("There is wrong! Next bracket must be as " + stack.pop() + " but we got this one " + c);
                    return;
                } else stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("there are more start brackets than end brackets");
            return;
        }
    }
}
