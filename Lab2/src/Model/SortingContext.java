package Model;

import java.util.ArrayList;

public class SortingContext {

    private Strateg strategy;

    public void setSortingMethod(Strateg strategy) {
        this.strategy = strategy; }

    public Strateg getStrategy() {
        return strategy; }

    public ArrayList<Long> sortNumbers(ArrayList<String> arr){
       return strategy.sort(arr); }

}
