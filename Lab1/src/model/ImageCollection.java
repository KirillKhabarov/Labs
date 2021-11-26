package model;

import javafx.scene.image.Image;

public class ImageCollection implements Aggregate {
    private String filetopic;
    private Image bi;
    public ImageCollection(String filetopic) {

        this.filetopic = filetopic;
    }
    private class ImageIterator implements Iterator {
        public int current=1;
        @Override
        public boolean hasNext() {
            String
                    filename="/Img/"+filetopic+(current+1)+".png";
            try {
                bi = new Image(filename);

                return true;

            } catch (Exception ex) {
                //System.err.println("Неудалось загрузить картинку! " + filename );
               // ex.printStackTrace();
                 return false;
            }
        }

        public boolean hasBack() {
            String
                    filename="/Img/"+filetopic+(current-1)+".png";
            try {
                bi = new Image(filename);

                return true;

            } catch (Exception ex) {
                //System.err.println("Неудалось загрузить картинку! " + filename );
                // ex.printStackTrace();
                return false;
            }
        }
        @Override
        public Object next() {

            if(this.hasNext()){
                current++;
                return bi;
            }


            return null;
        }

        @Override
        public Object preview() {
            if(hasBack()){
                current--;
                return bi;
            }

            return null;
        }
    }

    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
}
