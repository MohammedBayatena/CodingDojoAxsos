public class Pythagorean {
    public static void main(String[] args) {
        System.out.print(calculatePythagorean(2, 3));
    }

    public static double calculatePythagorean(int legA, int legB) {
        return Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
    }


}
