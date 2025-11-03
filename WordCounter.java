import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

public static int processText(StringBuffer str, String WrdStopper) throws InvalidStopwordException, TooSmallText {
        Pattern regex = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = regex.matcher(str);
        int count=0;
        boolean FoundStopWord = false;


        if(WrdStopper == null){
                while(matcher.find()){
                        count++;
                }
                if (count < 5) {
                throw new TooSmallText("Only found " + count + " words.");
            }
                return count;



        }

        int stopWordCount = 0;

        while(matcher.find()){
        count++;        
        String word = matcher.group();


        if(word.equals(WrdStopper)){
                FoundStopWord = true;
                stopWordCount = count;
        }
}
                
        if (count < 5) {
        throw new TooSmallText("Only found " + count + " words.");
            }
        

            if(!FoundStopWord){
            throw new InvalidStopwordException("Couldn't find stopword: " + WrdStopper);
        }

        return stopWordCount;
    }
}

