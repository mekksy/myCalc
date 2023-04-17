import java.util.TreeMap;

class Converter {
    static TreeMap<Character, Integer> romansKeyMap = new TreeMap<>();
    static TreeMap<Integer, String> arabsKeyMap = new TreeMap<>();

    public Converter(){
        romansKeyMap.put('I', 1);
        romansKeyMap.put('V', 5);
        romansKeyMap.put('X', 10);
        romansKeyMap.put('L', 50);
        romansKeyMap.put('C', 100);

        arabsKeyMap.put(1, "I");
        arabsKeyMap.put(4, "IV");
        arabsKeyMap.put(5, "V");
        arabsKeyMap.put(9, "IX");
        arabsKeyMap.put(10, "X");
        arabsKeyMap.put(40, "XL");
        arabsKeyMap.put(50, "L");
        arabsKeyMap.put(90, "XC");
        arabsKeyMap.put(100, "C");
    }

    public String intToRoman(int number) {
        StringBuilder roman = new StringBuilder();
        int arabKey;
        do {
            arabKey = arabsKeyMap.floorKey(number);
            roman.append(arabsKeyMap.get(arabKey));
            number -= arabKey;
        } while (number != 0);

        return roman.toString();
    }

    public int romanToInt(String romanDigit) {
        int end = romanDigit.length() - 1;
        char[] arr = romanDigit.toCharArray();
        int arabDigit;
        int result = romansKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabDigit = romansKeyMap.get(arr[i]);
            if (arabDigit < romansKeyMap.get(arr[i + 1]))
            {
                result -= arabDigit;
            } else {
                result += arabDigit;
            }
        }
        return result;
    }
}
