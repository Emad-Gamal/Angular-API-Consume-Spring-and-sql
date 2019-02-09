package de.etherapists;

import de.etherapists.role.Role;
import de.etherapists.role.RoleDao;
import de.etherapists.user.User;
import de.etherapists.user.UserDao;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mj2075
 */
@Component
public class InitRoles {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleDao.class);

    @Autowired
    private RoleDao roleDao;

    @PostConstruct
    public void postConstruct() {
        LOGGER.debug("create roles");
        roleDao.save(Role.createRoleByName("admin"));
        roleDao.save(Role.createRoleByName("costumer"));
    }

}
