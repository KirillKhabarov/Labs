package Model;

import java.util.ArrayList;

public class ISort implements Strateg{

    @Override
    public ArrayList<Long> sort(ArrayList<String> arr) {
        ArrayList<Long> mas = new ArrayList<Long>();
        for(int l=0;l<arr.size();l++)
        {
            mas.add(Long.parseLong(arr.get(l)));
        }


        boolean isSorted = false;
        long buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.size()-1; i++) {
                if(mas.get(i) > mas.get(i+1)){
                    isSorted = false;
                    buf = mas.get(i);
                    mas.set(i,mas.get(i+1));
                    mas.set(i+1,buf);
                }
            }
        }
//        ArrayList<String> ret = new ArrayList<String>();
//        for(int l=0;l<mas.size();l++)
//        {
//            ret.add(mas.get(l).toString());
//        }
      return mas;

    }
}
