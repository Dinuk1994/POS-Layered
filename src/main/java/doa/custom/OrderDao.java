package doa.custom;

import dto.OrderDto;

import java.sql.SQLException;

public interface OrderDao {
    boolean isSaved(OrderDto dto) throws SQLException, ClassNotFoundException;
    OrderDto lastOrder() throws SQLException, ClassNotFoundException;

}
