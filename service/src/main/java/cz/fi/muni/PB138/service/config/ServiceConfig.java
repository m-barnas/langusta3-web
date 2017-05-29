package cz.fi.muni.PB138.service.config;

import cz.fi.muni.PB138.utils.PersistenceApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */
@Configuration
@Import(PersistenceApplicationContext.class)
@ComponentScan("cz.fi.muni.PB138.service")
public class ServiceConfig {
}
