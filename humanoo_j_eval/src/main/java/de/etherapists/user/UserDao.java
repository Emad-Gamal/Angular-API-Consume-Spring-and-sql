package de.etherapists.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author mj2075
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
}
