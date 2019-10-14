//Segment Tree Implementation which performs Range Query Faster

import java.util.Arrays;

public class SegmentTree {

	private static void constructSegmentTree(int[] arr, int seg[], int low,
			int high, int pos) {
		if (low == high) {
			seg[pos] = arr[low];
			return;
		}
		int mid = (low + high) >> 1;
		constructSegmentTree(arr, seg, low, mid, 2 * pos + 1);
		constructSegmentTree(arr, seg, mid + 1, high, 2 * pos + 2);
		seg[pos] = Math.min(seg[2 * pos + 1], seg[2 * pos + 2]);
	}

	private static int rangeQueryForMin(int[] segTree, int qlow, int qhigh,
			int low, int high, int pos) {
		// complete overlap
		if (qlow <= low && qhigh >= high)
			return segTree[pos];
		// No overlap
		if (qhigh < low || qlow > high)
			return Integer.MAX_VALUE;

		int mid = (low + high) >> 1;
		return Math.min(
				rangeQueryForMin(segTree, qlow, qhigh, low, mid, 2 * pos + 1),
				rangeQueryForMin(segTree, qlow, qhigh, mid + 1, high,
						2 * pos + 2));
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 4, 2, 7, 6, 1, 9 };
		// to construct SegTree array choose next 2's power of n and subtract 1
		// from it...
		int n = arr.length;
		int k = 0;
		if ((n & (n - 1)) == 0)
			k = n << 1;
		else {
			k = (int) Math.ceil(Math.log(k));
			k = k << 1;
		}
		k-=1;
		int[] segTree = new int[k];
		Arrays.fill(segTree,Integer.MAX_VALUE);
		constructSegmentTree(arr, segTree, 0, n-1, 0);
		
		System.out.println(rangeQueryForMin(segTree, 5, 9, 0, n-1, 0));
	}
}
