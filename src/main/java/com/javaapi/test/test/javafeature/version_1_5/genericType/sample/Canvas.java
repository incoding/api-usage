package com.javaapi.test.test.javafeature.version_1_5.genericType.sample;

import java.util.List;

public class Canvas {

	public void draw(Shape s) {
		s.draw(this);
	}

	/**
	 * 确定上限,
	 */
	public void drawAllExtend(List<? extends Shape> shapes) {
		// 可以正确读取类型
		for (Shape shape : shapes) {
			
		}
		// 但是不可以写入
//		 shapes.add(0, new Rectangle()); // compile-time error!
	}
	
	/**
	 * 确定下限
	 */
	public void drawAllSuper(List<? super Circle> shapes) {
		shapes.add(new Circle());   // 可以插入
//		shapes.add(new Shape());   // 可能是其他的
//		Circle c=	shapes.get(0);  // 不能顺利取出
	}
}