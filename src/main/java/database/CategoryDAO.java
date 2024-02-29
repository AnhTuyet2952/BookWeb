package database;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO implements DAOInterface<Category>{
    @Override
    public ArrayList<Category> selectAll() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM categories ";

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("category_name");

                Category category = new Category(id, name);
                categories.add(category);

            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Category selectById(int id) {
        Category result = null;

        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM book.categories WHERE category_id =?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("category_id");
                String username = rs.getString("category_name");

                result = new Category(id1, username);


            }
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int insert(Category category) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO categories(category_id, category_name)"
                    + "VALUE(?, ?)";
            PreparedStatement rs = con.prepareStatement(sql);
            rs.setInt(1, category.getCategoryId());
            rs.setString(2, category.getCategoryName());
            result = rs.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int insertAll(ArrayList<Category> list) {
        return 0;
    }

    @Override
    public int delete(Category category) {
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<Category> list) {
        return 0;
    }

    @Override
    public int update(Category category) {
        return 0;
    }
}
