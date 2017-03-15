package cracking;

public class MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-3, 0, 1, 4, 7, };
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i);
			if(arr[i]==i) {
				System.out.println("true");
			} 
			if(arr[i]>i) {
				System.out.println("false");
				break;
			}
		}
	}

}
