package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:sample/customer/config/transactionByFile.xml")
public class TmcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmcmApplication.class, args);
	}
}
