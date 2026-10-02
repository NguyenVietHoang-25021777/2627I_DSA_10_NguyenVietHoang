package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer  st = new StreamTokenizer(br);
        st.nextToken(); int n = (int) st.nval;

        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            st.nextToken();
            list.add((int)st.nval);
        }

        Collections.sort(list);
        int h_index = 0;
        for (int j = n - 1; j >= 0; j--) {
            int cnt = h_index;
            if (list.get(j) >= cnt + 1) {
                h_index += 1;
            }
        }

        System.out.println(h_index);
    }
}
