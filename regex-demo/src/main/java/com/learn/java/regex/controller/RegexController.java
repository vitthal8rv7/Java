package com.learn.java.regex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.regex.service.RegexService;

@RestController
public class RegexController {

	@Autowired
	RegexService regexService;

	@GetMapping("/auto/test/regex")
	public String autoTestRegex() {
		Integer occurrences = 0;
		String pattern = "";
		String textData = "";
		
		// 1. Test String
		pattern = "foo"; textData = "foo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 2. Test String
		pattern = "foo"; textData = "foofoo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 3. Test String
		pattern = "foo"; textData = "foofoofo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 4. Test String
		pattern = "foo"; textData = "fofoofoofo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		//Till 4 tests, regex check pattern contain in textData or not?

		// 5. Test String
		pattern = "."; textData = "fofoofoofo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//here, . is META CHARACTER  . for any single character except a newline

		// 6. Test String
		pattern = "foo."; textData = "fofoofoofo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//here,   foo. for 'foo with any single character except a newline'
		// so, pattern matches only once because foo+f (f for any char for '.')
		//so, pending is 'oofo', which will not match with 'foo.'

		// 7. Test .
		pattern = "foo."; textData = "fofooffoofo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// pattern matches 2 times

		// 8. Test *
		pattern = "foo*"; textData = "fofooffoofo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// * => zero or more occurrences, 'fo' should match but 2nd 'o' is conditional
		//fofooffoofo => 'fo'=> 'fo' with zero 'o', 'foo'=> 'fo' with zero '1'
		//again 'foo'=> 'fo' with zero '1', again 'fo'=> 'fo' with zero 'o'=> 4

		// 9. OR Class
		pattern = "[for]"; textData = "fafsrffoofo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//true: if found any of the character from the pattern in textData.
		//here, 9 character found out of 11 in textData which are from pattern.

		// 10. OR Class
		pattern = "[for]at"; textData = "fafsrffoofo";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// here, 0 occurrences found because 
		//pattern is ANYTHING_FROM[for] but should concat with 'at'

		// 11. OR Class
		pattern = "[for]at"; textData = "fafrsatfatfoofoat";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// here, 2 occurrences found because 'rsat' will not match

		// 12. OR Range: check any character between A to Z in textData
		pattern = "[A-Z]"; textData = "Two Uppercase alphabets 30 overall";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 13. OR Range: check any character between a to z in textData
		pattern = "[a-z]"; textData = "Two Uppercase alphabets 30 overall";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 14. OR Range: check any upper case followed by any lower case character
		pattern = "[A-Z][a-z]"; textData = "Two Uppercase alphabets 30 overall";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		
		
		// 15. OR Range: check any character between A to Z a to z in textData
		pattern = "[A-Za-z]"; textData = "Two Uppercase alphabets 30 overall";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//any upper case or lower case characer
		
		// 16. OR Range: check any character between a to z A to Z in textData
		pattern = "[a-zA-Z]"; textData = "Two Uppercase alphabets 30 overall";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//any upper case or lower case characer
		
		// 17. OR Range: check any digit
		pattern = "[0-9]"; textData = "Two Uppercase alphabets 30 overall";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//any digits

		// 18. OR Range: check any [1,2,3] followed by any [6, 7, 8, 9]
		pattern = "[1-3][6-9]"; textData = "12362846151231236";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//1236, 28, 1231236

		// 19. UNION
		pattern = "[1-3[6-9]]"; textData = "12362846151231236";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//[1-3[6-9]] => [1236789] to confirm check below test case

		// 20. OR Class
		pattern = "[1236789]"; textData = "12362846151231236";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//[1-3[6-9]] => [1236789] to confirm check below test case
		
		// 21. INTERSECTION
		pattern = "[1-6&&[3-9]]"; textData = "123456789";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//[1-6&&[3-9]] => common in [123456] and [3456789] => [3456]
		//to confirm check below test case

		// 22. OR Class
		pattern = "[3456]"; textData = "123456789";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//[1-6&&[3-9]] => common in [123456] and [3456789] => [3456]


		// 23. OR Class
		pattern = "[0-9&&[^3-9]]"; textData = "0123456789";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//[0-9&&[^3-9]] => remove [3456789] from [0123456789] => [123]
		//for confirmation, check below example
		
		// 24. OR Class
		pattern = "[012]"; textData = "0123456789";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//[0-9&&[^3-9]] => remove [3456789] from [0123456789] => [012]

		// 25. Predefine Char Classes
		pattern = "\\d"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//Any Digit


		// 26. Predefine Char Classes
		pattern = "\\D"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//Except Digit

		
		// 27. Predefine Char Classes
		pattern = "\\s"; textData = "as0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//White spaces

		// 28. Predefine Char Classes
		pattern = "\\S"; textData = "as0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//Anything except White spaces

		// 29. Predefine Char Classes
		pattern = "\\w"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//[A-Za-z0-9] =>  Alphabet and digit

		// 30. Predefine Char Classes
		pattern = "\\W"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		//[^A-Za-z0-9] => Except alphabet and digit

		// 31. Predefine Char Classes
		pattern = "\\a"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// \a not found

		// 32. Predefine Char Classes
		pattern = "\\a?"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// \a found 19th times with 0 occurrences 

		// 33. Predefine Char Classes
		pattern = "\\a{0,1}"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// \a found 19th times with 0 occurrences

		// 34. Predefine Char Classes
		pattern = "z"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// z not found

		// 35. Predefine Char Classes
		pattern = "z?"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// z found 19 times with 0 occurrences

		// 36. Predefine Char Classes
		pattern = "z{0,1}"; textData = "0123456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// z found 19 times with 0 occurrences

		//matching from the higher end of the range
		
		// 37. Predefine Char Classes
		pattern = "a{0,1}"; textData = "aaa3456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// a found 15 times with 0 occurrences and 4 times 1 occurrences

		// 38. Predefine Char Classes
		pattern = "ab{0,1}"; textData = "aaa3456789ab c@# *";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// a,b found 19 times with 0 occurrences

		//matching from the higher end of the range
		// 39. Predefine Char Classes
		pattern = "a{0,3}"; textData = "aaa";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// ?? 

		//matching from the higher end of the range
		// 40. Predefine Char Classes
		pattern = "a{0,3}"; textData = "abaab";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// ??

		//matching from the higher end of the range
		// 41. Predefine Char Classes
		pattern = "a{1,3}"; textData = "abaab";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// ???

		// 42. Predefine Char Classes
		pattern = "a*{1,3}"; textData = "abaab";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// ???

		// 43. Predefine Char Classes
		pattern = "a*{1,}"; textData = "abaab";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// ???

		// 44. Predefine Char Classes
		pattern = "a+{2,}"; textData = "abaab";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// ???

		//matching from the higher end of the range
		// 45. Predefine Char Classes
		pattern = "a{3}"; textData = "aa";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// ???

		//matching from the higher end of the range
		// 46. Predefine Char Classes
		pattern = "a{2,3}"; textData = "aaaa";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// ???

		// 47. Predefine Char Classes
		pattern = "(\\d\\d)"; textData = "12";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// two digits next to each other

		// 48. Predefine Char Classes
		pattern = "(\\d\\d)"; textData = "1234";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// two digits next to each other

		//Backreference: You can reference a capturing group using a backreference. 
		//The backreference is usually expressed as \n, 
		//where n is the number of the capturing group you want to reference. 
		//\1 references the first capturing group, \2 references the second, and so on.
		// 49. Predefine Char Classes
		pattern = "(\\d\\d)\\1"; textData = "1212";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// two digits next to each other

		// 50. Predefine Char Classes
		pattern = "(\\d\\d)(\\d\\d)"; textData = "12121212";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// two digits next to each other

		// 51. Predefine Char Classes
		pattern = "(\\d\\d)\\1"; textData = "12121212";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// two digits next to each other

		// 52. Predefine Char Classes
		pattern = "(\\d\\d)\\2"; textData = "12121212";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// two digits next to each other

		// 53.  Boundary Matchers
		pattern = "^dogs"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 54.  Boundary Matchers
		pattern = "^dog"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text
		
		// 55.  Boundary Matchers
		pattern = "friendly$"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 56.  Boundary Matchers
		pattern = " friendly$"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 57.  Boundary Matchers
		pattern = "friendly $"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 58.  Boundary Matchers
		pattern = "ndly$"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 59.  Boundary Matchers
		pattern = "ndly\\b"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 60.  Boundary Matchers
		pattern = "friendly\\b"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 61.  Boundary Matchers
		pattern = "dogs\\b"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 62.  Boundary Matchers
		pattern = "\\bndly\\b"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 63.  Boundary Matchers
		pattern = "\\bfriendly\\b"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 64.  Boundary Matchers
		pattern = "\\bdogs\\b"; textData = "dogs are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
		// beginning of the text

		// 65. Case Sensitive 
		pattern = "dog"; textData = "DOG are friendly";
		occurrences = regexService.testRegex(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 65. Case InSensitive 
		pattern = "dog"; textData = "DOG are friendly";
		occurrences = regexService.testRegex2(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 66. Comment
		pattern = "dog$ #check for word dog at end of text"; textData = "This is a DOG";
		occurrences = regexService.testRegex3(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 67. Comment
		pattern = "dog$ #check for word dog at end of text"; textData = "This is a dog";
		occurrences = regexService.testRegex3(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));
	
		// 68.
		pattern = "dog$"; textData = "This is a dog";
		occurrences = regexService.testRegex4(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 69.
		pattern = "dog$"; textData = "This is a dog";
		occurrences = regexService.testRegex5(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		
		// 70.
		pattern = "dog$"; textData = "This is a dog";
		occurrences = regexService.testRegex6(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 71.
		pattern = "This is a dog"; textData = "This is a dog";
		occurrences = regexService.testRegex5(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		
		// 72.
		pattern = "This is a "; textData = "This is a dog";
		occurrences = regexService.testRegex6(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 73.
		pattern = "dog"; textData = "This is a dog. dog are friendly!";
		occurrences = regexService.testRegex7(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		// 74.
		pattern = "dog"; textData = "This is a dog. dog are friendly!";
		occurrences = regexService.testRegex8(pattern, textData);
		System.out.println(String.format("Pattern: %s, TextData: %s, Result Found %d occurrences.", pattern, textData, occurrences));

		
		return "AutoTestingCompleted.";
	}
}
