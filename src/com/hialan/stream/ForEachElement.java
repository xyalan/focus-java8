package com.hialan.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
}
