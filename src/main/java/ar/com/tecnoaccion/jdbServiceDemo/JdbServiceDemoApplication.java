package ar.com.tecnoaccion.jdbServiceDemo;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaInDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaOutDTO;
import ar.com.tecnoaccion.jdbServiceDemo.services.ValidarApuestasService;
import ar.com.tecnoaccion.jdbServiceDemo.services.impl.ValidarApuestasServiceImpl;
import ar.com.tecnoaccion.juego.library.config.HeaderRequestInterceptor;
import ar.com.tecnoaccion.juego.library.exception.MiddleResponseErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ComponentScan({"ar.com.tecnoaccion.juego.library", "ar.com.tecnoaccion.jdbServiceDemo"})
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class JdbServiceDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(JdbServiceDemoApplication.class, args);
	}


	@Bean
	@RequestScope
	public RestTemplate restTemplate(RestTemplateBuilder builder, HttpServletRequest inReq) {
		final String authHeader = inReq.getHeader(HttpHeaders.AUTHORIZATION);

		RestTemplate build = builder.build();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		build.setMessageConverters(Arrays.asList(converter, new FormHttpMessageConverter()));

		build.setErrorHandler(new MiddleResponseErrorHandler());

		if (authHeader != null && !authHeader.isEmpty()) {
			List<ClientHttpRequestInterceptor> interceptors = build.getInterceptors();
			if (CollectionUtils.isEmpty(interceptors)){
				interceptors = new ArrayList<>();
			}
			interceptors.add(new HeaderRequestInterceptor(HttpHeaders.AUTHORIZATION, authHeader));
			build.setInterceptors(interceptors);
		}
		return build;
	}


}
