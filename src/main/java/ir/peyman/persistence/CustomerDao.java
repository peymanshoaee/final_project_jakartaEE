package ir.peyman.persistence;


import ir.peyman.entity.CustomerEntity;

public interface CustomerDao {
	
	public CustomerEntity retrieve(Long id);

    public void delete(Long id);
	
	public void save(CustomerEntity customer);
}
