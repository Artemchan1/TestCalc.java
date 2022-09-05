import java.util.Map;
import java.util.Set;

public class Converter {
    static Map<String, Integer> numbers = Map.ofEntries(
            Map.entry("I", 1),
            Map.entry("II", 2),
            Map.entry("III", 3),
            Map.entry("IV", 4),
            Map.entry("V", 5),
            Map.entry("VI", 6),
            Map.entry("VII", 7),
            Map.entry("VIII", 8),
            Map.entry("IX", 9),
            Map.entry("X", 10));

    public static Integer toArabic(String numRoman) throws Exception {
        if (numbers.get(numRoman) == null) {
            throw new Exception("Недопустимый диапазон");
        } else {return numbers.get(numRoman);}
    }

    public static String toRoman(Integer numArabic) {
        StringBuilder answer = new StringBuilder();
        if (numArabic/100 > 0) {
            int k = numArabic/100;
            for (int i = 0; i < k; i++) {
                answer.append("C");
            }
            numArabic %= 100;
        }
        if (numArabic/90 > 0) {
            int k = numArabic/90;
            for (int i = 0; i < k; i++) {
                answer.append("XC");
            }
            numArabic %= 90;
        }
        if (numArabic/50 > 0) {
            int k = numArabic/50;
            for (int i = 0; i < k; i++) {
                answer.append("L");
            }
            numArabic %= 50;
        }
        if (numArabic/40 > 0) {
            int k = numArabic/40;
            for (int i = 0; i < k; i++) {
                answer.append("XL");
            }
            numArabic %= 40;
        }
        if (numArabic/10 > 0) {
            int k = numArabic/10;
            for (int i = 0; i < k; i++) {
                answer.append("X");
            }
            numArabic %= 10;
        }
        Set<String> keys = numbers.keySet();
        for (String currentKey: keys) {
            if (numArabic.equals(numbers.get(currentKey))) {
                answer.append(currentKey);
            }
        }
        return answer.toString();
    }
}