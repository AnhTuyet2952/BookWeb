package database;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO implements DAOInterface<Product> {
    @Override
    public ArrayList<Product> selectAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products ORDER BY CAST(product_id AS SIGNED)";

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String nameen = rs.getString("product_name_en");
                String descriptionen = rs.getString("description_en");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                String origin = rs.getString("origin");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct, nameProduct,description,nameen,descriptionen,image,price,author,publicationYear,publisher,origin,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product selectById(int id) {
        Product result = null;

        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM products WHERE product_id =?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String nameen = rs.getString("product_name_en");
                String descriptionen = rs.getString("description_en");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                String origin = rs.getString("origin");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                result = new Product(idProduct, nameProduct,description,nameen,descriptionen,image,price,author,publicationYear,publisher,origin,category);

            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int insert(Product product) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO products(product_id, product_name, description,product_name_en, description_en, image, price, author,publication_year,publisher,origin,category_id)"
                    + "VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement rs = con.prepareStatement(sql);

            rs.setInt(1, product.getProductId());
            rs.setString(2, product.getProduct_name());
            rs.setString(3, product.getDescription());
            rs.setString(4, product.getProduct_name_en());
            rs.setString(5, product.getDescription_en());
            rs.setString(6, product.getImage());
            rs.setDouble(7, product.getPrice());
            rs.setString(8, product.getAuthor());
            rs.setInt(9, product.getPublicationYear());
            rs.setString(10, product.getPublisher());
            rs.setString(11, product.getOrigin());
            rs.setInt(12, product.getCategory().getCategoryId());

            result = rs.executeUpdate();

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int insertAll(ArrayList<Product> list) {
        int result = 0;
        for (Product product : list) {

            ;
            if (this.insert(product) == 1)
                result += 1;
        }
        return result;
    }

    @Override
    public int delete(Product product) {
        int result = 0;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE from products " + "WHERE product_id=?";

            PreparedStatement rs = con.prepareStatement(sql);
            rs.setInt(1, product.getProductId());

            result = rs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int deleteAll(ArrayList<Product> list) {
        int result = 0;

        for (Product product : list) {
            result += delete(product);
        }
        return result;
    }

    @Override
    public int update(Product product) {
        int result = 0;
        Product oldProduct = this.selectById(product.getProductId());

        if (oldProduct != null) {

            try {
                Connection con = JDBCUtil.getConnection();

                String sql = "UPDATE pizza.products SET  product_name=? " +
                        ", description=? " +
                        ", product_name_en=? " +
                        ", description_en=? " +
                        ", image=? " +
                        ", price=? " +
                        ", author=?"+
                        ", publication_year=? " +
                        ", publisher=? " +
                        ", origin=? " +
                        ", category_id=? " +
                        "WHERE product_id = ?";

                PreparedStatement rs = con.prepareStatement(sql);

                rs.setInt(1, product.getProductId());
                rs.setString(2, product.getProduct_name());
                rs.setString(3, product.getDescription());
                rs.setString(4, product.getProduct_name_en());
                rs.setString(5, product.getDescription_en());
                rs.setString(6, product.getImage());
                rs.setDouble(7, product.getPrice());
                rs.setString(8, product.getAuthor());
                rs.setInt(9, product.getPublicationYear());
                rs.setString(10, product.getPublisher());
                rs.setString(11, product.getOrigin());
                rs.setInt(12, product.getCategory().getCategoryId());


                result = rs.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}
