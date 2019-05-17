package com.starlc.basicJava.string;

import java.util.Arrays;

public class Export {
	String name = "hello";
	char[] ch = { 'a', 'b' };

	public static void main(String[] args) {
		Export export = new Export();
		export.exchange(export.name, export.ch);
		System.out.println(export.name + "and" + export.ch.toString());

		System.out.println(export.name + " and " + Arrays.toString(export.ch));
		export.exChange(export);
		System.out.println(export);

	}

	void exchange(String str, char[] ch) {
		str = "test ok";
		ch[0] = 'c';
	}

	void exChange(Export export) {
		export.name = "jack";
	}

	@Override
	public String toString() {
		return "Export [name=" + name + ", ch=" + Arrays.toString(ch) + "]";
	};

}
