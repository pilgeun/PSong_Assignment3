/*
 * Class: CMSC203 CRN 46519
 * Instructor: Farnaz Eivazi
 * Description: Encrypts and Decrypts a phrase using Caesar Cipher and Bellaso Cipher
 * Due: 7/14/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   Print your Name here: Philip Song
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';	// ascii 32
	private static final char UPPER_BOUND = '_';	// ascii 95
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;	// 64

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		
		for (int c = 0; c < plainText.length(); c++) 
		{ 
			if ( plainText.charAt(c) < LOWER_BOUND || plainText.charAt(c) > UPPER_BOUND )
			{
				return false;
			} 
		}
		
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		
		String cipher = "";	// will store encrypted string
		int offset;			// stores value of individual encrypted character
		
		for (int c = 0; c < plainText.length(); c++) 
		{
			offset = plainText.charAt(c) + key;
			
			while (offset > UPPER_BOUND)
				offset -= RANGE;
			
			cipher += Character.toString(offset);
		}
		
		return cipher;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		String cipher = "", 
				keyWord = bellasoStr;	// will store extended keyword if needed
		int offset;
		
		// generates extended key word
		for (int i = 0; keyWord.length() < plainText.length(); i++)	
		{ 
			if (i >= bellasoStr.length())
				i = 0;
			
			keyWord += bellasoStr.charAt(i);
		}
		
		for (int c = 0; c < plainText.length(); c++) 
		{ 
			offset = plainText.charAt(c) + keyWord.charAt(c);
			
			while (offset > UPPER_BOUND)
				offset -= RANGE;
			
			cipher += Character.toString(offset);
		}
		
		return cipher;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		
		String message = "";
		int offset;
		
		for (int c = 0; c < encryptedText.length(); c++) 
		{
			offset = encryptedText.charAt(c) - key;
			
			while (offset < LOWER_BOUND)
				offset += RANGE;
			
			message += Character.toString(offset);
		}
		
		return message;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		String message = "", keyWord = bellasoStr;
		int offset;
		
		// generate extended keyword
		for (int i = 0; keyWord.length() < encryptedText.length(); i++)	
		{ 
			if (i >= bellasoStr.length())
				i = 0;
			
			keyWord += bellasoStr.charAt(i);
		}
		
		for (int c = 0; c < encryptedText.length(); c++) 
		{ 
			offset = encryptedText.charAt(c) - keyWord.charAt(c);
			
			while (offset < LOWER_BOUND)
				offset += RANGE;
			
			message += Character.toString(offset);
		}
		
		return message;
	}
}
