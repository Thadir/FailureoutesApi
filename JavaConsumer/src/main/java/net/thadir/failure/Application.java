package net.thadir.failure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(Application.class);
    Map<String, Object> map = new HashMap<>();
    map.put("SERVER_PORT", "8585");
    application.setDefaultProperties(map);
    application.run(args);
  }
}