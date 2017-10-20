package string;

public class AllInterleaving {

	static String str1 = "ab";
	static String str2 = "cd";
	static char[] op = new char[4];

	public static void main(String[] args) {
		printInterleavings(str1, str2, str1.length(), str2.length(), 0);
	}

	private static void printInterleavings(String str1, String str2, int m,
			int n, int i) {

		if (m == 0 && n == 0) {
			print();
			return;
		}

		if (m != 0) {
			op[i] = str1.charAt(0);
			printInterleavings(str1.substring(1), str2, m - 1, n, i + 1);

		}

		if (n != 0) {
			op[i] = str2.charAt(0);
			printInterleavings(str1, str2.substring(1), m, n - 1, i + 1);

		}

	}

	private static void print() {
		for (char c : op) {
			System.out.print(c);
		}
		System.out.println();

	}
}
