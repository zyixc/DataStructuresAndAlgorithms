package Week5;

import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.Stopwatch;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by zyixc on 23-5-2014.
 */
public class scrabblewordchecklinearprobing {
    public static void main(String[] args) {
        String searchterm = "a-wringing";
        try {
            Stopwatch timer = new Stopwatch();
            LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();

            byte[] encoded = Files.readAllBytes(Paths.get("dickens.txt"));
            String filestring = new String(encoded, Charset.defaultCharset());
            String[] words = filestring.split("[!~\\s]+");

            for(int i = 0; i < words.length; i++){
                st.put(words[i],i+1);
            }System.out.println("size: "+st.size());
            double time = timer.elapsedTime();

            Stopwatch timer2 = new Stopwatch();
            System.out.println("Result: "+st.get(searchterm)+" "+searchterm);
            double time2 = timer2.elapsedTime();
            System.out.printf("Processing file: %.3f sec| Get result: %.3f sec",time,time2);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
