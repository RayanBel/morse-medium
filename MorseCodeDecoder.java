// https://www.codewars.com/kata/54b72c16cd7f5154e9000457

import java.util.regex.Pattern;

public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
        String cleaned=bits.replaceAll("^0+|0+$","");
        int times = cleaned.length();
        if(cleaned.contains("0"))
            for(int i=1;i<cleaned.length();i++){
                System.out.println("Bucle: "+i);
                if(Pattern.compile("([^1]|^)1{"+i+"}([^1]|$)").matcher(cleaned).find()||
                   Pattern.compile("[^0]0{"+i+"}[^0]").matcher(cleaned).find()){
                    times=i;
                    break;
                }
            }
        
        String result=cleaned
          .replaceAll("1{"+times+"}","1").replaceAll("0{"+times+"}","0")
          .replaceAll("0000000","   ").replaceAll("000"," ")
          .replaceAll("111","-").replaceAll("1",".")
          .replaceAll("0","");
        
        return result;
    }
    
    public static String decodeMorse(String morseCode) {        
        String letters[]=morseCode.trim().split(" ");
        String sentence="";
      
        for(int i=0; i<letters.length;i++){
            if(letters[i].isEmpty()&&letters[i+1].isEmpty()){
                sentence+=" ";
                i++;
            }
            else
                sentence+=MorseCode.get(letters[i]);
        }
        
        return sentence;
    }
}
