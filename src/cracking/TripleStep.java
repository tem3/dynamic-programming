package cracking;

public class TripleStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] ways = new int[n];
		ways[0] = 1;
		ways[1] = 2;
		ways[2] = 4;
		for(int i = 3; i < n; i++) {
			ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
		}
		System.out.println(ways[n-1]);
	}

}
