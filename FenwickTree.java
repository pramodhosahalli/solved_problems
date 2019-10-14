import java.util.Arrays;

//Binary Indexed Tree which can be used to Store prefix sums and consumes less space than segment Tree
public class FenWickTree {

	//O(N log N)
	private static void constructFenwickTree(int[] arr, int[] prefixsum) {
		// Since 0th index is dummy node in fenwick Tree, index starts from 1
		for (int i = 0; i < arr.length; i++) {
			int num = i + 1;// currentNumber
			while (num < prefixsum.length) {
				prefixsum[num] += arr[i];
				// To get Next index follow the procedure..
				/*
				 * Get 2's Complete of Index 
				 * And with index 
				 * Add result to index
				 */
				num = num + (num & ((~num) + 1));
			}
		}
	}

	//O(log N)
	// l and h are indexes of array arr
	private static int getPrefixSum(int[] prefixsum, int l, int h) {
		int k = h + 1;
		int res1 = 0;
		while (k > 0) {
			res1 += prefixsum[k];
			// To get Parent follow the procedure..
			/*
			 * Get 2's Complete of Index 
			 * And with index 
			 * Subract result from index
			 */
			k = k - (k & ((~k) + 1));
		}
		if (l == 0)
			return res1;

		k = l;
		int res2 = 0;
		while (k > 0) {
			res2 += prefixsum[k];
			k = k - (k & ((~k) + 1));
		}
		return res1 - res2;
	}

	//O(log N)
	private static void updateArray(int index,int newValue,int[] arr,int[] prefixsum)
	{
		int currValue = arr[index];
		int diff = 0;
		if(currValue < newValue)
			diff = newValue-currValue;
		else
			diff = currValue-newValue;
		int num = index + 1;
		while (num < prefixsum.length) {
			prefixsum[num] += diff;
			// To get Next index follow the same procedure..
			/*
			 * Get 2's Complete of Index 
			 * And with index 
			 * Add result to index
			 */
			num = num + (num & ((~num) + 1));
		}
		arr[index]=newValue;
	}
	
	public static void main(String[] args) {
		int[] arr = { 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3 };
		int[] prefixsum = new int[arr.length + 1];
		constructFenwickTree(arr, prefixsum);
		System.out.println(getPrefixSum(prefixsum,3,8));
		updateArray(6,9,arr,prefixsum);
		System.out.println(Arrays.toString(arr));
		System.out.println(getPrefixSum(prefixsum,3,8));

	}
}
