import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


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

    //

    public static StringBuffer processFile( String filename)throws EmptyFileException, IOException {
     StringBuffer content = new StringBuffer();
    File file = new File(filename);

    while (!file.exists()) {
        Scanner input = new Scanner(System.in);
        filename = input.nextLine();
        file = new File(filename);
    }

    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    while ((line = reader.readLine()) != null) {
        content.append(line);
    }
    reader.close();
     if (content.length() == 0) {
        throw new EmptyFileException(filename + " was empty");
    }

    return content;
}

public static void main(String[] a) {
    // our string is on a new seperate line
    System.out.println();
        //string that we will print out in the end
    String str = ""; 

    try {
        String filename = a[0];
        String stopword;
        if (a.length > 1) {
        stopword = a[1];
        } else {
        stopword = null;
        }

        StringBuffer text;
        try {
            text = processFile(filename);
        } catch (EmptyFileException e) {
            //found an exception but continue 
            text = new StringBuffer("");
        }

        int count = processText(text, stopword);
        str = "Found " + count + " words.";

        //catch exceptions if try matches any of them
    }
    catch (TooSmallText e) {
        str = e.toString();
    }
    catch (InvalidStopwordException e) {
        str = e.toString();
    }
    
    catch (Exception e) {
        str = "error";
    }
    System.out.println(str);
}
}
    
        



