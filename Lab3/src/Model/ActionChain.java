package Model;

import javafx.scene.image.ImageView;

import java.util.Random;

public class ActionChain {
    Handler chain;
    Random generate;
    final int NUMHANDLER = 9;

    public ActionChain() {
        generate = new Random();
        buildChain();
    }

    private void buildChain() {
        chain = new NegativeHandler(new Negative3razHandler(new PositiveHandler(new ActiveHandler(null))));
    }

    public boolean process(Player pl, ImageView iv) {
        int type = generate.nextInt(NUMHANDLER);//розыгрыш
        return process(type,pl,iv);
    }

    public boolean process(Integer a,Player pl, ImageView iv) {
        return chain.process( 1+a % NUMHANDLER,pl,iv);//обрезка по числу имеющихся обработчиков
    }
}