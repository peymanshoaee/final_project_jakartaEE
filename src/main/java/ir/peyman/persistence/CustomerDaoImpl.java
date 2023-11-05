package ir.peyman.persistence;


import ir.peyman.entity.CustomerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerDaoImpl implements CustomerDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist-unit");
	
	public CustomerEntity retrieve(Long id) {
		EntityManager em = emf.createEntityManager();

		CustomerEntity entity = null;

		try {
			entity = em.find(CustomerEntity.class, id);
		} finally {
			em.close();
		}
		
		return entity;
	}

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            CustomerEntity entity = em.find(CustomerEntity.class, id);

            if(entity == null) {
                System.out.println("error in service Delete Customer: Customer not found");
            }
            else {
                em.remove(entity);
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println("error in service Delete Customer: " + e.getMessage());

            transaction.rollback();
        } finally {
            em.close();
        }
    }

	public void save(CustomerEntity customer) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

            em.merge(customer);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("error in service Save Customer: " + e.getMessage());

			transaction.rollback();
		} finally {
			em.close();
		}
	}
}
