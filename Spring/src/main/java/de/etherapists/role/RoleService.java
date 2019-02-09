package de.etherapists.role;

import de.etherapists.utils.ServiceResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mj2075
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public ServiceResult<Role> findAll() {
        List<Role> roles = roleDao.findAll();
        final ServiceResult<Role> result = new ServiceResult<>();
        result.setContents(roles);
        result.setSize(roles.size());
        return result;
    }
}
