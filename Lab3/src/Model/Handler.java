package Model;

import javafx.scene.image.ImageView;

public abstract class Handler  {
    final int Win=1;
    final int LOSS=4;
    private Handler processor;

    public Handler(Handler processor){
        this.processor = processor;
    }


    public boolean process(Integer request,Player pl, ImageView iv){
        if(processor != null)
            return processor.process(request,pl,iv);
        else
            return true;

    }

}
