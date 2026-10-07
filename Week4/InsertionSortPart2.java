package Week4;

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

class Result2 {


    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for (int i = 1; i < n; i++) {
            int temp = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > temp) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, temp);
            printList(arr);
        }
    }
    private static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            sb.append(list.get(j));
            if (j < list.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());

    }

}

public class InsertionSortPart2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result2.insertionSort2(n, arr);

        bufferedReader.close();
    }
}

