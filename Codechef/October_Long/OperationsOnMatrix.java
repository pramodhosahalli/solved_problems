// Problem description can be found at https://www.codechef.com/OCT19B/problems/SAKTAN

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
class Solution {
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = toInt(in.readLine().trim());
		for (int __ = 0; __ < t; __++) {
			int[] arr = readInt1DArray(in);
			int n = arr[0];
			int m = arr[1];
			int q = arr[2];
			int rhash[] = new int[1000001];
			int chash[] = new int[1000001];
			int re = 0;
			int ro = 0;
			int ce = 0;
			int co = 0;
			int rem_r = 0;
			int rem_c = 0;
			
			for (int i = 0; i < q; i++) {
				int[] brr = readInt1DArray(in);
				rhash[brr[0]] += 1;
				chash[brr[1]] += 1;
			}
			
			for(int i=1;i<=n;i++){
				if(rhash[i]!=0 && rhash[i]%2==0)re+=1;
				if(rhash[i]!=0 && rhash[i]%2!=0)ro+=1;
			}
			for(int i=1;i<=m;i++){
				if(chash[i]!=0 && chash[i]%2==0)ce+=1;
				if(chash[i]!=0 && chash[i]%2!=0)co+=1;
			}
			rem_r = n-(re+ro);
			rem_c = m-(ce+co);
			long count = 0;
			count=((long)rem_r*co)+((long)rem_c*ro);
			count+=((long)re*co)+((long)ro*ce);
			System.out.println(count);
		}
		in.close();
	}

	private long gcd(long a, long b) {
		if (a == 0 || b == 0)
			return a + b;
		if (a > b)
			return gcd(a % b, b);
		return gcd(a, b % a);
	}

	private boolean[] seive(int n) {
		boolean[] arr = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			if (!arr[i]) {
				int j = i * i;
				for (; j <= n; j += i)
					arr[j] = true;
			}
		}
		return arr;
	}

	private static int[] readInt1DArray(BufferedReader rd) throws Exception {
		String[] ss = rd.readLine().trim().split(" ");
		int[] arr = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			arr[i] = toInt(ss[i]);
		return arr;
	}

	private static int[][] readInt2DArray(BufferedReader rd, int n)
			throws Exception {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = rd.readLine();
			for (int j = 0; j < n; j++)
				arr[i][j] = s.charAt(j) - '0';
		}
		return arr;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}

	private static long toLong(String s) {
		return Long.parseLong(s);
	}
}
