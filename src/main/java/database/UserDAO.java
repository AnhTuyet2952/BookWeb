package database;

import model.User;

import java.util.ArrayList;

public class UserDAO implements DAOInterface<User>{

    @Override
    public ArrayList<User> selectAll() {
        return null;
    }

    @Override
    public User selectById(int id) {
        return null;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int insertAll(ArrayList<User> list) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<User> list) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }
}
