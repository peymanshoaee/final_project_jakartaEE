package ir.peyman.service;


import ir.peyman.entity.CustomerEntity;
import ir.peyman.persistence.CustomerDao;

public class CustomerServiceImpl implements CustomerService {


	private CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	public CustomerEntity retrieve(Long id) {
		return entityToCustomer(customerDao.retrieve(id));
	}

    public void delete(Long id) {
        customerDao.delete(id);
    }

	public void save(CustomerEntity customer) {
		customerDao.save(customerToEntity(customer));
	}


	private CustomerEntity entityToCustomer(CustomerEntity entity) {
		CustomerEntity customer = new CustomerEntity();

		if (entity != null) {
			customer.setId(entity.getId());
			customer.setFirstName(entity.getFirstName());
			customer.setLastName(entity.getLastName());
		}

		return customer;
	}

	private CustomerEntity customerToEntity(CustomerEntity customer) {
		CustomerEntity entity = new CustomerEntity();

		if (customer != null) {
			entity.setId(customer.getId());
			entity.setFirstName(customer.getFirstName());
			entity.setLastName(customer.getLastName());
		}

		return entity;
	}
}
