using NUnit.Framework;
using System;

namespace CVector
{
	[TestFixture]
	public class VectorTest
	{
		[Test]
		public void Sort () {
			int[] v = {12, 9, 15, 7, 13};
			Vector.Sort(v);
			CollectionAssert.AreEqual (new int[]{ 7, 9, 12, 13, 15 }, v);
			v = new int[]{7, 9, 12, 13, 15};
			Vector.Sort(v);
			CollectionAssert.AreEqual (new int[]{ 7, 9, 12, 13, 15 }, v);

		}
		[Test]
		public void IndexMin(){
			int[] v = { 12, 9, 15, 7, 13 };
			Assert.AreEqual (4, Vector.IndexMin (v, 4));
			Assert.AreEqual (2, Vector.IndexMin (v, 2));
			Assert.AreEqual (1, Vector.IndexMin (v, 0));


		}
		[Test]
		[ExpectedException(typeof(System.IndexOutOfRangeException))]
		public void IndexMinBadInitialIndexLeft() {
			int[] v = { 12, 9, 15, 7, 13 };
			Assert.AreEqual (0, Vector.IndexMin (v, -1));

		}
		[Test]
		[ExpectedException(typeof(System.IndexOutOfRangeException))]
		public void IndexMinBadInitialIndexRight() {
			int[] v = { 12, 9, 15, 7, 13 };
			Assert.AreEqual (0, Vector.IndexMin (v, 5));
		}
	}
}

