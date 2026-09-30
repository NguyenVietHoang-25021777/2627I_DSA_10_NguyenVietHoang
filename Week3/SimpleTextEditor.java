package Week3;

import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder S = new StringBuilder();

        Deque<String> historyStack = new ArrayDeque<>();

        int q = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < q; i++) {
            String[] tokens = br.readLine().trim().split(" ");
            int type = Integer.parseInt(tokens[0]);

            switch (type) {
                case 1:
                    historyStack.push(S.toString());
                    String W = tokens[1];
                    S.append(W);
                    break;

                case 2:
                    historyStack.push(S.toString());
                    int kDelete = Integer.parseInt(tokens[1]);
                    S.delete(S.length() - kDelete, S.length());
                    break;

                case 3:
                    int kPrint = Integer.parseInt(tokens[1]);
                    System.out.println(S.charAt(kPrint - 1));
                    break;

                case 4:
                    if (!historyStack.isEmpty()) {
                        S = new StringBuilder(historyStack.pop());
                    }
                    break;
            }
        }
    }
}