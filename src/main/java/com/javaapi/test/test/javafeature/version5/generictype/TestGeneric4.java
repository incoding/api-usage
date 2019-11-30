package com.javaapi.test.test.javafeature.version5.generictype;

import java.util.ArrayList;
import java.util.Collection;

import com.javaapi.test.test.javafeature.version5.generictype.generic.GenericSuper;
import org.junit.Test;

import com.javaapi.test.buisness.dao.mybatis.User;
import com.javaapi.test.test.javafeature.version5.generictype.generic.GenericExtends;
import com.javaapi.test.businessdesign.skill.branch.eg.PeopleI;

public class TestGeneric4 {
	/**
	 * 1通配符接受到之后都是Object类型. 读取需要进行向下转型</br> 2只要有通配符的地方就不能写入.
	 */
	@Test
	public void test() {
		Collection<?> c = new ArrayList<String>();
		// c.add(new Object()); // 编译时错误
	}

	/**
	 * 泛型当中支持通配符,可以单独使用 '?' 来表示任意类型,也可以使用刚才上面例子中的extends关键字表示传入参数是某一个类或接口的子类,
	 * 也可以使用super关键字表示接受某一个类型的父类型,extends和super的写法一样,extends是限定上界,super为限定下界</br>
	 * {@link GenericExtends}</br>
	 * {@link GenericSuper}
	 */
	@Test
	public void test1() {

	}

	/**
	 * 以上三者都可以容纳所有的对象,但使用的顺序应该是首选List<T>,然后List<?>,最后才使用List<Object>,原因是List<T>
	 * 是确定为某一类型的
	 * ,安全的,也是Java所推荐的,而List<?>代表为任意类型,与List<T>类似,而List<Object>中全部为Object类型
	 * ,这与不使用泛型无异,而List<T>是可读可写的,因为已经明确了T类型,而其他两者在读取时需要进行向下转型,造成了不必要的转型
	 */
	@Test
	public void test2() {

	}

	/**
	 * .使用多重边界限定 现在有一个业务需求,收钱时需要是我们本公司的员工(继承User),同时亦需要具备收银员的功能(实现PeopleI),
	 * 此时我们当然可以想到接受1个User然后判断User是否实现了PeopleI接口,但在泛型的世界中,我们可以怎么做?请看以下例子
	 */
	public static <T extends User & PeopleI> void CollectMoney(T t) {

	}

}
