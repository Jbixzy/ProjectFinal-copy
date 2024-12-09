
import greenfoot.*;

public class CheckButton extends Actor {
    private String buttonName;

    public CheckButton(String name) {
        this.buttonName = name;
        setImage(new GreenfootImage(name, 24, greenfoot.Color.BLACK, greenfoot.Color.LIGHT_GRAY));
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            GameWorld world = (GameWorld) getWorld();
            if (buttonName.equals("Check Partition")) {
                world.checkPartition();
            } else if (buttonName.equals("Check List")) {
                world.checkFinalList();
            }
        }
    }
}
