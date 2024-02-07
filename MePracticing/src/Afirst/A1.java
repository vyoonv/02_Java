package Afirst;



public class A1 {
 

	
	public static void practice1() {
		
		int[] num = new int[10];
		
		for(int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}

		System.out.println();
		for(int i = 0; i < num.length; i++) {
			if(num[i] % 2 == 0) {
		    	System.out.print(num[i] + " ");
		    }
		}

}
