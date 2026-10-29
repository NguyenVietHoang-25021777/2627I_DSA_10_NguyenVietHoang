package Week7;

import java.io.*;
import java.util.*;

public class JavaStringReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int i = 0;
        while (i <= A.length()/2 - 1 ) {
            char l = A.charAt(i);
            char r = A.charAt(A.length() - 1 - i);
            if (l == r) {
                i++;
            }
            else {
                System.out.println("No");
                break;
            }
        }
        if (i == A.length()/2) {
            System.out.println("Yes");
        }
    }
}
