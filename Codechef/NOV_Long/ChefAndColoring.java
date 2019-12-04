# Problem Description can be found at https://www.codechef.com/NOV19B/problems/CAMC

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ChefAndColoring {

	static FastReader in = new FastReader();

	public static void main(String[] args) throws Exception {
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			int m = in.nextInt();
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int g = (i + 1) % (m);
				if (g == 0)
					g = m;
				arr[i] = in.nextInt();
				List<Integer> temp = null;
				if (map.containsKey(arr[i])) {
					temp = map.get(arr[i]);
					temp.add(g);
				} else {
					temp = new ArrayList<>();
					temp.add(g);
				}
				map.put(arr[i], temp);
			}
			Arrays.sort(arr);
			int diff = Integer.MAX_VALUE;
			
			if(n<=1000)
			{
				for (int i = 0; i <= n - m; i++) {
					int count = 0;
					int[] gf = new int[m + 1];
					for (int j = i; j < n; j++) {
						List<Integer> gp = map.get(arr[j]);
						for (int g : gp) {
							if (gf[g] == 0) {
								count++;
								gf[g] = 1;
								break;
							}
						}
						if (count == m) {
							diff = Math.min(diff, Math.abs(arr[j] - arr[i]));
							break;
						}
					}
				}
				System.out.println(diff);
				continue;
			}
			
			int start = 0;
			int count = 0;
			int[] gp = new int[m + 1];
			int[] mg = new int[n];

			for (int i = 0; i < n; i++) {
				mg[i]=0;
				int s = map.get(arr[i]).size();
				for (int x : map.get(arr[i])) {
					if (gp[x]==0||s==1) {
						if(gp[x]==0)count++;
						gp[x]++;
						mg[i] = x;
						break;
					}
				}
				while (count == m) {
					diff = Math.min(diff, Math.abs(arr[start] - arr[i]));
					while(mg[start]==0){start++;diff = Math.min(diff, Math.abs(arr[start] - arr[i]));}
					gp[mg[start]]--;
					if(gp[mg[start]]==0)count--;
					start++;					
					if(mg[start]==0 && count<m){
						for(int x : map.get(arr[start])){
							if (gp[x] == 0) {
								gp[x]=1;
								count++;
								mg[start] = x;
								break;
							}
						}
					}
				}
			}
			System.out.println(diff);
		}
	}

	static class FastReader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastReader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

}
