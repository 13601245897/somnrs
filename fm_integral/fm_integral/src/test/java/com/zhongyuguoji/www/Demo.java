package com.zhongyuguoji.www;

import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;

public class Demo {

	@Test
	public void selectHashMap() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String demo = "原谅我这一生放纵不羁爱自由";
		hashMap.put("demo", demo);
		Collection<Object> values = hashMap.values();
		System.out.println(values);
		int size = hashMap.size();
		System.out.println(size);
		Object clone = hashMap.clone();
		System.out.println(clone);
		boolean empty = hashMap.isEmpty();
		System.out.println(empty);
		Object replace = hashMap.replace("demo", "ceshi");
		System.out.println(replace + "_______");
		boolean containsKey = hashMap.containsKey("demo");
		System.out.println(containsKey);
		int hashCode = hashMap.hashCode();
		System.out.println(hashCode);
		hashMap.clear();
		boolean empty2 = hashMap.isEmpty();
		System.out.println(empty2);
	}
}
