package in.ineuron.cfg;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Contact;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:9999/restMiniProject/swagger-ui.html -- url to get swapper document
@Configuration
@EnableSwagger2
public class SwaggerDocsConfiguration {

	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).// UI Screen type
				select()// to specify RestControllers
				.apis(RequestHandlerSelectors.basePackage("in.ineuron.restcontroller"))// base packages for RestController
				.paths(PathSelectors.regex("/api/tourist.*"))// To specify the request paths
				.build()// build the docket object
				.useDefaultResponseMessages(true)
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("kishore", "http://www.ineuron.ai/course", "gnmkishore124@gmail.com");
		
		return new ApiInfo("TouristInfo","Gives information about tourist activities", "1.1.RELEASE", "http:", contact,
				"GNU PUBLIC", "http://apache.org/license/guru", Collections.emptyList());
	}
}
