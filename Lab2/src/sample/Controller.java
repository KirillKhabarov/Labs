package sample;

import Model.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller {
    public ListView demlist;
    public TextField data;
    public RadioButton STR;
    public RadioButton FLO;
    public RadioButton INT;
    Adapter demo=new Adapter();
    SortingContext sc=new SortingContext();

    public void add(ActionEvent actionEvent) {
        var a=data.getText();
        demo.add(Long.parseLong(a));
        demlist.getItems().clear();
       demlist.getItems().addAll(demo.display());
    }

    public void del(ActionEvent actionEvent) {
        demo.del();
        demlist.getItems().clear();
        demlist.getItems().addAll(demo.display());
    }

    public void pos(ActionEvent actionEvent) {
        //ListViewItem newItem = new ListViewItem("1");
        demlist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        var a=demo.find(data.getText());
        for (int i = 0; i < a.size(); i++) {
            demlist.getSelectionModel().select(a.get(i)-1);
            System.out.println(a.get(i));
        }
        System.out.println(demo.find(data.getText()).toString());
    }

    public void zap(ActionEvent actionEvent) {
        demo.delAll();
        for (int i = 0; i < 10; i++) {
            demo.add(getRandomNumber(0,20));
        }
        demlist.getItems().clear();
        demlist.getItems().addAll(demo.display());
      }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void sort(ActionEvent actionEvent) {
        ArrayList<Long> arrs=sc.sortNumbers(demo.display());
        demo.delAll();
        for (int i = 0; i < arrs.size(); i++) {
            var a=arrs.get(i);
            demo.add(a);
        }
        demlist.getItems().clear();
        demlist.getItems().addAll(demo.display());
    }

    public void Drb(ActionEvent actionEvent) {
        sc.setSortingMethod(new IBrakeSort());
    }

    public void Irb(ActionEvent actionEvent) {
        sc.setSortingMethod(new ISort());
    }

    public void Srb(ActionEvent actionEvent) {
        sc.setSortingMethod(new SSort());
    }
//    linklist
//    Adapter demo=new Adapter();
}
