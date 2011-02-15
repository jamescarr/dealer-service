package com.jamescarr.configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({
	"classpath:com/jamescarr/example/cache-context.xml", 
	"classpath:springmvc-resteasy.xml"})
	@ComponentScan("com.carfax.inventory")
public class AppConfig {
	
}
