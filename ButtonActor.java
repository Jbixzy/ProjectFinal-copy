
import greenfoot.*;

public class ButtonActor extends Actor {
    private String action;

    public ButtonActor(String action) {
        this.action = action;
        setImage(new GreenfootImage(action, 24, greenfoot.Color.BLACK, greenfoot.Color.WHITE));
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            GameWorld world = (GameWorld) getWorld();
            if (action.equals("Check Partition")) {
                world.checkPartition();
            } else if (action.equals("Check List")) {
                world.checkFinalList();
            }
        }
    }
}
