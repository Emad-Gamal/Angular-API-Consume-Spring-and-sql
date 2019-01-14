package de.etherapists;

import de.etherapists.role.Role;
import de.etherapists.role.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author mj2075
 */
@SpringBootApplication
@ComponentScan(basePackages = "de.etherapists")
public class Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
