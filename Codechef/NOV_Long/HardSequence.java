# Problem Description can be found at https://www.codechef.com/NOV19B/problems/HRDSEQ

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class HardSequence {

	static FastReader in = new FastReader();

	public static void main(String[] args) throws Exception{
		int[] arr = new int[128];
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, List<Integer>> istorer = new HashMap<>();
		arr[0] = 0;
		map.put(0, 1);
		List<Integer> test = new LinkedList<>();
		test.add(0);
		istorer.put(0, test);
		for (int i = 1; i < 128; i++) {
			int x = arr[i - 1];
			if (map.get(x) > 1) {
				List<Integer> val = istorer.get(x);
				arr[i] = i - 1 - val.get(val.size() - 2);
				if (map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i]) + 1);
					List<Integer> st = istorer.get(arr[i]);
					st.add(i);
					istorer.put(arr[i], st);
				} else {
					List<Integer> st = new LinkedList<>();
					st.add(i);
					map.put(arr[i], 1);
					istorer.put(arr[i], st);
				}
			} else {
				arr[i] = 0;
				map.put(0, map.get(0) + 1);
				List<Integer> val = istorer.get(0);
				val.add(i);
				istorer.put(0, val);
			}
		}
		
		int t = in.nextInt();
		while(t-- > 0)
		{
			int n = in.nextInt();
			int count=0;
			for(int i=0;i<=n-1;i++)
				if(arr[i]==arr[n-1])count++;
			System.out.println(count);
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

		public String readLine(int param) throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			if (param > 0)
				read();
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt).trim();
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
