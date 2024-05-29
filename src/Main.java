import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        String[] romanNumbers = new String[] {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int[] arabianNumbers = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
        String result = null;
        int operatorIndex = getOperatorIndex(input);
        char operator = input.charAt(operatorIndex);
        String[] inputNumbers = getNumbers(input, String.valueOf(operator));
        return finalCalculation(romanNumbers,arabianNumbers,inputNumbers,operator,input);
    }
    public static int getOperatorIndex(String input) throws Exception {
        char[] charArr = input.toCharArray();
        int counter = 0;
        int operatorIndex = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '+' || charArr[i] == '-' || charArr[i] == '*' || charArr[i] == '/') {
                operatorIndex = i;
                counter++;
            }
        }
        return verifyOperatorSymbols(operatorIndex, counter);
    }

    public static int verifyOperatorSymbols(int operatorIndex, int counter) throws Exception {
        if (counter == 1) {
            return operatorIndex;
        } else {
            throw new Exception();
        }
    }

    public static String[] getNumbers(String input, String operator) {
        char[] charArray = input.toCharArray();
        boolean digit = false;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i]) == true) {
                digit = true;
            }
        }
        String op = operator;
        if (operator.equals("+")) {
            op = "\\+";
        } else if (operator.equals("*")) {
            op = "\\*";
        }
        String[] numbers = input.split(op);
        return numbers;
    }
    public static int arithmeticOperations(int num1, int num2, char operator) throws Exception {
        int result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:throw new Exception();
        }
        return result;
    }
    public static String finalCalculation(String[] romanNumbers, int[] arabianNumbers, String[] inputNumbers, char operator,String input) throws Exception {
        int lValue = 0;
        int rValue = 0;
        String num1 = inputNumbers[0];
        String num2 = inputNumbers[1];
        boolean digit = false;
        char[] charArr = input.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i]) == true) {
                digit = true;
            }
        }
        if (digit == true && (Integer.parseInt(num1) >= 0 && Integer.parseInt(num1) <= 10) && (Integer.parseInt(num2) >= 0 && Integer.parseInt(num2) <= 10)){
            return String.valueOf(arithmeticOperations(Integer.parseInt(num1), Integer.parseInt(num2), operator));
        }
        else {
            int count = 0;
            for (int i = 1; i <= 10; i++) {
                if (num1.equals(romanNumbers[i])) {
                    lValue = i;
                    count ++;
                }
                if (num2.equals(romanNumbers[i])) {
                    rValue = i;
                    count ++;
                }
            }
            if (count == 2){
                if(arithmeticOperations(lValue, rValue, operator) >= 1){
                    return romanNumbers[arithmeticOperations(lValue, rValue, operator)];
                }
                else{
                    throw new Exception();
                }
            }
            else{
                throw new Exception();
            }
        }
    }
}


