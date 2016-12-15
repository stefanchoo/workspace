package com.mj.io.hack;

import org.junit.Test;

/**
 * 操作单个字符的character类使用小结
 * 
 * @author stefan
 *
 */

public class CharacterTest {

	@Test
	public void testConstruction() {
		System.out.println("\n -- testConstrution() --");
		Character c = new Character('a');
		System.out.println("This is a char: " + c.toString()
				+ ", and it's class: " + c.getClass());

		String str = Character.toString('b');
		System.out.println(str);
	}

	@Test
	public void testCompareTo() {
		System.out.println("\n -- testCompareTo() --");
		Character ch1 = new Character('a');
		Character ch2 = new Character('A');
		int x = ch1;
		int y = ch2;
		System.out.println("x=" + x + " " + "y=" + y);
		// 比较是转化为ASII码进行的
		int t = ch1.compareTo(ch2);
		if (t == 0)
			System.out.println(ch1 + "等于" + ch2);
		else if (t < 0)
			System.out.println(ch1 + "小于" + ch2);
		else if (t > 0)
			System.out.println(ch1 + "大于" + ch2);
	}

	@Test
	public void testIsUpperCase() {
		System.out.println("\n -- testIsUpperCase() --");
		char ch1 = 'A';
		char ch2 = 'a';

		assert (Character.isUpperCase(ch1));
		System.out.println("ch1为大小字母");

		assert (Character.isLowerCase(ch2));
		System.out.println("ch2为小写字母");
	}

	@Test
	public void testIsLetter() {
		System.out.println("\n -- testIsLetter() -- ");
		char ch1 = 23;
		char ch2 = 'b';

		System.out.println(ch1 + " is a letter: " + Character.isLetter(ch1));
		System.out.println(ch2 + " is a letter: " + Character.isLetter(ch2));

	}
}