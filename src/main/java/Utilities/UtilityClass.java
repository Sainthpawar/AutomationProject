package Utilities;
import java.util.List;


public class UtilityClass {

	public static boolean verifyLinksText(List<String> lnk,String s1){
		
		for(String s:lnk){
		if(!s.toLowerCase().contains(s1)){
			return false;
		}
		}	
	
	return true;
}
}
