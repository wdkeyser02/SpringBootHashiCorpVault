package willydekeyser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

@SpringBootApplication
public class SpringBootHashiCorpVaultApplication {

	@Autowired
	private VaultTemplate vaultTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHashiCorpVaultApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			VaultResponse response = vaultTemplate
			        .opsForKeyValue("admin/secret", KeyValueBackend.KV_2).get("example");
			System.out.println(response.getData());
			System.out.println(response.getData().get("username"));
			System.out.println(response.getData().get("password"));
			
		};
	}
}
