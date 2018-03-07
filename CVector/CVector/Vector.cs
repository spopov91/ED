using System;

namespace CVector
{
	public class Vector
	{
		public static void Sort(int[] v) {
			
		}

		public static int IndexMin(int[] v, int initialIndex) {
			if (initialIndex >= v.Length)
				throw new IndexOutOfRangeException ();
			int indexMin=initialIndex;
			for(int index= initialIndex+1; index <v.Length;index++)
				if(v[index]< v[indexMin])
					indexMin=index;
			return indexMin;
		}


		public static void Swap(int[] v, int index, int otherIndex){
	}}
}

