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
        String s=null;
        int x=0;
        int n1 = 0;
        int n2 = 0;

        String[] rim = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};

        System.out.println("Введите математическое выражение !");
        String nabZnac = sc.nextLine();// доп перемен для функ calc
        String viraj = calc (nabZnac);


//Поменял фрагменты !!!
        mass = viraj.split("[*+/\\-]");

        if (mass.length != 2) {
            throw new RuntimeException("Должно быть два числа");
        }
        // Добавил строку что бы разделить программу
        //if(mass = )

        Pattern pattern = Pattern.compile("\\b[IVXLCDM]+\\b");
        Matcher matcher = pattern.matcher(viraj);

        if (matcher.find()) {


            rimChis1 = Arrays.asList(rim).indexOf(mass[0]);
            rimChis2 = Arrays.asList(rim).indexOf(mass[1]);
            if (rimChis1<=0 || rimChis2<=0)
                throw new RuntimeException("Должен быть либо арабские либо римские числа  ");
               if (rimChis1>0 || rimChis2>0) {

                   if ((rimChis1 > 10) && (rimChis2 > 10) && (rimChis2 < 1) && (rimChis1 < 1))
                       throw new RuntimeException("Числа должны быть до от 1 до 10 включительно.");

                   n1 = rimChis1;
                   n2 = rimChis2;


                   s = calcul(n1, viraj, n2);
                   x = Integer.parseInt(s);
                   if (x <= 0) {
                       throw new RuntimeException("В Римском алфавите нет нуля .");
                   }
                   System.out.println(rim[x]);
               }

        } else {
        Pattern pattern1 = Pattern.compile("[0-9]");// поменял 1 на 0
        Matcher matcher1 = pattern1.matcher(viraj);


        if (matcher1.find()) {
            try {
                num1 = Integer.parseInt(mass[0]);
                num2 = Integer.parseInt(mass[1]);
           }catch (NumberFormatException e){
            throw new ArithmeticException ("Числа должны быть целыми ");//ночь 25.10.23 выдаёт ошибку
            }

            if ((num1 > 11 | num1 < 1) | (num2 > 11 | num2 < 1) )
                throw new RuntimeException("Числа должны быть от -10 до 10 включительно.");




        }
        n1 = num1;
        n2 = num2;
        s = calcul(num1, viraj, num2);
        //Вызов функции
        // тут фраг что лежит в функции
            System.out.println(s);


        }

    }
    public static String calc(String input){
        return input;
    }


    public static String calcul(int n1, String viraj, int n2) {
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
