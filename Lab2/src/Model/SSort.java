package Model;

import java.util.ArrayList;
import java.util.Collections;

public class SSort implements Strateg{
    @Override
    public ArrayList<Long> sort(ArrayList<String> arr) {
        Collections.sort(arr);
        ArrayList<Long> mas = new ArrayList<Long>();
        for(int l=0;l<arr.size();l++)
        {
            mas.add(Long.parseLong(arr.get(l)));
        }
        return mas;
    }
}
