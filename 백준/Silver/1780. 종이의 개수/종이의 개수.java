import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int n, white, black, minus;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		paper(0, 0, n);
		System.out.println(minus);
		System.out.println(white);
		System.out.println(black);
	}
	public static void paper(int x, int y, int size) {
		
		if(same(x, y, size)) {
			if(map[x][y] == 1) {
				black++;
			}
			else if(map[x][y] == 0){
				white++;
			}
			else {
				minus++;
			}
		}
		else {
			int newSize = size / 3;
			paper(x, y , newSize);
			paper(x, y + newSize , newSize);
			paper(x + newSize, y , newSize);
			paper(x + newSize, y + newSize , newSize);
			paper(x, y + newSize*2 , newSize);
			paper(x + newSize*2, y , newSize);
			paper(x + newSize*2, y + newSize , newSize);
			paper(x + newSize, y + newSize*2 , newSize);
			paper(x + newSize*2, y + newSize*2 , newSize);
			
		}
		
	}
	
	public static boolean same(int x, int y, int size) {
		if(n == 1) return true;
		
		for(int i=x;i<x + size;i++) {
			for(int j=y;j<y + size;j++) {
				if(map[i][j] != map[x][y]) return false;
			}
		}
		return true;
	}

}