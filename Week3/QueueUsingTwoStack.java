package Week3;
import java.util.*;
import java.io.*;

public class QueueUsingTwoStack {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stackPush = new ArrayDeque<>();
        Deque<Integer> stackPop = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            int type = Integer.parseInt(s[0]);

            if (type == 1){
                int x = Integer.parseInt(s[1]);
                stackPush.push(x);
            } else {

                if (stackPop.isEmpty()){
                    while (!stackPush.isEmpty()){
                        stackPop.push(stackPush.pop());
                    }
                }

                if (type == 2){
                    stackPop.pop();
                } else if (type == 3){
                    System.out.println(stackPop.peek());
                }
            }
        }
    }
}
