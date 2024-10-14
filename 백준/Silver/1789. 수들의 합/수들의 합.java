import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long i = 0;
        while(true){
            if(sum > S) {
                i--;
                break;
            }
            i++;

            sum += i;
        }
        System.out.println(i);
    }
}