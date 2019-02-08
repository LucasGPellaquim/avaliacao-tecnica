package app.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	private static final String [] arquivosEstaticos = { "classpath:/static/", "classpath:/META-INF/resources/static" };

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addRedirectViewController("/", "/index.html");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/**").addResourceLocations(arquivosEstaticos);
	}



	
}
