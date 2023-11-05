package ir.peyman.service;


import ir.peyman.entity.CustomerEntity;

public interface CustomerService {

	public CustomerEntity retrieve(Long id);

    public void delete(Long id);
	
	public void save(CustomerEntity customer);
}
