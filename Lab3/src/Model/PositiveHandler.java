package Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;


public class PositiveHandler extends Handler{

        public PositiveHandler(Handler processor) {
            super(processor);
        }
        public boolean process(Integer request, Player pl, ImageView iv) {

            if(request==Win || request>=LOSS) return super.process(request,pl,iv);// не свой запрос передается дальше по цепочке

            else {//свой, обрабатывается здесь
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Вы победили!");
                alert.setHeaderText("Вы выиграли монету!");
                pl.addNumber(1);
                pl.restartCount();
                iv.setImage(new Image("Img/money.jpg"));
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

