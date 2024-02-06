package edu.kh.array.ex;

public class ArrayExample11 {
	
	public void ex11() {
		
		int[] arr = new int[4]; 
		arr[0] = 100; 
		arr[1] = 200; 
		arr[2] = 500; 
		arr[3] = 1000; 
		
		System.out.println(" 배열의 길이 : " + arr.length);
		
		for(int i=0; i < arr.length; i++) {
			System.out.printf("arr[%d]에 저장된 값 : %d\n", i, arr[i]);
		}
	}

}

 
