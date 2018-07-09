package com.javaapi.test.testUtil.math.arith.Chap03.InsertSort;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayInsert
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayInsert(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void insertionSort()
      {
	   int out;//外层位置
	   int in ;// 内层位置
	   for(out=1;out<nElems;out++){
		   long temp=a[out];
//		   in=out;
		   for(in=out;in>0; in--){
			   if(a[in-1]<temp ){
				   System.out.println("==");
//				   a[in]= temp;// 如果这么写则没有考虑到 in为0的情况,也就是需要插入的数据比有顺序的数据种任意一个都小的情况
				  break;
			   }else{
				   a[in]=a[in-1];
			   }
		   }
		   System.out.println("++");
		   a[in]= temp;
		  this.display();
	   }
	   
      }  // end insertionSort()
//--------------------------------------------------------------
   }  // end class ArrayIns
////////////////////////////////////////////////////////////////
public class MyInsertSort
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayInsert arr;                 // reference to array
      arr = new ArrayInsert(maxSize);  // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items

      arr.insertionSort();          // insertion-sort them

      arr.display();                // display them again
      }  // end main()
   }  // end class InsertSortApp
