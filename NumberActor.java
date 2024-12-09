
import greenfoot.*;

public class NumberActor extends Actor {
    private boolean dragging = false;
    
    private int value;
    public NumberActor(int value) {
        this.value = value;
        setImage(new GreenfootImage(String.valueOf(value), 24, greenfoot.Color.BLACK, greenfoot.Color.WHITE));
    }

    public void act() {
        if (Greenfoot.mouseDragged(this)) {
            dragging = true;
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        } else if (dragging && Greenfoot.mouseDragEnded(this)) {
            dragging = false;
            checkDrop();
        }
    }

    private void checkDrop() {
        BucketActor bucket = (BucketActor) getOneIntersectingObject(BucketActor.class);
        if (bucket != null) {
            bucket.addNumber(getValue());
            getWorld().removeObject(this);
        }
    }

    public int getValue() {
        return Integer.parseInt(getImage().toString());
    }
}
