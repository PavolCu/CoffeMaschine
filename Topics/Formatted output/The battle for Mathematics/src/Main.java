import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        double pi = Math.PI;
        //write your code below
        double roundedPi = Math.round(pi * 1000.0) / 1000.0;
        System.out.printf("%.3f%n", roundedPi);
    }
}