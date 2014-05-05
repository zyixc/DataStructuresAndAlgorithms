package Week3;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
/**
 * Created by zyixc on 5-5-2014.
 */
public class CountUniqueWordsCount {
    private static String filestring;
    private static String[] words;
    private static Map<String,Integer> uniquewords = new HashMap<String,Integer>();

    public static void main(String [] args) {

        try {
            byte[] encoded = Files.readAllBytes(Paths.get("textfile.txt"));
            filestring = new String(encoded, Charset.defaultCharset());
            words = filestring.split("[-!~\\s]+");

            for(String word : words){
                if(uniquewords.containsKey(word)){
                    uniquewords.put(word,uniquewords.get(word).intValue()+1);
                }else{
                    uniquewords.put(word,1);
                }
            }

            System.out.println("Number of Words: "+uniquewords.size());
            Iterator it = uniquewords.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry pairs = (Map.Entry) it.next();
                System.out.println(pairs.getKey() + " " + pairs.getValue());
                it.remove();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
