package com.javaapi.test.test.javafeature.version5.generictype.sample2;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Client {
	
	@Test
	public void testGeneric() {
		Map<String, ? extends Race> map;
		boolean b = true;
		// 可以直接赋值 将 Map<String, DcRace>直接赋值给map变量
		// 但是map不能加入DcRace
		if(b) {
			map = getDcRace();
		}else {
			map = getZcRace();
		}
		dealRace(map);
		dealMultiRace(map);
	}
	 /**
	 * 想要获取具体子类型还是必须得强制转换
	 */
	public <T extends Race> void dealMultiRace(Map<String,T> map) {
		 // 获得这个泛型T 能干嘛?  T能当做父类型Race来用
//		 Iterator<Entry<String, T>> iterator = map.entrySet().iterator();
		 // 可以直接当做 父类型使用. 
		 T t = map.get("1");
		 System.out.println("父类型"+t.getName());
		 // 怎么在需要用子类型得时候得时候转为字类型 ?
		 // 如下?
		 if(t instanceof ZcRace) {
			 ZcRace zc = (ZcRace)t;
		 }
		 if(t instanceof DcRace) {
			 DcRace zc = (DcRace)t;
			 System.out.println("强转为子类型使用"+zc.getBifen());
		 }
	 }
	
	private void dealRace(Map<String, ? extends Race> map) {
		// 取出可以直接按照父类型取出
		Race t = map.get("1");
		System.out.println(t.getName());
		 if(t instanceof ZcRace) {
			 ZcRace zc = (ZcRace)t;
		 }
		 if(t instanceof DcRace) {
			 DcRace dc = (DcRace)t;
			 System.out.println("强转为子类型使用"+dc.getBifen());
		 }
	}
	private void dealIteratorRace(Map<String, ? extends Race> map) {
		// 为什么迭代不可以 ??
		map.entrySet().iterator();
	}
	public Map<String,DcRace> getDcRace(){
		
		HashMap<String, DcRace> hashMap = new HashMap<>();
		DcRace value = new DcRace();
		value.setName("dc");
		value.setBifen("123");
		hashMap.put("1", value);
		return hashMap;
	}
	
	public Map<String,ZcRace> getZcRace(){
		
		return new HashMap<>();
	}

}
