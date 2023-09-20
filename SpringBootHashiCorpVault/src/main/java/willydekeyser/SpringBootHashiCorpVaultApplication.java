package willydekeyser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootHashiCorpVaultApplication {

	@Value("${username}")
    String userName;

    @Value("${password}")
    String password;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHashiCorpVaultApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("CommandLineRunner");
			System.err.println(userName);	
			System.err.println(password);	
			
			
		};
	}
}


