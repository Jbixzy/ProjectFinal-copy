
import greenfoot.*;
import java.util.ArrayList;

public class RightHoop extends Actor {
    private ArrayList<Integer> contents = new ArrayList<>();
    
    public RightHoop(){
        GreenfootImage image = new GreenfootImage("hoop.png");
        image.scale(50,50);
        setImage(image);
    }
    public void addToHoop(int value) {
        contents.add(value);
    }

    public ArrayList<Integer> getContents() {
        return contents;
    }

    public void clearContents() {
        contents.clear();
    }
}