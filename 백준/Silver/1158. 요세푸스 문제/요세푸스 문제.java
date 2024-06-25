import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		int cnt = 0;
        while(!q.isEmpty()) {
            int tmp = q.poll();
            cnt++;
            
            if(cnt == k) {
                ans.add(tmp);
                cnt = 0;
            } else {
                q.add(tmp);
            }
        }
		System.out.print("<");
		for(int i=0;i<ans.size()-1;i++) {
			System.out.print(ans.get(i) + ", ");
		}
		System.out.print(ans.get(ans.size()-1));
		System.out.print(">");
	}

}
