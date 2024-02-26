package database;

import model.Category;

import java.util.ArrayList;

public class CategoryDAO implements DAOInterface<Category>{
    @Override
    public ArrayList<Category> selectAll() {
        return null;
    }

    @Override
    public Category selectById(int id) {
        return null;
    }

    @Override
    public int insert(Category category) {
        return 0;
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
