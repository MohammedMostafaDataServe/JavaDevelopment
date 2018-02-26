package com.mondia.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mondia.app.controller.OperatorController;
import com.mondia.app.entity.Operator;
import com.mondia.app.service.IOperatorService;

@RunWith(SpringJUnit4ClassRunner.class)
public class OperatorControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private OperatorController operatorController;
	
	@Mock
	IOperatorService operatorService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(operatorController).build();
	}

	@Test
	public void testGetOperators() throws Exception {

		mockMvc.perform(get("/user/operators")).andExpect(status().isOk());

	}
	@Test
	public void testGetOpeartorById() throws Exception {
		mockMvc.perform(get("/user/operator/{id}",2)).andExpect(status().isOk());

	}
	@Test
	public void testDeleteOperator() throws Exception {

		mockMvc.perform(delete("/user/operator/10").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

	}
	
	/*@Test
	public void testPostOpeartor() throws Exception {
		String operatorJson = "{\"name\": \"orange\", \"country\":\"egypt\",\"operatorServiceFlag\":1,\"operatorPackageFlag\":1}";
		mockMvc.perform(post("/user/operator").accept(MediaType.APPLICATION_JSON).content(operatorJson)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}
	
	/*@Test
	public void testPostOpeartor2() throws Exception {
		Operator operator = new Operator("orange", "egypt", 1, 1);
		mockMvc.perform(post("/user/operator").contentType(MediaType.APPLICATION_JSON).content(json(operator)))
				.andExpect(status().isCreated());

	}
	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		AbstractHttpMessageConverter<Object> mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}*/

	/*@Test
	public void testUpdateOperator() throws Exception {
		String operatorJson = "{\"name\": \"orange\", \"country\":\"egypt\",\"operatorServiceFlag\":1,\"operatorPackageFlag\":1}";
		mockMvc.perform(put("/user/product").accept(MediaType.APPLICATION_JSON).content(operatorJson)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		AbstractHttpMessageConverter<Object> mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}*/
}
