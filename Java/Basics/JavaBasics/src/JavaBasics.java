import java.util.ArrayList;

public class JavaBasics {
    public static void main(String[] args) {


        int[] x = {1, 5, 10, 7, -2};
        ArrayList<Integer> oddArray = new ArrayList<>();
//        printFromTo(1, 255);
//        printOddBetween(1, 255);
//        printSum(0, 255);
//        iterateThrough(x);
//        System.out.println(findMax(x));
//        System.out.println(findAverage(x));
//        getAllOddInRange(0, 255, oddArray);
//        System.out.println(oddArray);
//        System.out.println(greaterThanY(x, 6));
//        iterateThrough(squareValues(x));
//        iterateThrough(eliminateNegatives(x));
//        System.out.println(findMinMaxAverage(x));
//        iterateThrough(shiftToFrontByOne(x));

    }

    public static void printFromTo(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }

    public static void printOddBetween(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void printSum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void iterateThrough(int[] x) {
        for (int number : x) {
            System.out.println(number);
        }
    }

    public static int findMax(int[] x) {
        int max = x[0];
        for (int number : x) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }


    public static int sumArray(int[] x) {
        int sum = 0;
        for (int number : x) {
            sum += number;
        }
        return sum;
    }


    public static double findAverage(int[] x) {
        return (double) sumArray(x) / x.length;
    }

    public static void getAllOddInRange(int start, int end, ArrayList<Integer> oddArray) {
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                oddArray.add(i);
            }
        }
    }

    public static ArrayList<Integer> greaterThanY(int[] x, int y) {
        ArrayList<Integer> mylist = new ArrayList<>();
        for (int number : x) {
            if (number > y) {
                mylist.add(number);
            }
        }
        return mylist;
    }


    public static int[] squareValues(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] * x[i];
        }
        return x;
    }


    public static int[] eliminateNegatives(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] < 0 ? 0 : x[i];
        }
        return x;
    }

    public static int findMin(int[] x) {
        int min = x[0];
        for (int number : x) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static ArrayList<Object> findMinMaxAverage(int[] x) {
        ArrayList<Object> myArraylist = new ArrayList<>();
        myArraylist.add(findMin(x));
        myArraylist.add(findMax(x));
        myArraylist.add(findAverage(x));
        return myArraylist;
    }

    public static int[] shiftToFrontByOne(int[] x) {

        int[] arr = new int[x.length];
        for (int i = 0; i < x.length - 1; i++) {
            arr[i] = x[i + 1];
        }
        return arr;

    }


}