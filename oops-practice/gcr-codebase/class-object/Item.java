package week02.gcrCodebase.classObject;

public class Item {
	private String itemCode;
    private String itemName;
    private double price;
    //Display mt
    void displayItem() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
    }

    public static void main(String[] args) {
    	Item i1 = new Item();
        i1.itemCode = "01AA";
        i1.price = 500.0;
        i1.itemName = "Water bottle";

        Item i2 = new Item();
        i2.itemCode = "01BB";
        i2.price = 700.0;
        i2.itemName = "Rice";

        Item i3 = new Item();
        i3.itemCode = "02AA";
        i3.price = 400.0;
        i3.itemName = "blackboard";
        //displaying mobile phones 
        i1.displayItem();
        i2.displayItem();
        i3.displayItem();
    }

}
