package doa.custom.impl;

import doa.custom.ItemDao;
import db.DBConnection;
import doa.util.CrudUtil;
import dto.ItemDto;
import entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {


    @Override
    public ItemDto searchItem(String code) {
        return null;
    }

    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Item VALUES(?,?,?,?)";
        return CrudUtil.execute(sql,entity.getCode(),entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand());
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        String sql="UPDATE Item SET Description=?,unitPrice=?,qtyOnHand=? WHERE code=?";
        return CrudUtil.execute(sql,entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand(),entity.getCode());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM Item WHERE Code=?";
        return CrudUtil.execute(sql,id);
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        List<Item> itemList = new ArrayList<>();
        String sql="SELECT * FROM Item";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
           itemList.add(new Item(
                   resultSet.getString(1),
                   resultSet.getString(2),
                   resultSet.getDouble(4),
                   resultSet.getInt(3)

            ));
        }
        return itemList;
    }
}
