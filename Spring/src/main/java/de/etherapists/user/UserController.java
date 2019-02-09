package de.etherapists.user;

import de.etherapists.utils.ResourceNotFoundException;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author mj2075
 */
@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId) throws ResourceNotFoundException{
        return userService.getUserById(userId);
    }
    
    @DeleteMapping("/users/{userId}")
    public void deleteUserById(@PathVariable int userId){
        userService.deleteUserByID(userId);
    }
    
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Validated @RequestBody User user) {
        User savedUser = userService.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    
    @PutMapping("/users/{userId}")
    public ResponseEntity<Object> updateStudent(@Validated @RequestBody User user, @PathVariable int userId) {
        if(!userService.updateUser(user, userId))
            return ResponseEntity.notFound().build();
        
        else return ResponseEntity.noContent().build();
    }
    
}