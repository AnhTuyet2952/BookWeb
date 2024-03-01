package controller.user;

import database.ProductDAO;
import model.Cart;
import model.CartItem;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCart", value = "/AddToCart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lay ma san pham tu request
        String productId = request.getParameter("productId");
        int product_id = Integer.parseInt(productId);
        // lay so luong moi cua san pham tu request
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));
        // lay gio hang tu session
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        // neu chua co thi tạo moi gio hang
        if(cart==null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        // cap nhat so luogn san pham
        if (newQuantity <= 0) {
            cart.remoteItem(product_id);
        } else {
            cart.updateQuantity(product_id, newQuantity);
        }

        request.getSession().setAttribute("cart", cart);
        HttpSession session = request.getSession();
        // tinh tong so luong san pham trong gio hang
        int totalQuantity = cart.calculateTotalQuantity();
        session.setAttribute("totalQuantity",totalQuantity);
        // kiem tra san pham da ton tai trong gio hang chua
        CartItem existingItem = cart.findCartItemById(product_id);
        if(existingItem != null){
            // neu san pham da ton tai
            // tang so luong san pham
            existingItem.setQuantity(Math.max(newQuantity,1));
        }else{
            // san pham chua ton tai
            // them sp do vao
            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.selectById(product_id);
            // them san pham do voi so luong la 1
            CartItem cartItem = new CartItem(product, newQuantity);
            cartItem.setPrice(product.getPrice());
            cartItem.setCart(cart);
            cart.addToCart(cartItem);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book/shop-grid.jsp");
        dispatcher.forward(request, response);
    }
}