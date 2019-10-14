import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			String str = sc.nextLine();
			int period = N/4;
			str = str + str.substring(0, period);

			Set<Integer> candidates = new HashSet<>();
			for (int i = 0; i < str.length() - period; i++) {
				candidates.add(Integer.parseInt(str.substring(i, i + period), 16));
			}
			int[] passwords = new int[candidates.size()];
			int idx = 0;
			for (int i : candidates) {
				passwords[idx++] = i;
			}
			Arrays.sort(passwords);
			System.out.println("#"+test_case+" "+passwords[passwords.length - K]);
		}
	}
}