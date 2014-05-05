package Week3;

import java.util.*;

/**
 * Created by zyixc on 5-5-2014.
 */
public class Calculate34 {
    public static void main(String[] args) {
        List<String> numberslist = new ArrayList<String>(Arrays.asList(args));
        Collections.sort(numberslist);

        System.out.println("Maximum: "+maximum(numberslist));
        System.out.println("Median: "+median(numberslist));
        System.out.println("StandardDeviation: "+standard_deviation(numberslist));
    }

    private static String maximum(List<String> numberslist){
        return numberslist.get(numberslist.size() - 1);
    }

    private static String median(List<String> numberslist){
        String result = null;
        if(numberslist.size()%2==0){
            int middle = numberslist.size() / 2;
            int middleright = Integer.parseInt(numberslist.get(middle));
            int middleleft = Integer.parseInt(numberslist.get(middle - 1));

            result = Integer.toString((middleright + middleleft)/2);
        }else{
            result = numberslist.get(numberslist.size()/2);
        }
        return result;
    }

    private static String standard_deviation(List<String> numberslist){
        int total = 0;
        for(int i=0; i<numberslist.size(); i++){
            total += Integer.parseInt(numberslist.get(i));
        }
        //wrong?
        String result = Integer.toString(total/numberslist.size());
        return result;
    }
}
