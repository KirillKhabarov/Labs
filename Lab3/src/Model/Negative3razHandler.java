package Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class Negative3razHandler extends Handler {

    public Negative3razHandler(Handler processor) {
        super(processor);
    }
    public boolean process(Integer request, Player pl, ImageView iv) {

        if(request<LOSS || pl.getCount()!=2) return super.process(request,pl,iv);// не свой запрос передается дальше по цепочке

        else {//свой, обрабатывается здесь
            iv.setImage(new Image("Img/PouchN.jpg"));
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Вы проиграли 3й раз подряд!");
            alert.setHeaderText("Вы получаете еще шанс!");
            pl.addNumber(1);
            pl.restartCount();
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
