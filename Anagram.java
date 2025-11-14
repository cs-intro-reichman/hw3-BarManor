/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

	char[] arr1 = preProcess(str1).toCharArray();
	char[] arr2 = preProcess(str2).toCharArray();

	if (arr1.length != arr2.length)
	{
	 return false;
	}

	for(int i = 0; i < arr1.length; i++)
	{

	 boolean found = false; // mark as not found, is an anagram until proven otherwise

	 for (int j = 0; j < arr2.length; j++)
	 {

	  if (arr1[i] == arr2[j])
	  {
	   arr1[i] = '.'; // mark as used
	   arr2[j] = ','; // mark as used
	   found = true; // mark as found
	   break;
	  }

	 }

	 if (!found)
	 {
	  return false;
	 }

	}

	return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {

    return str.replaceAll("[^a-zA-Z]", "").toLowerCase();	// deletes non-letter characters and converts to lower-case

	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
	char[] arr = str.toCharArray();
	char[] anagramArr = new char[arr.length]; // a new array to hold the anagram

	for (int i = 0; i < arr.length; i++)
	{
		int randIndex = (int)(Math.random() * arr.length);
		while (arr[randIndex] == '.') // find an unused character
		{
		randIndex = (int)(Math.random() * arr.length);
		}
		anagramArr[i] = arr[randIndex];// assign to anagram
		arr[randIndex] = '.'; // mark as used

    }

	return new String(anagramArr);

	}
}
