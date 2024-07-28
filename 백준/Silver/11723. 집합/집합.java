import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer> list = new HashSet<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String input = br.readLine();
			String[] tmp = input.split(" ");
			String s = tmp[0];
			int a = 0;
			if(tmp.length > 1) {
				a = Integer.parseInt(tmp[1]);
			}
			switch(s) {
			case "add":
				list.add(a);
				break;
			case "remove":
				list.remove(a);
				break;
			case "check":
				if(list.contains(a)) {
					bw.write("1\n");
				}
				else {
					bw.write("0\n");
				}
				break;
			case "toggle":
				if(list.contains(a)) {
					list.remove(a);
				}
				else {
					list.add(a);
				}
				break;
			case "all":
				list.clear();
				for(int j = 1;j <= 20;j++) {
					list.add(j);
				}
				break;
			case "empty":
				list.clear();
				break;
			}
		}
		
		br.close();
		bw.close();
	}
}