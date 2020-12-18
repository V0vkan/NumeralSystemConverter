package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);

        int sourceRadix;
        String number;
        int targetRadix;

        if (scanner.hasNextInt()) {
            sourceRadix = scanner.nextInt();
        } else {
            System.out.println("Error");
            return;
        }

        if (scanner.hasNext()) {
            number = scanner.next();
        } else {
            System.out.println("Error");
            return;
        }

        if (scanner.hasNextInt()) {
            targetRadix = scanner.nextInt();
        } else {
            System.out.println("Error");
            return;
        }


        if (sourceRadix < 1 || sourceRadix > 36 || targetRadix < 1 || targetRadix > 36) {
            System.out.println("Error");
        } else {
            System.out.println(converter.numbersConverter(sourceRadix, number, targetRadix));
        }
    }
}
