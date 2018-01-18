package br.com.configuration.web;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ApplicationConfig extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return configureApplication(builder);
	}

	/**
	 * Classe de inicialização padrão
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		configureApplication(new SpringApplicationBuilder()).run(args);
	}

	/**
	 * Configuração do modo da aplicação
	 * 
	 * @param builder
	 * @return
	 */
	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
		return builder.sources(ApplicationConfig.class).bannerMode(Banner.Mode.OFF);
	}
	
	
}
