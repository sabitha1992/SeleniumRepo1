package Examples;



import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections4.Put;
import org.apache.commons.compress.utils.Sets;

public class CharactersinString {

	

	

	public static void main(String[] args) {
		
	noOfRepeatedCharactersInString("including webpages image");	
	noOfRepeatedCharactersInString("Comprehensive");	
		
	}

	private static void noOfRepeatedCharactersInString(String str) {
		char[] allchars=str.toCharArray();
		
		HashMap<Character, Integer> hmap=new HashMap<Character,Integer>();
	
		 for (int i = 0; i < allchars.length; i++) {
			Character c  = allchars[i];
			//System.out.println(c);
			if (hmap.containsKey(c)) {
				hmap.put(c,hmap.get(c)+1); 
			} else {
             hmap.put(c,1);
			}
		}
		System.out.println(hmap);
		
		Set<Entry<Character,Integer>> entries=hmap.entrySet();
		for(Entry<Character,Integer> entry:entries) {
			System.out.println(entry.getKey()+"---"+entry.getValue());
			
			
		}
	}

	
	}


		
	

