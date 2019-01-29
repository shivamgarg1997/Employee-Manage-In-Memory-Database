package Basic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

public class Utility {
	
	public static String getMD5(String ph,String email) throws NoSuchAlgorithmException {
		String input = ph + email;
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] messageDigest = md.digest(input.getBytes());
		 BigInteger no = new BigInteger(1, messageDigest);
		 String hashtext = no.toString(16); 
         while (hashtext.length() < 32) { 
             hashtext = "0" + hashtext; 
         } 
         return hashtext; 
	}
	public static boolean isValidDate(String tDate, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
		    sdf.setLenient(false);
		    Calendar dob = Calendar.getInstance();
		    dob.setTime(sdf.parse(tDate));
		    int year = dob.get(Calendar.YEAR);
		    if(year >= 2001 || year <= 1949)
		    	 return false;
		     return true;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}
	public static boolean isValidEmail(String mail) {
		if(Pattern.matches("[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(infoobjects.com)", mail)) {
			return true;
		}
		else return false;
	}
	public static boolean isValidAddress(String add) {
		if(add.equals("")) {
			return false;
		}
		return true;
	}
	public static boolean isValidPhnoNumber(String phno) {
		if(!Pattern.matches("(0/91)?[7-9][0-9]{9}", phno)) {
			return false;
		}
		return true;
	}
	public static boolean isValidName(String name) {
		if(!Pattern.matches("[a-zA-Z ]+", name)) {
			return false;
		}
		return true;
	}
	public static boolean isValidAge(String tAge) {
		if(!Pattern.matches("[0-9]+", tAge)){
			return false;
		} else if(Integer.parseInt(tAge) <= 18 && Integer.parseInt(tAge) >=70) {
			return false;
		}
		
		return true;
	}
	public static boolean isValidGender(int tGen) {
		if(Employee.mapToGender(tGen)!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidDept(int tdept) {
		if(Employee.mapToDept(tdept)!=null) {
			return true;
		} else {
			return false;
		}
	}
	public static String[] parseName(String name) {
		String[] names = name.split(" ");
		if(names.length == 1) {
			return new String[] {names[0],"",""};
		} else if(names.length == 2) {
			return new String[] {names[0],"",names[1]};
		} else if(names.length >= 3) {
			StringBuffer sb = new StringBuffer("");
			for(int i=2; i<names.length; i++) {
				sb = sb.append(names[i]).append(" ");
			}
			return new String[] {names[0],names[1],sb.toString()};
		}
		return null;
	}
		
	public static int getRealTimeAge(String input) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			 Calendar dob = Calendar.getInstance(); 
			 dob.setTime(sdf.parse(input));
			 int dobYear = dob.get(Calendar.YEAR);
	
			Calendar today = Calendar.getInstance();
			int curYear = today.get(Calendar.YEAR);
			 int age = curYear - dobYear;
			 int curMonth = today.get(Calendar.MONTH);
			 
	         int dobMonth = dob.get(Calendar.MONTH);
	 
	         if (dobMonth > curMonth) { 
	        	 age--;
	         } else if (dobMonth == curMonth) { 
	             int curDay = today.get(Calendar.DAY_OF_MONTH);
	             int dobDay = dob.get(Calendar.DAY_OF_MONTH);
	             if (dobDay > curDay) { 
	                age--;
	             }
	          }
	         return age;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static String camelCase(String str) {
		StringBuilder builder = new StringBuilder(str);
		boolean isLastSpace = true;
		for(int i = 0; i < builder.length(); i++) {
			char ch = builder.charAt(i);
			if(isLastSpace && ch >= 'a' && ch <='z') {
				builder.setCharAt(i, (char)(ch + ('A' - 'a') ));
				isLastSpace = false;
			} else if (ch != ' ') {
				isLastSpace = false;
			} else {
				isLastSpace = true;
			}
		}
		return builder.toString();
	}
}
