package Week3;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static String isBalanced(String S) {
        // Write your code here
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> dic = new HashMap<>();
        dic.put(')', '(');
        dic.put(']', '[');
        dic.put('}', '{');

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!dic.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.size() == 0 || !stack.pop().equals(dic.get(ch))) {
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()) {return "YES";}
        else {return "NO";}
    }

}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
