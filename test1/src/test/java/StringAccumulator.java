import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Qi Wang
 * @create 2024/7/22
 */
public class StringAccumulator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*?)\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                String delimiterPart = matcher.group(1);
                numbers = matcher.group(2);
                if (delimiterPart.contains("|")) {
                    String[] delimiterArray = delimiterPart.split("\\|");
                    StringBuilder delimiterBuilder = new StringBuilder();
                    for (String delim : delimiterArray) {
                        if (delimiterBuilder.length() > 0) {
                            delimiterBuilder.append("|");
                        }
                        delimiterBuilder.append(Pattern.quote(delim));
                    }
                    delimiter = delimiterBuilder.toString();
                } else {
                    delimiter = Pattern.quote(delimiterPart);
                }
            }
        }

        String[] tokens = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    negatives.add(number);
                } else if (number <= 1000) {
                    sum += number;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString());
        }

        return sum;
    }
}
