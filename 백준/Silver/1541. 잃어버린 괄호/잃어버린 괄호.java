import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("-");
		int sum = Integer.MAX_VALUE;
        for(int i=0;i<s.length;i++){
            int tmp = 0;
            String[] str = s[i].split("\\+");

            for(int j=0;j<str.length;j++){
                tmp += Integer.parseInt(str[j]);
            }

            if(sum == Integer.MAX_VALUE){
                sum = 0;
                sum += tmp;
            }
            else{
                sum -= tmp;
            }
        }
		System.out.println(sum);
		
	}
}