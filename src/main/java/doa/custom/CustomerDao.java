package doa.custom;

import doa.CrudDao;
import dto.CustomerDto;
import entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao  extends CrudDao<Customer> {
//   boolean isSavedCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
//   boolean isUpdatedCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
//   boolean isDeleteCustomer(String id) throws SQLException, ClassNotFoundException;
//   List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException;
  CustomerDto searchCustomer(String id);
}
