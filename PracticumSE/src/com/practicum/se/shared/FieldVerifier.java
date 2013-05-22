package com.practicum.se.shared;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is not translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid for our service.
	 * 
	 * In this example, we only require that the name is at least four
	 * characters. In your application, you can use more complex checks to ensure
	 * that usernames, passwords, email addresses, URLs, and other fields have the
	 * proper syntax.
	 * 
	 * @param name the name to validate
	 * @return true if valid, false if invalid
	 */
	public static boolean isValidName(String name,String pswd) {
		//System.out.println("verify");
		if (name == null||pswd == null) {
			return false;
		}
		return name.length() > 3;
	}
	
	
	
	
	public static boolean isValidFirst(String fname,String lname) {
		//System.out.println("verify");
		if (fname.length()<3 && lname.length()<3) {
			return false;
		}
		return fname.length() > 3;
	}
	
	
	 
	 public static boolean isEmail(String id) {
			//System.out.println("verify");
		 final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		 
			Boolean b = id.matches(EMAIL_REGEX);
			
			if (!b) {
				return false;
			}
			
				
			return id.length() > 3;
		}
	 
	 public static boolean isreEmail(String id,String reid) {
			//System.out.println("verify");
		 
		 int comparision=reid.compareTo(id);
			
			if(comparision!=0)
			{
				return false;
			}
			return id.length() > 3;
		}
	 
	 
	 
	 
	}
