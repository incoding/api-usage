package com.javaapi.test.test.genericType.sample3;

import java.util.List;
import java.util.Map;

public class AnimalTrainer {
	public void act(List<Animal> list) {
		for (Animal animal : list) {
			animal.eat();
		}
	}
	public <T extends Animal> void actT(List<T> list,Map<String,T> map) {
		for (Animal animal : list) {
			animal.eat();
		}
		T t = map.get("");
	}
	public void actGerenic(List<? extends Animal> list,Map<String,?> map) {
		for (Animal animal : list) {
			animal.eat();
		}
	}
}