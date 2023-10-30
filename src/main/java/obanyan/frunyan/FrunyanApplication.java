package obanyan.frunyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class FrunyanApplication {

  public static void main(String[] args) {
    SpringApplication.run(FrunyanApplication.class, args);
  }

}
