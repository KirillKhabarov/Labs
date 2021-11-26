package sample;

import Model.ActionChain;
import Model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Label Mon;
    public Label StGame;
    public Label NamePl;
    public HBox Hbx;
    ActionChain action = null;
    Player player1;
    ImageView[] v = new ImageView[2];

    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < v.length; i++) {
            v[i]=new ImageView();
            v[i].setImage(new Image("Img/Pouch.jpg"));
            v[i].setFitWidth(200);
            v[i].setFitHeight(150);
            v[i].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ImageView view = (ImageView) mouseEvent.getSource();
                    if (action == null) return;//если цепочка обработки отсутствует
                    if (action.process(player1, view)) init();//продолжить играть и проверить наличия монетки у игрока
                    else {//завершить игру, сделав обработку недоступной
                        action = null;
                        StGame.setText("Игра не активна");
                    }

                    Mon.setText(player1.getNumber().toString());
                }
            });
            Hbx.getChildren().add(v[i]);
        }
        TextInputDialog alert = new TextInputDialog();
        alert.setTitle("Регистрация!");
        alert.setHeaderText("");
        TextField textField = new TextField("Player");
        alert.setContentText("Ваше имя:");
        Optional<String> rez = alert.showAndWait();
        if (rez.isPresent()) {
            NamePl.setText("Игрок " + rez.get());
            player1 = new Player("rez.get()", 1);
            Mon.setText(player1.getNumber().toString());
        } else {
            initialize(location, resources);
        }
    }

    private boolean init() {
        if (!player1.pay(1)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Средств на счете недостаточно, еще монетку плисс!");
            alert.show();
            action = null;
            StGame.setText("Игра не активна");
            return false;
        } else return true;
    }


    public void onPay(ActionEvent actionEvent) {
        player1.addNumber(1);
        Mon.setText(player1.getNumber().toString());
    }

    public void onStart(ActionEvent actionEvent) {
        if (!init()) return;//проверка ликвидности
        for (int i = 0; i < v.length; i++) {
            v[i].setImage(new Image("Img/Pouch.jpg"));
        }
        action = new ActionChain();//запуск механизма розыгрыша
        StGame.setText("Игра активна");
        Mon.setText(player1.getNumber().toString());
    }
}