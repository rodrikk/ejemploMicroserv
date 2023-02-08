package com.ejemplo.Eje;

import com.ejemplo.Eje.models.useless;
import com.ejemplo.Eje.repositories.uselessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
        /*
         * Class that preloads the database with some initial data to operate with.
         * */
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private uselessRepository repository;

    //Load a document into the MongoDB
    @Bean
    CommandLineRunner initDatabase() {
        if(repository.count()>0)
            return args -> {};
        else {
            return args -> {
                log.info("Preloading " + repository.save(new useless("mucho", "porque sí", false, 0.0f)));
            };
        }
    }
}
