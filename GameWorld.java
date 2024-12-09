
import greenfoot.*;
import java.util.*;

public class GameWorld extends World {
    private int pivot;
    private LeftHoop leftHoop;
    private RightHoop rightHoop;
    private ArrayList<Integer> numbers;
    private CheckButton checkButton;

    public GameWorld() {    
        super(800, 600, 1); 
        prepareGame();
        generateNumbers();

        displayNumbers();

        prepareGame();
        CheckButton checkPartitionButton = new CheckButton("Check Partition");
        addObject(checkPartitionButton, getWidth() / 2 - 100, getHeight() - 50);

        // Add Check List button
        CheckButton checkListButton = new CheckButton("Check List");
        addObject(checkListButton, getWidth() / 2 + 100, getHeight() - 50);
    }

    private void generateNumbers() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            numbers.add(Greenfoot.getRandomNumber(50) + 1);
        }
    }

    private void displayNumbers() {
        int x = 100;
        for (int num : numbers) {
            addObject(new NumberActor(num), x, 200);
            x += 50;
        }
        pivot = numbers.get(0);
        addObject(new PivotIndicator(pivot), 100, 150);
    }

    private void prepareGame() {
        pivot = 5; // Example pivot value
        leftHoop = new LeftHoop();
        rightHoop = new RightHoop();
        addObject(leftHoop, 200, 300);
        addObject(rightHoop, 600, 300);
        showText("Pivot: " + pivot, getWidth() / 2, 50);

    }

    public void checkPartition() {
        ArrayList<Integer> leftContents = leftHoop.getContents();
        ArrayList<Integer> rightContents = rightHoop.getContents();
        boolean leftValid = true;
        boolean rightValid = true;

        for (int num : leftContents) {
            if (num >= pivot) {
                leftValid = false;
                break;
            }
        }

        for (int num : rightContents) {
            if (num <= pivot) {
                rightValid = false;
                break;
            }
        }

        if (leftValid && rightValid) {
            showText("Partition Correct!", getWidth() / 2, 100);
        } else {
            showText("Partition Incorrect! Try again.", getWidth() / 2, 100);
        }
    }

    private void clearBuckets() {
        leftHoop.clearContents();
        rightHoop.clearContents();
        pivot = -1; // Reset the pivot
    }

    private void displaySortedList(ArrayList<Integer> sortedList) {
        int xStart = 100; // Starting x-coordinate
        int y = getHeight() / 2; // Fixed y-coordinate for the sorted list
        int spacing = 50; // Space between numbers

        // Remove all existing number actors from the world
        removeObjects(getObjects(NumberActor.class));

        // Display the sorted list
        for (int i = 0; i < sortedList.size(); i++) {
            NumberActor number = new NumberActor(sortedList.get(i));
            addObject(number, xStart + (i * spacing), y);
        }
    }

    public void checkFinalList() {
        // Retrieve numbers from left and right buckets
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(leftHoop.getContents());
        sortedList.add(pivot);
        sortedList.addAll(rightHoop.getContents());

        // Debugging: Print contents to console
        System.out.println("Left Hoop: " + leftHoop.getContents());
        System.out.println("Pivot: " + pivot);
        System.out.println("Right Hoop: " + rightHoop.getContents());

        // Sort the list
        Collections.sort(sortedList);

        // Check if the list is sorted correctly
        boolean isSorted = true;
        for (int i = 0; i < sortedList.size() - 1; i++) {
            if (sortedList.get(i) > sortedList.get(i + 1)) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            showText("List Sorted Correctly! You Win!", getWidth() / 2, 150);

            // Display the sorted numbers back in the world
            displaySortedList(sortedList);
        } else {
            showText("List Incorrect! Keep Trying.", getWidth() / 2, 150);
        }
    }

}
