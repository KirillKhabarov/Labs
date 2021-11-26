package Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class NegativeHandler extends Handler {

    public NegativeHandler(Handler processor) {
        super(processor);
    }
    public boolean process(Integer request, Player pl, ImageView iv) {

        if(request<LOSS || pl.getCount()==2) return super.process(request,pl,iv);// не свой запрос передается дальше по цепочке

        else {//свой, обрабатывается здесь
            iv.setImage(new Image("Img/PouchN.jpg"));
            Alert alert = new Alert(Alert.AlertType.ERROR);
            pl.addCount();
            alert.setTitle("Вы проиграли!");
            alert.setHeaderText("Монетка потеряна, но всегда можно отыграться!");
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
