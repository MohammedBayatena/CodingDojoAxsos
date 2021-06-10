import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a Number: ");
        number = scanner.nextInt();
        fizzbuzz(number);
    }

    public static void fizzbuzz(int number) {
        if (number % 5 == 0 && number % 3 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else {
            System.out.println(number);
        }
    }


}
