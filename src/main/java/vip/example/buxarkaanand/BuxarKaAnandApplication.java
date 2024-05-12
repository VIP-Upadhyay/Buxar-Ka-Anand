package vip.example.buxarkaanand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import vip.example.buxarkaanand.files.FileProperty;


@SpringBootApplication
@EnableConfigurationProperties({
	FileProperty.class
})
public class BuxarKaAnandApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuxarKaAnandApplication.class, args);
	}

}
