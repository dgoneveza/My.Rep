import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mass = new String[5];


        int num1 = 0;
        int num2 = 0;
        int rimChis1 = 0;
        int rimChis2 = 0;
        String s;
        int x = 0;
        int n1 = 0;
        int n2 = 0;
        String[] arab = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

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
        Pattern pattern = Pattern.compile("\\b[IVXLCDM]+\\b");
        Matcher matcher = pattern.matcher(viraj);

        if (matcher.find()) {


            rimChis1 = Arrays.asList(rim).indexOf(mass[0]);
            rimChis2 = Arrays.asList(rim).indexOf(mass[1]);
            if ((rimChis1 > 11) | (rimChis2 > 11) | (rimChis2 < 1) | (rimChis1 < 1))
                throw new RuntimeException("Числа должны быть до от 1 до 10 включительно.");
            if (rimChis1 > 0 | rimChis2 > 0){

                n1 = rimChis1;
                n2 = rimChis2;


            s = calc(n1, viraj, n2);
            x = Integer.parseInt(s);
                System.out.println(rim[x]);

//Тут было исключение

        }
    }


            Pattern pattern1 = Pattern.compile("[0-9]");// поменял 1 на 0
            Matcher matcher1 = pattern1.matcher(viraj);


            if (matcher1.find()) {

                num1 = Integer.parseInt(mass[0]);
                num2 = Integer.parseInt(mass[1]);

                if ((num1 > 11 | num1 < -11) | (num2 > 11 | num2 < -11))
                    throw new RuntimeException("Числа должны быть от -10 до 10 включительно.");


                n1 = num1;
                n2 = num2;

                s = calc(n1, viraj, n2);
                //Вызов функции
                // тут фраг что лежит в функции

                System.out.println(s);
            }



    }

    public static String calc(int n1, String viraj, int n2) {
        int result = 0;
        if (viraj.contains("+")) {
            result = n1 + n2;
        }
        if (viraj.contains("-")) {
            result = n1 - n2;
        }
        if (viraj.contains("*")) {
            result = n1 * n2;
        }
        if (viraj.contains("/")) {
            result = n1 / n2;
        }


        String resultStr = String.valueOf(result);
        return resultStr;
    }

}
