package Week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Created by zyixc on 8-5-2014.
 */
public class AnyalyzingAlgorithms {
    public static void main(String[] args) throws IOException, InterruptedException{
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

        System.err.println(">WARNING!!, results not 'trustworthy'");

        BufferedReader br = new BufferedReader(new FileReader("textfile.txt"));
        algorithmList(new ArrayList<String>(),br, searchterm, snippetlength);
        br.close();

        BufferedReader br2 = new BufferedReader(new FileReader("textfile2.txt"));
        algorithmList(new ArrayList<String>(),br2, searchterm, snippetlength);
        br2.close();

        BufferedReader br3 = new BufferedReader(new FileReader("textfile.txt"));
        algorithmList(new LinkedList<String>(),br3, searchterm, snippetlength);
        br3.close();

        BufferedReader br4 = new BufferedReader(new FileReader("textfile2.txt"));
        algorithmList(new LinkedList<String>(),br4, searchterm, snippetlength);
        br4.close();

        BufferedReader br5 = new BufferedReader(new FileReader("textfile.txt"));
        algorithmList(new Vector<String>(),br5, searchterm, snippetlength);
        br5.close();

        BufferedReader br6 = new BufferedReader(new FileReader("textfile2.txt"));
        algorithmList(new Vector<String>(),br6, searchterm, snippetlength);
        br6.close();
    }

    public static void algorithmList(List<String> wordlist,BufferedReader br, String searchterm, int snippetlength) throws IOException{
        /*
         *
         */
        Stopwatch timer = new Stopwatch();
        String line = null;
        while ((line = br.readLine()) != null) {
            for(String word : line.split("[-!~\\s]+")) {
                wordlist.add(word);
            }
        }
        double time = timer.elapsedTime();
        System.out.print(">>>> " + wordlist.getClass().getName());
        System.out.printf(" : [Words processed:  %d |Time elapsed:  %.3f ]\n",wordlist.size(),time);

        /*
         * N
         */

        int position = 0;
        int results =0;
        Stopwatch timer2 = new Stopwatch();
        for(String word : wordlist) {
            if (word.equals(searchterm)) {
                StringBuilder temp = new StringBuilder();
                for (int i = (position - snippetlength); i < (position + snippetlength + 1); i++) {
                    temp.append(wordlist.get(i)); //[http://programcreek.com/2013/03/arraylist-vs-linkedlist-vs-vector/]
                    temp.append(" ");
                }
                //System.out.println(">> "+ temp);
                results++;
            }
            position++;
        }
        double time2 = timer2.elapsedTime();
        System.out.printf(">> algorithm finished: [Results found: %d |Time elapsed: %.3f]\n\n",results,time2);
    }
}
