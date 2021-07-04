package String.StringBasicQuestions;

import org.junit.Assert;
import org.junit.Test;

public class Question5 {

	public static String reverse(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		char[] characters = str.toCharArray();
		int i=0;
		int j = characters.length - 1;
		while(i < j) {
			swap(characters, i, j);
			i++;
			j--;
		}
		return new String(characters);
	}
	
	private static void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
	
	@Test
	public void reverseEmptyString() {
		Assert.assertEquals("", reverse(""));
	}
	
	public void reverseString() {
		Assert.assertEquals("cba", reverse("abc"));
	}
	
	public void reverseNullString() {
		Assert.assertEquals(null, reverse(null));
	}
	
	public void reversePalindromeString() {
		Assert.assertEquals("aba", reverse("aba"));
	}
	
	public void reverseSameCharacterString() { 
		Assert.assertEquals("aaa", reverse("aaa")); 
	} 
	
	@Test 
	public void reverseAnagramString() { 
		Assert.assertEquals("mary", reverse("yram")); 
	}

}
