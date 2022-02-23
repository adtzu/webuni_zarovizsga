package hu.webuni.spring.logistics.web;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import hu.webuni.spring.logistics.dto.LoginDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class TrasnportPlanIT {

	@Autowired
	WebTestClient webTestClient;
	
	
	private static final String LOGIN = "/api/login";
	private static final String BASE_URI = "/api/transportPlans";
	private String token = getJwtToken();

	
	@BeforeEach
	public void initDb() {
		
		
	
	}
	
	
	
	
	private String getJwtToken() {
		
		LoginDTO login = new LoginDTO("transportManager", "password");
		
		return webTestClient
				.post()
				.uri(LOGIN)
				.bodyValue(login)
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody(String.class)
				.returnResult()
				.getResponseBody();
				
	}

}
