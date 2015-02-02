package com.hialan.stream;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toMap;

/**
 * User: Alan
 * Email:alan@hialan.com
 * Date: 12/10/14 11:39
 */
public class ForEachElement {
	Set<Person> persons = new HashSet<Person>();

	/**
	 * 传统的遍历集合方式
	 */
	public void forEachBeforJava8() {
		//传统遍历方式
		for (Person person : persons) {
			if (person.getAge() > 18) {
				System.out.println(person.name + " is elder than 18.");
			}
		}
	}

	/**
	 * Java8 stream api 遍历方式
	 */
	public void forEachAfterJava8() {
		persons.stream().filter(new Predicate<Person>() {

			@Override
			public boolean test(Person person) {
				if (person.getAge() > 18) {
					return true;
				} else {
					return false;
				}
			}
		}).forEach(new Consumer<Person>() {
			@Override
			public void accept(Person person) {
				System.out.println(person.name + " is elder than 18.");
			}
		});
	}

	/**
	 * Java8 stream api and lambda 遍历方式
	 */
	public void forEachJava8AndLambda() {
		persons.stream().filter(p -> p.getAge() >= 18)
				.forEach(p -> System.out.println(p.name + " is elder than 18."));
	}

	void addOne(Map<String, Integer> map,
				String key,
				int increment,
				int defVal){
		if(map.containsKey(key))
			map.put(key, map.get(key) + increment);
		else
			map.put(key, defVal);
		System.out.println(map);
	}

	void addString(Map<String, Set<String>> map,
				   String key,
				   String val){
		if(!map.containsKey(key))
			map.put(key, new HashSet<>());
		map.get(key).add(val);
	}

	void addOneWithJava8(Map<String, Integer> map, String key, int increment, int defVal) {
		map.compute(key, (k, v) -> key.equals(k) ? v + increment : defVal);
		System.out.println(map);
	}

	void addStringWithJava8(Map<String, Set<String>> map,
				   String key,
				   String val){
		map.computeIfAbsent(key, k -> new HashSet<>()).add(val);
		System.out.println(map);
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);

		ForEachElement forEachElement = new ForEachElement();
		//forEachElement.addOne(map, "a", 1, 3);
		forEachElement.addOneWithJava8(map, "a", 1, 3);

		Map<String, Set<String>> set = new HashMap<>();
		set.put("a", new HashSet<>());
		forEachElement.addStringWithJava8(set, "a", "b");
	}
}
