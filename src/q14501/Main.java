package q14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] T,P,memo;
	
	public static void main(String[] args) throws IOException {
		int i,j, max;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		T = new int[N];
		P = new int[N];
		memo = new int[N];

		StringTokenizer st;
		
		for(i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(i=N-1;i>=0;i--) {
			if(i+T[i]-1 >= N) continue;
			if(i+T[i] == N) memo[i] = P[i];
			else {
				max = -1;
				for(j=i+T[i];j<N;j++) {
					max = Math.max(max, memo[j]);
				}
				memo[i] = max + P[i];
			}
		}

		Arrays.sort(memo);
		System.out.println(memo[N-1]);
		
		in.close();
	}
}
