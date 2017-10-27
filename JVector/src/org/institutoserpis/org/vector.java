package org.institutoserpis.org;

public class vector {

	public static void main(String[] args) {

		int[] v = new int[] {9, 15, 7, 12, 6};
		
		for (int index=0; index < 5; index++)
			System.out.printf("v[%s]=%s ", index, v[index]);
		System.out.println();
		
		int value = 33;
		
		int position = indexOf(v, value);
		System.out.println("position=" + position);
		
		//int
	}
	
	public static int indexOf(int[] v, int value) {
		int index = 0;
		while (index < v.length && v[index] != value) //OjO con el orden de la condición
			index++;
		if (index == v.length)
			return -1;
return index;
	}

}
