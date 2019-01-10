package com.javaapi.test.test.javafeature.version_1_5.genericType.Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.javaapi.test.test.javafeature.version_1_5.genericType.sample.Shape;

/**
 * 这告诉我们类型参数(type argument)被用作多态（polymorphism），它唯一的效果是允许在不同的调用点，可以使用多种实参类型(actual argument)。如果是这种情况，应该使用通配符。通配符就是被设计用来支持灵活的子类化的
 *
 */
public class GenericMethod {
	// 通配符的好处是,在不是泛型类的情况下,可以在方法签名之外被使用，比如field的类型，局部变量和数组
	static List<List<? extends Shape>> history = new ArrayList<List<? extends Shape>>();
    /**
     * 1 我们可以使用任意集合来调用这个方法，只要其元素的类型是数组的元素类型的父类。</br>
     * 2 泛型函数允许类型参数被用来表示方法的一个或多个参数之间的依赖关系，或者参数与其返回值的依赖关系。如果没有这样的依赖关系，不应该使用泛型方法。</br>
     */
    @Test
    public  void test1() {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<Object>();
        fromArrayToCollection(oa, co);// T 指Object
        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<String>();
        fromArrayToCollection(sa, cs);// T inferred to be String
        fromArrayToCollection(sa, co);// T inferred to be Object
        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];
        Collection<Number> cn = new ArrayList<Number>();
        fromArrayToCollection(ia, cn);// T inferred to be Number
        fromArrayToCollection(fa, cn);// T inferred to be Number
        fromArrayToCollection(na, cn);// T inferred to be Number
        fromArrayToCollection(na, co);// T inferred to be Object
//         fromArrayToCollection(na, cs);// compile-time error
    }
    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
        	//虽然没生命T的继承关系,但 因为子类型才能传进父类型
            c.add(o); // correct
        }
    }
    /**
     * 一前一后的同时使用泛型方法和通配符也是可能的
     * 注意两个参数的类型的依赖关系。任何被从源list从拷贝出来的对象必须能够将其指定为目标list(dest) 的元素的类型——T类型。因此源类型的元素类型可以是T的任意子类型
     */
    @Test
    public void test2(){
    	List<Number> listNumber=new  ArrayList<Number>();
    	List<Integer> listInteger=new ArrayList<Integer>();
    	listInteger.add(1);
    	listInteger.add(2);
    	listInteger.add(3);
    	copy(listNumber,listInteger);
    	copy2(listNumber,listInteger);
    	copy3(listNumber,listInteger);
    }

	public static <T> void copy(List<T> dest, List<? extends T> src) {
		for(T integer:src){
			dest.add(integer);
		}
		for(T t:dest){
			System.out.println(t);
		}
	}
	
	/**
	 * 在泛型方法中,如果有泛型声明,声明要放在前面(而不是放在方法参数中) (相比泛型类中,泛型声明是放在类旁边)
	 */
	public static <T, S extends T>  void copy2(List<T> dest, List<S> src){
		
	}
	/**
	 *  这也可以，但是第一个类型参数在dest的类型和第二个参数的类型参数S的上限这两个地方都有使用，而S本身只使用一次，在src的类型中——没有其他的依赖于它。
	 * 这意味着我们可以用通配符来代替S。
	* 使用通配符比声明显式的类型参数更加清晰和准确，所以在可能的情况下使用通配符更好。
	*/
	public static <T,S extends T>  void copy3(List<T> dest, List<?> src){
		
	}
}
