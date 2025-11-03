import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

public static int processText(StringBuffer str, String WrdStopper) throws InvalidStopwordException {
        Pattern regex = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = regex.matcher(str);
        int count=0;

        if(WrdStopper == null){
                while(matcher.find()){
                        count++;
                }
                return count;



        }

        

        while(matcher.find()){
        count++;        
        String word = matcher.group();


        if(word.equals(WrdStopper)){
                        return count;
                        
                }


        }
        throw new InvalidStopwordException("Couldn't find stopword: " + WrdStopper);
}
}
