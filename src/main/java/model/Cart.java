package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private int cartId;
    private User user;
    private List<CartItem> cartItems;

    public Cart(int cartId, User user) {
        this.cartId = cartId;
        this.user = user;
    }

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    /*
    Tinh tong so luong san pham
     */
    public int calculateTotalQuantity(){
        int totalQuantity = 0;
        // san pham co trogn gio hang khac null
            if(cartItems != null){
                for (CartItem cartItem : cartItems) {
                    totalQuantity += cartItem.getQuantity();
                }
            }
        return totalQuantity;
    }
    /*
    kiem tra san pham co ton tai trong gio hang chua
    bang cach tim theo id
     */
    public CartItem findCartItemById(int productId){
        for (CartItem cartItem : cartItems) {
            if(cartItem.getProduct().getProductId()==productId){
                return cartItem;
            }
        }
        return null;
    }
    /*
    xu ly them vao gio hang
     */
    public void addToCart(CartItem cartItem){
        // kiem tra san pham da ton tai chua
        for (CartItem item : cartItems) {
            // neu ton tai, tang so luong len 1
            if(cartItem.getProduct().getProductId()==cartItem.getProduct().getProductId()){
                cartItem.setQuantity(cartItem.getQuantity() + cartItem.getQuantity());
                return;
            }
        }
    }
    /*
    cap nhat so luong san pham
    tren trang cart
     */
    public void updateQuantity(int productId, int quantity){
        for (CartItem cartItem : cartItems) {
            if(cartItem.getProduct().getProductId()==productId){
                cartItem.setQuantity(quantity);
                return;
            }
        }
    }
    /*
    Xoa item trong gio hang
     */
    public void remoteItem(int productId){
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();
            if (cartItem.getProduct().getProductId()==productId) {
                iterator.remove();
                return; // Đã xóa sản phẩm, không cần kiểm tra các phần tử khác
            }
        }
    }
    /*
    khi dat hang thanh cong
    xoa san pham trong gio hang
     */
    public void clearCart() {
        cartItems.clear();
    }
}
