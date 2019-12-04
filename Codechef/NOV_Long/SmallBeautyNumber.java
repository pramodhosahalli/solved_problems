# Problem Description can be found at https://www.codechef.com/NOV19B/problems/LSTBTF


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

class SmallBeautyNumber {

	static FastReader in = new FastReader();

	public static void main(String[] args) throws Exception {
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			if (n == 1) {
				System.out.println(1);
				continue;
			}
			if (n == 2) {
				System.out.println(34);
				continue;
			}
			int k = (int) Math.sqrt(n);
			if (k * k == n) {
				for (int i = 0; i < n; i++)
					System.out.print("1");
				System.out.println();
				continue;
			}
			System.out.println(compute(n, k));
		}
	}

	private static String compute(int n, int k) {
		char[] arr = new char[n];
		Arrays.fill(arr, '1');
		long[] brr = isPerfectSquare(arr);
		if(brr[0]*brr[0]==brr[1])return String.valueOf(arr);
		return getNextValueOf(arr,brr[1]);
	}

	private static String getNextValueOf(char[] arr,long count) {
		
		int i = arr.length-1;
		while(i>=0)
		{
			int val= arr[i]-'0';
			count=count-((long)val*val);
			if(arr[i]!='9')
			{
				arr[i]=(char)(arr[i]+1);
				val= arr[i]-'0';
				count=count+((long)val*val);				
				for(int j=i+1;j<arr.length;j++){
					arr[j]=arr[i];
					count=count+((long)val*val);
				}
				long k = (long)Math.sqrt(count);
				if(k*k==count)break;
				i=arr.length;
			}
			i-=1;
		}
		return String.valueOf(arr);
	}

	private static long[]isPerfectSquare(char[] arr) {
		long count = 0;
		for (char c : arr)
			count += (long)(c - '0') * (c - '0');
		return new long[]{ (long)Math.sqrt(count),count};
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
