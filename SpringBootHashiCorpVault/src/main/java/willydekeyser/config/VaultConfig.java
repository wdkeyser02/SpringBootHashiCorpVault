package willydekeyser.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.support.VaultResponse;

@Configuration
public class VaultConfig {

	private final VaultTemplate vaultTemplate;

	public VaultConfig(VaultTemplate vaultTemplate) {
		this.vaultTemplate = vaultTemplate;
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
