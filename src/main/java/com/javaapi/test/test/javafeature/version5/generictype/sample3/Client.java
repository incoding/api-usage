package com.javaapi.test.test.javafeature.version5.generictype.sample3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**T 是在同一个类中将类型固定为同一个,?则是可以为任意,具体看test2
 * 通配符与没有通配符得区别
 * http://www.linuxidc.com/Linux/2013-10/90928.htm
 * http://www.linuxidc.com/Linux/2013-10/90928p2.htm
 *
 */
public class Client {

	@Test
	public void test() {
		AnimalTrainer animalTrainer = new AnimalTrainer();
		//Test 1
		List<Animal> animalList = new ArrayList<>();
		animalList.add(new Cat("cat1"));
		animalList.add(new Bird("bird1"));
		
		
		animalTrainer.act(animalList);	//可以通过编译
		
		//Test 2
		List<Cat> catList = new ArrayList<>();
		catList.add(new Cat("cat2"));
		catList.add(new Cat("cat3"));
		
//		animalTrainer.act(catList);		//无法通过编译
	}
	/**
	 * 
	 */
	@Test
	public void test2() {
		AnimalTrainer animalTrainer = new AnimalTrainer();
		//Test 1
		List<Animal> animalList = new ArrayList<>();
		animalList.add(new Cat("cat1"));
		animalList.add(new Bird("bird1"));
		Map<String,Cat> map = new HashMap<>();
		
		animalTrainer.actGerenic(animalList,map);	//可以通过编译
		
		//Test 2
		List<Cat> catList = new ArrayList<>();
		catList.add(new Cat("cat2"));
		catList.add(new Cat("cat3"));
		
//		animalTrainer.actT(animalList,map);	//无法通过编译
	}
}
