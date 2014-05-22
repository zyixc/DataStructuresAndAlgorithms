package Week3;

import edu.princeton.cs.algs4.Stopwatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Created by zyixc on 8-5-2014.
 */
public class AnyalyzingAlgorithms {
    private static String FILENAME = "textfile2.txt";
    private static int RUN_TIMES = 80;
    public static void main(String[] args) throws IOException, InterruptedException{
        String searchterm = null;
        int snippetlength = 2;

        if(args.length > 1){
            searchterm = args[0];
            if(Integer.parseInt(args[1])>=0)
                snippetlength = Integer.parseInt(args[1]);
        }else{
            System.out.println("Not enough arguments entered! Usage: Search Term, Snippet ");
            return;
        }

        System.err.println(">WARNING!!, results not 'trustworthy'");
//        System.out.println(">>ArrayList");
//        for(int i = 0; i < RUN_TIMES; i++) {
//            double processtime = algorithmList(new ArrayList<String>(), 2^i, searchterm, snippetlength);
//            System.out.println((2^i) + "\t" + processtime);
//        }
//        System.out.println(">>LinkedList");
//        for(int i = 0; i < RUN_TIMES; i++) {
//            double processtime = algorithmList(new LinkedList<String>(), 2^i, searchterm, snippetlength);
//            System.out.println("plot(" + (2^i) + "," + processtime + ",'-or');");
//        }
        System.out.println(">>Vector");
        for(int i = 0; i < RUN_TIMES; i++) {
            double processtime = algorithmList(new Vector<String>(), 2^i, searchterm, snippetlength);
            System.out.println((2^i) + "\t" + processtime);
        }
    }

    public static double algorithmList(List<String> wordlist, int times_file, String searchterm, int snippetlength) throws IOException{
        /*
         *
         */
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < times_file; i++){
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String line = null;
            while ((line = br.readLine()) != null) {
                for (String word : line.split("[-!~\\s]+")) {
                    wordlist.add(word);
                }
            }
        }
        //double time = timer.elapsedTime();
        //System.out.print(">>>> " + wordlist.getClass().getName());
        //System.out.printf(" : [Words processed:  %d |Time elapsed:  %.3f ]\n",wordlist.size(),time);

        /*
         * N
         */

        int position = 0;
        int results =0;
        //Stopwatch timer2 = new Stopwatch();
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
        //double time2 = timer2.elapsedTime();
        return timer.elapsedTime();
        //System.out.printf(">> algorithm finished: [Results found: %d |Time elapsed: %.3f]\n\n",results,time2);
    }
}
