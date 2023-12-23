package doa.custom.impl;

import doa.custom.CustomerDao;
import db.DBConnection;
import dto.CustomerDto;
import entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public CustomerDto searchCustomer(String id) {
        return null;
    }

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Customer Values(?,?,?,?)";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,entity.getId());
        pstm.setString(2, entity.getName());
        pstm.setString(3,entity.getAddress());
        pstm.setDouble(4,entity.getSalary());
        int result = pstm.executeUpdate();

        return result>0 ;
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        String sql="UPDATE Customer SET name=?,address=?,salary=? WHERE id=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,entity.getName());
        pstm.setString(2,entity.getAddress());
        pstm.setDouble(3,entity.getSalary());
        pstm.setString(4,entity.getId());
        int result = pstm.executeUpdate();
        return result>0;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM customer WHERE id=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,id);
        int result = pstm.executeUpdate();
        return result>0;
    }

    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        List<Customer> list = new ArrayList<>();
        String sql="SELECT * FROM Customer";

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            Customer c =new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );
            list.add(c);
        }

        return list;
    }
}
