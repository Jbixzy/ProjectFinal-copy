import greenfoot.*;
import java.util.ArrayList;

public class BucketActor extends Actor {
    private ArrayList<Integer> contents = new ArrayList<>();

    public void addNumber(int number) {
        contents.add(number);
    }

    public boolean isValid(int pivot, boolean isLeftBucket) {
        for (int num : contents) {
            if (isLeftBucket && num >= pivot) return false;
            if (!isLeftBucket && num <= pivot) return false;
        }
        return true;
    }
}

