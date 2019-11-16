//Hacker Earth Problem

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestClass {

	static class Point
	{
		long x;
		long y;
		Point(long x,long y){
			this.x=x;
			this.y=y;
		}
	}
	
	static FastReader in = new FastReader();

	public static void main(String[] args) throws Exception {
		int n = in.nextInt();
		Point p[] = new Point[n];
		long[] x = new long[n];
		long[] y = new long[n];
		
		for(int i=0;i<n;i++){
			x[i]=in.nextInt();
			y[i]=in.nextInt();
			p[i]=new Point(x[i], y[i]);
		}
		
		long area = polygonArea(x, y, n); //2A
		long incount=0;
		for(int i=1;i<n;i++){
			incount+=(getPointsOnEdge(p[i],p[i-1]));
		}
		incount+=getPointsOnEdge(p[n-1], p[0])+n;
		System.out.println((area-incount+2)>>1);
	}

	public static long polygonArea(long X[], long Y[], int n) {
		long area = 0;
		int j = n - 1;
		for (int i = 0; i < n; i++) {
			area += (X[j] + X[i]) * (Y[j] - Y[i]);
			j = i;
		}
		return Math.abs(area);
	}

	static long gcd(long a, long b)
    {
        if (a==0 || b==0)
           return a+b;
        if(a >= b)
        	return gcd(a%b,b);
        return gcd(b, a%b);
    }
 
    static long getPointsOnEdge(Point p, Point q)
    {
        if (p.x==q.x)
            return Math.abs(p.y - q.y) - 1;
        if (p.y == q.y)
            return Math.abs(p.x-q.x) - 1;
        
        return gcd((long)Math.abs(p.x-q.x), (long)Math.abs(p.y-q.y))-1;
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
