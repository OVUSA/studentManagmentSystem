package studentManagementSystem;

public class StudentValidator {

    public static boolean validateBirthDate(String date) {
    	   	
    	String[] bdate = date.split("-"); //  check for "-" char
    	int[] bday = new int [bdate.length];
    	
    	for ( int i = 0; i< bdate.length;i++) {
    		bday[i] = Integer.parseInt(bdate[i]);
    	}
    	 if (bday[0] < 1 || bday[0]>12 ) {// month
    		return false;
    	 }
     	 if ( bday[1] < 1 || bday[1]>31) { // FIXME if it is february. DAY
    		return false;
     	 }
     	if ( bday[2] < 1940 || bday[2]>2015) { // FIXME Exception thread!!! YEAR
     		
    		return false;
     	 }
     	else {
     		return true;
     	}
    }
}
