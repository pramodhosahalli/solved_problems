# Problem Description can be found at https://www.codechef.com/NOV19B/problems/WEIRDO

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ZeroToINF{

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int ag[] = new int[26];
			int ac[] = new int[26];
			int bg[] = new int[26]; // used to count groups
			int bc[] = new int[26]; // used to store counts
			int agc = 0;
			int bgc = 0;

			for (int i = 0; i < n; i++) {
				char[] ch = in.readLine().toCharArray();
				boolean found = false;
				for (int j = 1; j < ch.length; j++) {
					int cons_count = 0;
					if (!isVowel(ch[j]))
						cons_count++;
					if (!isVowel(ch[j - 1]))
						cons_count++;
					if (j + 1 < ch.length && !isVowel(ch[j + 1]))
						cons_count++;
					if (cons_count >= 2) {
						found = true;
						break;
					}
				}

				if (found) {
					bgc++;
					int[] data = new int[26];
					for (char c : ch) {
						bc[c - 'a']++;
						if (data[c - 'a'] == 0) {
							bg[c - 'a']++;
							data[c - 'a']++;
						}
					}
				} else {
					agc++;
					int[] data = new int[26];
					for (char c : ch) {
						ac[c - 'a']++;
						if (data[c - 'a'] == 0) {
							ag[c - 'a']++;
							data[c - 'a']++;
						}
					}
				}
			}
			double as = 0;
			double bs = 0;
			for (int i = 0; i < 26; i++) {
				if (ag[i] != 0 && ac[i] != 0 && agc > 0) {
					as += getLog(ag[i]);
					as = as - (agc * getLog(ac[i]));
				}
				if (bg[i] != 0 && bc[i] != 0 && bgc > 0) {
					bs += getLog(bg[i]);
					bs = bs - (bgc * getLog(bc[i]));
				}
			}
			double value = as - bs;
			value = Math.pow(Math.E, value);
			if (value > 10000000d)
				System.out.println("Infinity");
			else
				System.out.println(value);
		}
		in.close();
	}

	private static double getLog(double x) {
		return Math.log(x);
	}

	private static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}
}
