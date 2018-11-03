package com.javaapi.test.util.math.arith.Chap03.BubbleSort;

/**
 * 正宗的冒泡排序
 *
 */
public class BubbleSort {
public	void bubbleSort(){
	 int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
	int temp=0;
	// i代表比较次数
	for(int i=0;i<a.length-1;i++){
		// 为什么-i? i是已经排序了的,所以不需要排序了.参见java数据结构和算法
		//j代表位置
		for(int j=0;j<a.length-1-i;j++){
		if(a[j]>a[j+1]){
			temp=a[j];
			a[j]=a[j+1];
			a[j+1]=temp;
		}
		}
	}
	for(int i=0;i<a.length;i++)
		System.out.println(a[i]);	
}
public static void main(String[] args) {
	new BubbleSort().bubbleSort();
}
}