import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	char[] arr = br.readLine().toCharArray();
        	if(arr.length == 1 && arr[0] == '0') break;
        	boolean check = false;
        	for(int i=0;i<arr.length;i++) {
        		if(arr[i] != arr[arr.length-i-1]) check = true;
        	}
        	
        	if(!check) System.out.println("yes");
        	else System.out.println("no");
        }
    }
}