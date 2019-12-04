# Problem Description can be found at https://www.codechef.com/NOV19B/problems/SC31

import java.io.BufferedReader;
import java.io.InputStreamReader;

class WeaponValue {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			char[][] data = new char[n][10];
			for (int i = 0; i < n; i++)
				data[i] = in.readLine().toCharArray();
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < 10; j++) {
					if (data[0][j] == data[i][j])
						data[0][j] = '0';
					else
						data[0][j] = '1';
				}
			}
			int count = 0;
			for(int i=0;i<10;i++)
				if(data[0][i]=='1')count++;
			System.out.println(count);
		}

		in.close();
	}

}
