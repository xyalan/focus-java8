package com.hialan.lambda;

/**
 * User: Alan
 * Email:alan@hialan.com
 * Date: 1/25/15 23:13
 */
public class Client {
	public void runComputer() {
		Computer<Integer> computer = (addend, augend) -> addend + augend;

		System.out.println(computer.addition(4, 5));
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.runComputer();
	}
}
