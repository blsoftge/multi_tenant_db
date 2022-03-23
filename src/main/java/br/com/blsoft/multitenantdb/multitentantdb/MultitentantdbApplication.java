package br.com.blsoft.multitenantdb.multitentantdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultitentantdbApplication {
	/**importante!
	 * Não se esqueça de configurar os pacotes a serem escaneados na classe HibernateConfig
	 */
	public static void main(String[] args) {
		SpringApplication.run(MultitentantdbApplication.class, args);
	}

}
