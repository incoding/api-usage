package com.javaapi.test.testUtil.math.arith.Chap03.SelectSort;
class ArraySels
{
public int bijiao_count=0;
public int jiaohuan_count=0;
private long[] a;                 // ref to array a
private int nElems;               // number of data items
//--------------------------------------------------------------
public ArraySels(int max)          // constructor
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
public void selectionSort()
   {
	int outer,in,flag;
	for(outer=0;outer<nElems-1;outer++){
		flag=outer;
		for(in=outer+1;in<nElems;in++){
			bijiao_count++;
			if(a[in] < a[flag]){
				flag=in;
			}
		}
		swap(outer, flag);
	}
   }  // end selectionSort()
//--------------------------------------------------------------
private void swap(int one, int two)
   {
	jiaohuan_count++;
   long temp = a[one];
   a[one] = a[two];
   a[two] = temp;
   }
//--------------------------------------------------------------
}
public class MySelectSortApp {

	   public static void main(String[] args)
	      {
	      int maxSize = 100;            // array size
	      ArraySels arr;                 // reference to array
	      arr = new ArraySels(maxSize);  // create the array

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

	      arr.selectionSort();          // selection-sort them

	      arr.display();                // display them again
	      System.out.println("比较次数"+arr.bijiao_count);
	      System.out.println("交换次数"+arr.jiaohuan_count);
	      }  // end main()
	   
}
