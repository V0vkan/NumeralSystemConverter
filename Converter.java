package converter;

public class Converter {

    public String numbersConverter(int sRadix, String num, int tRadix) {
        String convertedNumber;
        String[] parts;

        if (sRadix == 1) {
            convertedNumber = Integer.toString(num.length(), tRadix);
        } else if (tRadix == 1) {
            convertedNumber = "1".repeat(Integer.parseInt(num));
        } else {
            if (num.contains(".")) {
                parts = num.split("\\.");
                int integerPart = Integer.parseInt(parts[0], sRadix);
                double fractionalPart = 0;
                for (int i = 0; i < parts[1].length(); i++) {
                    String part = Character.toString(parts[1].charAt(i));
                    fractionalPart += Integer.parseInt(part, sRadix) / Math.pow(sRadix, i + 1);
                }
                convertedNumber = Integer.toString(integerPart, tRadix) + ".";
                StringBuilder resultFractionalPart = new StringBuilder();

                for (int i = 0; i < 5; i++) {
                    fractionalPart *= tRadix;
                    int toAdd = (int) fractionalPart;
                    fractionalPart -= toAdd;
                    resultFractionalPart.append(Integer.toString(toAdd, tRadix));
                }

                convertedNumber += resultFractionalPart.toString();
            } else {
                convertedNumber = Integer.toString(Integer.parseInt(num, sRadix), tRadix);
            }
        }
        return convertedNumber;
    }
}
