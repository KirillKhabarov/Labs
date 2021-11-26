package Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class ActiveHandler extends Handler{

    public ActiveHandler(Handler processor) {
        super(processor);
    }
    public boolean process(Integer request, Player pl, ImageView iv) {

        if(request!=Win) return super.process(request,pl,iv);// не свой запрос передается дальше по цепочке

        else {//свой, обрабатывается здесь
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Вы победили!");
            alert.setHeaderText("Вы выиграли 7 монет!");
            pl.addNumber(5);
            pl.restartCount();
            iv.setImage(new Image("Img/PouchM.jpg"));
            ButtonType replay = new ButtonType("Продолжить играть", ButtonBar.ButtonData.YES);
            ButtonType vacation = new ButtonType("Отдохнуть", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(replay, vacation);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().getButtonData() == ButtonBar.ButtonData.YES)
                return true;
            else
                return false;        }
    }
}
