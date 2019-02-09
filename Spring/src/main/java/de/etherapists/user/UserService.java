package de.etherapists.user;

import de.etherapists.utils.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mj2075
 */
@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    public List<User> getAllUsers(){
        return userDao.findAll();
    }
    
    public User getUserById(int userId) throws ResourceNotFoundException{
        Optional<User> user = userDao.findById(userId);
        if(!user.isPresent())
            throw new ResourceNotFoundException("User not found for this id :: " + userId);
        
        return user.get();
    }
    
    public void deleteUserByID(int userId){
         userDao.deleteById(userId);
    }
    
    public User addUser(User user){
        user = userDao.save(user);
        return user;
    }
    
    public boolean updateUser(User user, int userId){   
	Optional<User> userOptionl = userDao.findById(userId);
	if (!userOptionl.isPresent())
		return false;
        
	user.setId(userId);
	userDao.save(user);
	return true;
    }
    
}