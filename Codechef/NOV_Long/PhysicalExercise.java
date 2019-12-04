# Problem Description can be found at https://www.codechef.com/NOV19B/problems/PHCUL

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PhysicalExercise {

	static FastReader in = new FastReader();

	static class Pair {
		int x;
		int y;

		Pair(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static void main(String[] args) throws Exception {
		int t = in.nextInt();
		while (t-- > 0) {
			int x = in.nextInt();
			int y = in.nextInt();

			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();

			List<Pair> data1 = new ArrayList<>();
			List<Pair> data2 = new ArrayList<>();
			List<Pair> data3 = new ArrayList<>();
			double[][] arr = new double[n][m];
			double[] sourceDistanceA = new double[n];
			double[] sourceDistanceB = new double[m];

			double[] minCDistanceA = new double[n];
			double[] minCDistanceB = new double[m];

			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				Pair pair = new Pair(a, b);
				data1.add(pair);
				sourceDistanceA[i]=getDistance(x, y, a, b);
			}
			for (int i = 0; i < m; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				Pair pair = new Pair(a, b);
				data2.add(pair);
				sourceDistanceB[i]=getDistance(x, y, a, b);
			}
			for (int i = 0; i < k; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				Pair pair = new Pair(a, b);
				data3.add(pair);
			}
			// ........................................
			for (int i=0;i<Math.max(n, m);i++) {
				Pair p1 = null;
				Pair p2 = null;
				if(i<n)p1=data1.get(i);
				if(i<m)p2=data2.get(i);
				double distance1 = Double.MAX_VALUE;
				double distance2 = Double.MAX_VALUE;
				for (Pair p : data3) {
					if(p1!=null)
					distance1 = Math.min(distance1, getDistance(p1.x, p1.y, p.x, p.y));
					if(p2!=null)
					distance2 = Math.min(distance2, getDistance(p2.x, p2.y, p.x, p.y));
				}
				if(p1!=null)minCDistanceA[i]=distance1;
				if(p2!=null)minCDistanceB[i]=distance2;
			}
			
			double minDistance = Double.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				Pair pair = data1.get(i);
				for (int j = 0; j < m; j++) {
					Pair p = data2.get(j);
					arr[i][j] = getDistance(pair.x, pair.y, p.x, p.y);
					if(sourceDistanceA[i]+arr[i][j]+minCDistanceB[j] < minDistance)
						minDistance = sourceDistanceA[i]+arr[i][j]+minCDistanceB[j];
					if(sourceDistanceB[j]+arr[i][j]+minCDistanceA[i] < minDistance)
						minDistance = sourceDistanceB[j]+arr[i][j]+minCDistanceA[i];
				}
			}
			System.out.println(minDistance);
		}
	}

	private static double getDistance(int x, int y, int a, int b) {
		return Math.sqrt(((double) (x - a) * (x - a))
				+ ((double) (y - b) * (y - b)));
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
