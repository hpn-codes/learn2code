package ibit;

import java.util.ArrayList;

public class TestPgm {
	
	public static void main(String args[]) {
		
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(5);
		al.add(10);
		al.add(2);
		al.add(1);
		al.add(6);
		al.add(8);
		al.add(9);
		ArrayList<Integer> B = performOps(al);
		for (int i = 0; i < B.size(); i++) {
		        System.out.print(B.get(i) + " ");
		}
	}

	static ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
                B.set(i, A.get(i));
                B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
	}

	
	
}
