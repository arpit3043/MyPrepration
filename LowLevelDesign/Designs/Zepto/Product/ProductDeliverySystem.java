package Designs.Zepto.Product;

import java.util.List;

import Designs.Zepto.Inventory;
import Designs.Zepto.Cart.Cart;
import Designs.Zepto.Order.Order;
import Designs.Zepto.Order.OrderController;
import Designs.Zepto.User.User;
import Designs.Zepto.User.UserController;
import Designs.Zepto.Warehouse.Warehouse;
import Designs.Zepto.Warehouse.WarehouseController;
import Designs.Zepto.Warehouse.WarehouseSelectionStrategy;

public class ProductDeliverySystem {

    UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;

    ProductDeliverySystem(List<User> userList, List<Warehouse> warehouseList){
        userController = new UserController(userList);
        warehouseController = new WarehouseController(warehouseList , null);
        orderController = new OrderController();
    }

    //get user object
    public User getUser(int userId){
        return userController.getUser(userId);
    }

    //get warehouse
    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);

    }

    //get inventory
    public Inventory getInventory(Warehouse warehouse){
        return warehouse.inventory;

    }

    //add product to cart
    public void addProductToCart(User user, ProductCategory product, int count){
        Cart cart = user.getUserCart();
        cart.addItemInCart(product.productCategoryId, count);
    }

    //place order
    public Order placeOrder(User user, Warehouse warehouse){
        return orderController.createNewOrder(user, warehouse);
    }

    public void checkout(Order order){
        order.checkout();
    }

}
