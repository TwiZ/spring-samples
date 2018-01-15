package pl.baranski.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pl.baranski.samples")
public class SpringPropertiesSampleApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringPropertiesSampleApplication.class, args);
    }
}
