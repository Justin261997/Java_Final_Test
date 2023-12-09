import java.util.ArrayList;
import java.util.List;

class Box {
    private int maxItems;
    private int boxNumber;
    private List<Object> contents;

    public Box(int maxItems, int boxNumber) {
        this.maxItems = maxItems;
        this.boxNumber = boxNumber;
        this.contents = new ArrayList<>();
    }

    public void addItem(Object item) {
        if (contents.size() < maxItems) {
            contents.add(item);
        } else {
            System.out.println("Box " + boxNumber + " is full, cannot add more items.");
        }
    }

    public void displayContents() {
        //System.out.println("Contents of Box " + boxNumber + ":");
        for (Object item : contents) {
            if (item instanceof SingleObject) {
                System.out.println("  " + ((SingleObject) item).getName());
            } else if (item instanceof Box) {
                ((Box) item).displayContents();
            }
        }
    }

    public int findBoxNumber(String itemName) {
        for (Object item : contents) {
            if (item instanceof SingleObject && ((SingleObject) item).getName().equals(itemName)) {
                return boxNumber;
            } else if (item instanceof Box) {
                int innerBoxNumber = ((Box) item).findBoxNumber(itemName);
                if (innerBoxNumber != -1) {
                    return innerBoxNumber;
                }
            }
        }
        return -1;
    }
}
