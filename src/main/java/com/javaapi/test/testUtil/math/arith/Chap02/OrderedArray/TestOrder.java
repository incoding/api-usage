package com.javaapi.test.testUtil.math.arith.Chap02.OrderedArray;

public class TestOrder {
	Integer[] array = { 1, 3, 5, 6, 9, 2, 4, 5, 8, 7, 10 };

	public static void main(String[] args) {
		Integer a=12;
		new TestOrder().find(a);
	}

	private  void find(Integer a) {
		int low=0;
		int upper=array.length-1;
		while (true) {
			int media=(low+upper)/2;
			System.out.println(media+"=="+low+"=="+upper+"==");
			 if(low>upper){
				System.out.println("can not find");
				break;
			}
			if(array[media]<a){
				low=media+1;
			}else if(array[media]>a){
				upper=media-1;
			}else if(array[media]==a){
				System.out.println("find==>"+media);
				break;
			}
		}
	}
}
