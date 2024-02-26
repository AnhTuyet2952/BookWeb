package database;

import model.Order;

import java.util.ArrayList;

public class OrderDAO implements DAOInterface<Order>{
    @Override
    public ArrayList<Order> selectAll() {
        return null;
    }

    @Override
    public Order selectById(int id) {
        return null;
    }

    @Override
    public int insert(Order order) {
        return 0;
    }

    @Override
    public int insertAll(ArrayList<Order> list) {
        return 0;
    }

    @Override
    public int delete(Order order) {
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<Order> list) {
        return 0;
    }

    @Override
    public int update(Order order) {
        return 0;
    }
}
