package Week3;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zyixc on 5-5-2014.
 */
public class CountUniqueWords {
    private static String filestring;
    private static String[] words;
    private static Set<String> uniquewords = new HashSet<String>();

    public static void main(String [] args) {


        try {
            byte[] encoded = Files.readAllBytes(Paths.get("textfile.txt"));
            filestring = new String(encoded,Charset.defaultCharset());
            words = filestring.split("[-!~\\s]+");

            for(String word : words){
                uniquewords.add(word);
            }

            System.out.println("Number of Words: "+uniquewords.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
