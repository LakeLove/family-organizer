package io.github.lakelove.familyorganizer.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.github.lakelove.familyorganizer.WireMockInitializer;
import io.github.lakelove.familyorganizer.entities.BasicInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(initializers = {WireMockInitializer.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FamilyOrganizerControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WireMockServer wireMockServer;

	private final String memberUrl = "/api/member";

	private BasicInfo basicInfo;

	private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	void setUp() {
		basicInfo = BasicInfo.builder().id(1L).firstName("Beyoncé").middleName("Giselle").lastName("Knowles").build();
	}

	@AfterEach
	void afterEach() {
		this.wireMockServer.resetAll();
	}

	@Test
	public void saveFamilyMember() throws Exception {
		String request = objectMapper.writeValueAsString(basicInfo);
		String requestUrl = memberUrl + "/save";
		stubFor(post(WireMock.urlEqualTo(requestUrl))
				.willReturn(aResponse()
						.withStatus(HttpStatus.CREATED.value())
						.withHeader("content-type", "application/json")
						.withBody(request)
						.withStatusMessage("")));
		RequestBuilder builder = MockMvcRequestBuilders.post(requestUrl)
				.accept(MediaType.APPLICATION_JSON)
				.content(request)
				.contentType(MediaType.APPLICATION_JSON);
		 mockMvc.perform(builder).andExpect(status().isCreated());
	}

}