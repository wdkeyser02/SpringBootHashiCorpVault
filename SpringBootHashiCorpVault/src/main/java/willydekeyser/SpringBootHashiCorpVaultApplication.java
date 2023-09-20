package willydekeyser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import willydekeyser.config.Secret;

@SpringBootApplication
public class SpringBootHashiCorpVaultApplication {

	private final Secret secret;

	public SpringBootHashiCorpVaultApplication(Secret secret) {
		this.secret = secret;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHashiCorpVaultApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("CommandLineRunner");
			System.err.println(secret.getUsername());	
			System.err.println(secret.getPassword());	
			
			
		};
	}
}


