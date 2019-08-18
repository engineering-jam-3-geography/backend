package edumaps.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class EdumapApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new EdumapApplication()
                .configure(new SpringApplicationBuilder(EdumapApplication.class))
                .run(args);
    }
}
