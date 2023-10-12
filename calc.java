// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class calc {

    public static void main(String[] args) {
        System.out.println("Введите выражение арабскими либо римскими цифрами. ");
        System.out.println("Цыфры должны быть одного алфавита и не больше 10 включительно.");
        Scanner sc = new Scanner(System.in);
        String[] mass = new String[1];

        String m1 = mass[0];



        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int result = 0;
        String[] rim = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};


        String viraj = sc.nextLine();

//Поменял фрагменты !!!
        mass = viraj.split("[*+/\\-]");

        if (mass.length != 2) {
            throw new RuntimeException("Должно быть два числа");
        }


        Pattern pattern1 = Pattern.compile("[0-9]");// поменял 1 на 0
        Matcher matcher1 = pattern1.matcher(viraj);


        if (matcher1.find()) {

            num1 = Integer.parseInt(mass[0]);
            num2 = Integer.parseInt(mass[1]);


            if ((num1 > 11 | num1 < -11) | (num2 > 11 | num2 < -11))
                throw new RuntimeException("Числа должны быть до от -10 до 10 включительно.");


        }

        if (viraj.contains("+")) {
            res = (num1 + num2);
        }
        if (viraj.contains("-")) {
            res = (num1 - num2);
        }
        if (viraj.contains("*")) {
            res = (num1 * num2);
        }
        if (viraj.contains("/")) {
            res = (num1 / num2);
        }
        System.out.println(res);

        Pattern pattern = Pattern.compile("\\b[IVXLCDM]+\\b");
        Matcher matcher = pattern.matcher(viraj);

        if (matcher.find()) {


            int rimChis1 = Arrays.asList(rim).indexOf(mass[0]);
            int rimChis2 = Arrays.asList(rim).indexOf(mass[1]);
            if ((rimChis1 > 11) | (rimChis2 > 11) | (rimChis2 < 1) || (rimChis1 < 1))
                throw new RuntimeException("Числа должны быть до от 1 до 10 включительно.");


            if (viraj.contains("+")) {
                result = (rimChis1 + rimChis2);
            }
            if (viraj.contains("-")) {
                result = (rimChis1 - rimChis2);
            }
            if (viraj.contains("*")) {
                result = (rimChis1 * rimChis2);
            }
            if (viraj.contains("/")) {
                result = (rimChis1 / rimChis2);
            }
//Тут было исключение
            if (result<=0) { throw new RuntimeException("В Римском алфавите нет нуля .");

            }
            System.out.println(rim[result]);
        }
    }
}
