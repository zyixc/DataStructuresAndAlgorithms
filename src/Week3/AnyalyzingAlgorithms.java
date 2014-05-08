package Week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Created by zyixc on 8-5-2014.
 */
public class AnyalyzingAlgorithms {
    public static void main(String[] args) throws IOException{
        String searchterm = null;
        int snippetlength = 0;

        if(args.length > 1){
            searchterm = args[0];
            if(Integer.parseInt(args[1])>=0)
                snippetlength = Integer.parseInt(args[1]);
        }else{
            System.out.println("Not enough arguments entered! Usage: Search Term, Snippet ");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader("textfile.txt"));
        algorithmArrayListVersion1(br,searchterm,snippetlength);

        BufferedReader br2 = new BufferedReader(new FileReader("textfile2.txt"));
        algorithmArrayListVersion1(br2,searchterm,snippetlength);
    }

    public static void algorithmArrayListVersion1(BufferedReader br, String searchterm, int snippetlength) throws IOException{
        /*
         * O { Log(n) * Log(N) + N * Log(N) };
         */
        Stopwatch timer = new Stopwatch();
        String line = null;
        List<String> wordlist = new ArrayList<String>();
        while ((line = br.readLine()) != null) { //Log(N)
            for(String word : line.split("[-!~\\s]+")) { //Log(N)
                wordlist.add(word);
            }
        }
        System.out.println(">>>> algorithmArrayListVersion1 results:");
        for(int i =0; i<wordlist.size(); i++){ //N
            if(wordlist.get(i).equals(searchterm)){
                StringBuilder temp = new StringBuilder();
                for(int j = (i - snippetlength); j<(i+snippetlength+1) ; j++){ //Log(N)
                    temp.append(wordlist.get(j));
                    temp.append(" ");
                }
                //System.out.println("> "+temp);
            }
        }
        double time = timer.elapsedTime();
        System.out.println(">> algorithm finished, time elapsed: " + time);
    }
}
