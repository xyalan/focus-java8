package com.hialan.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * User: Alan
 * Email:alan@hialan.com
 * Date: 12/10/14 11:24
 *
 * 利用Stream API 生成自然熟(无穷大)
 * 对于无穷大的数据当然会无穷遍历先去，
 * 因此可使用limit函数遍历限定的数
 * see@{url:http://www.infoq.com/cn/articles/java8-new-features-new-stream-api}
 */
public class NaturalSupplier implements Supplier<Long> {
	long value = 0;

	@Override
	public Long get() {
		this.value = this.value + 1;
		return this.value;
	}

	public static void main(String[] args) {
		Stream<Long> natural = Stream.generate(new NaturalSupplier());
		natural.map((x) -> {
			return x * x;
		}).limit(10).forEach(System.out::println);
	}
}
