package de.etherapists.role;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mj2075
 */
@Repository
public class RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> findAll() {
        return (List<Role>) entityManager.createNativeQuery("select * from roles", Role.class).getResultList();
    }

    @Transactional
    public void save(Role role) {
        entityManager.persist(role);
    }

}
