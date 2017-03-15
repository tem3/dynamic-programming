package cracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Powerset {
	public class PowersetComparator implements Comparator<ArrayList<Integer>> {
		@Override
		public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
			
			int size1 = list1.size();
			int size2 = list2.size();
			if(size1 == size2) {
				for(int index = 0; index < size1; index++) {
					if(list1.get(index) < list2.get(index)) {
						return -1;
					} else if( list1.get(index) > list2.get(index)) {
						return 1;
					}
				}
				return 0;
			} else if(size1 < size2) {
				return -1;
			} else {
				return 1;
			}
			
		}

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,5,20,3,634,3,7,31};
		ArrayList<ArrayList<Integer>> powerset = new ArrayList<ArrayList<Integer>>();
		powerset.add(new ArrayList<Integer>());
		
		for(int num : arr) {
			ArrayList<ArrayList<Integer>> newSet = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> set : powerset) {
				ArrayList<Integer> tempSet = new ArrayList<Integer>(set);
				tempSet.add(num);
				Collections.sort(tempSet);
				newSet.add( tempSet);
			}
			powerset.addAll(newSet);
		}
		
		Powerset p = new Powerset();
		Collections.sort(powerset, p.new PowersetComparator());
		for(ArrayList<Integer> set : powerset) {
			System.out.println(set);
		}
		
	}

}
