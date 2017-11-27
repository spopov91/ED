package org.institutoserpis.org;

public class vector {

	public static void main(String[] args) {
		int[] v = new int[] {9, 15, 7, 12, 6};
		
		for (int index=0; index < 5; index++)
			System.out.printf("v[%s]=%s ", index, v[index]);
		System.out.println();
		
		int value = 6;
		
		int position = indexOf(v, value);
		System.out.println("position=" + position);
		int min = min(v);
		System.out.println("min=" + min);
	}
	
	public static int indexOf(int[] v, int value) {
		int index = 0;
		while (index < v.length && v[index] != value)
			index++;
		return index < v.length ? index : -1;
	}
	
	public static int min(int[] v) {
//		int min = v[0];
//		for (int index = 1; index < v.length; index++)
//			if (v[index] < min)
//				min = v[index];
//		return min;
		int min = v[0];
		for (int item : v)
			if (item < min)
				min = item;
		return min;
	}
	
	public static int indexOfMin(int[] v) {
		int indexOfMin = 0;
		for (int index = 1; index < v.length; index++)
			if (v[index] < v[indexOfMin] )
				indexOfMin = index;	
		return indexOfMin;
	}
	
	public static int sum(int[] v) {
		int sum = 0;
//		for (int index = 0; index < v.length; index++)
//			sum = sum + v[index];
		for (int item : v)
			sum = sum + item;
		return sum;
	}
}
