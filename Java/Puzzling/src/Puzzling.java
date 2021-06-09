import java.util.*;

public class Puzzling {

    public static void main(String[] args) {

        //#1
        int[] arr = {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
        System.out.println(String.format("Numbers larger than %d are : ", 10) + sumAndLargerThanN(arr, 10));
        //#2
        ArrayList<String> namelist = new ArrayList<>();
        Collections.addAll(namelist, "Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa");
        System.out.println(String.format("Names with length larger than %d are : ", 10) + shuffleAndLargerThanNCharacters(namelist, 10));
        //#3
        ArrayList<Character> alphabet = new ArrayList<>();
        generateAlphabet(alphabet);
        shuffleAndVowel(alphabet);
        //#4
        int[] randomnumbers = new int[10];
        randomnumbers = fillWithRandom(55, 100, randomnumbers.length);
        System.out.println("Random Numbers Array: " + Arrays.toString(randomnumbers));
        //#5
        Arrays.sort(randomnumbers);
        System.out.println("Sorted Random Numbers Array: " + Arrays.toString(randomnumbers));
        System.out.println("Min Value is: " + randomnumbers[0]);
        System.out.println("Max Value is: " + randomnumbers[randomnumbers.length - 1]);
        //#6
        System.out.println("Random String: " + generateString(5));
        //#7
        String[] randomWords = new String[10];
        Arrays.fill(randomWords, "");
        for (int i = 0; i < randomWords.length; i++) {
            randomWords[i] = randomWords[i].concat(generateString(5));
        }
        System.out.println("Randomly Generated Words Array: " + Arrays.toString(randomWords));
    }

    public static ArrayList<Integer> sumAndLargerThanN(int[] arr, int n) {

        ArrayList<Integer> largerThanN = new ArrayList<>();
        int sum = 0;
        for (int number : arr) {
            sum += number;
            if (number > n) {
                largerThanN.add(number);
            }
        }
        System.out.println("Sum is: " + sum);
        return largerThanN;
    }

    public static ArrayList<Object> shuffleAndLargerThanNCharacters(ArrayList<String> namelist, int n) {
        ArrayList<Object> largerThanNList = new ArrayList<>();
        Collections.shuffle(namelist);
        System.out.println("Names List: " + namelist);
        for (String item : namelist) {
            if ((item).length() > n)
                largerThanNList.add(item);
        }
        return largerThanNList;
    }

    public static void generateAlphabet(ArrayList<Character> alphabet) {
        char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char c : alphabetArray) {
            alphabet.add(c);
        }
    }

    public static void shuffleAndVowel(ArrayList<Character> alphabet) {
        Collections.shuffle(alphabet);
        System.out.println("First Element is : " + alphabet.get(0));
        System.out.println("Last Element is : " + alphabet.get(alphabet.size() - 1));
        switch (alphabet.get(0)) {
            case 'a', 'e', 'i', 'o', 'u' -> System.out.println("First Element is a vowel");
        }
    }

    public static int[] fillWithRandom(int min, int max, int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(max - min) + min;
        }
        return arr;
    }

    static String generateString(int length) {
        ArrayList<Character> alphabet = new ArrayList<>();
        generateAlphabet(alphabet);
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (alphabet.size() * Math.random());
            sb.append(alphabet.get(index));
        }
        return sb.toString();
    }


}