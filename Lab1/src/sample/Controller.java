package sample;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.ImageCollection;
import model.Iterator;
import javafx.event.EventHandler;



public class Controller {

    public ImageCollection imgs =new ImageCollection("");
    public Iterator iter_main = imgs.getIterator();

    public ImageView Img;

    public Timeline timeline =new Timeline();
    public void initialize()
    {

        timeline.setCycleCount(Timeline.INDEFINITE);//кол-во повторов
        Duration d=new Duration(1000);
        EventHandler eh=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (iter_main.hasNext()) {
                    Image name = (Image) iter_main.next();
                     Img.setImage(name);
                }
            }
        };
        KeyFrame kf=  new KeyFrame(d, eh);

        timeline.getKeyFrames().add(kf);
    }

    public void Start(ActionEvent actionEvent) {
        timeline.play();
    }

    public void Stop(ActionEvent actionEvent) {
        timeline.stop();
    }

    public void back(ActionEvent actionEvent) {
        if (iter_main.hasBack()) {
            Image name = (Image) iter_main.preview();
            Img.setImage(name);
        }
    }

    public void next(ActionEvent actionEvent) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            Img.setImage(name);
        }
    }
}
