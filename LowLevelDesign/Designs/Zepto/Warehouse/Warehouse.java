package Designs.Zepto.Warehouse;

import java.util.Map;

import Designs.Zepto.Address;
import Designs.Zepto.Inventory;

//warehouse or store, which generally manages the inventory or act as Inventory controller
public class Warehouse {

    Inventory inventory;
    Address address;

    //update inventory
    public void removeItemFromInventory(Map<Integer, Integer> productCategoryAndCountMap){

        //it will update the items in the inventory based upon product category.
        inventory.removeItems(productCategoryAndCountMap);
    }

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap){

        //it will update the items in the inventory based upon product category.
    }
}
