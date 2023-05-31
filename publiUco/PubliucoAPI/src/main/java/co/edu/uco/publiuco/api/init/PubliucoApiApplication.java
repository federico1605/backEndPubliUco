package co.edu.uco.publiuco.api.init;

import com.azure.security.keyvault.secrets.SecretClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.publiuco"})
@EnableJpaRepositories(basePackages = {"co.edu.uco.publiuco" })
@EntityScan(basePackages = {"co.edu.uco.publiuco" })
public class PubliucoApiApplication {

    @Autowired
    private SecretClient secretClient;


    public static void main(String[] args) {
        SpringApplication.run(PubliucoApiApplication.class, args);
    }

}
