package com.hialan.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * User: Alan
 * Email:alan@hialan.com
 * Date: 12/10/14 10:47
 */
public class StreamStudy {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> stream = numbers.stream();
		stream.filter((x) -> {
			return x % 2 == 0;
		}).map((x) -> {
			return x * x;
		}).forEach(System.out::println);
	}
}
