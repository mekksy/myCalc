import java.util.Scanner;

class Solution {
    private int sol;
    public Solution(int varA, int varB, String operator) {

        switch (operator) {
            case "+" -> sol = varA + varB;
            case "-" -> sol = varA - varB;
            case "/" -> sol = varA / varB;
            case "*" -> sol = varA * varB;
        }
    }
    public int getSol() {
        return sol;
    }

}
public class main {
    public static void main(String[] args){
        System.out.println("Введите выражение: ");
        Scanner in = new Scanner(System.in);
        String userExpression = in.nextLine();
        String answer = calc(userExpression);
        System.out.println(answer);

    }
    public static String calc(String input){
        String answer = "";
        final int LOWLIMIT = 0;
        final int UPLIMIT = 10;
        String[] operation = input.split(" ");

        var a = operation[0];
        var operator = operation[1];
        var b = operation[2];
        Converter converter = new Converter();

        int romanDigitA = converter.romanToInt(a);
        int romanDigitB = converter.romanToInt(b);

        Solution solveRomans = new Solution(romanDigitA, romanDigitB, operator);

        int romansAnswer = solveRomans.getSol();
        answer = String.valueOf(romansAnswer);
/*      int arabDigitA = Integer.parseInt(a);
        int arabDigitB = Integer.parseInt(b);

        Solution solveArab = new Solution(arabDigitA, arabDigitB, operator);

        int arabAnswer = solveArab.getSol();
        answer = String.valueOf(arabAnswer);
*/
        return answer;
    }
}
