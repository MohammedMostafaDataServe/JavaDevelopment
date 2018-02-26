package com.mondia.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mondia.app.controller.ProductController;
import com.mondia.app.service.IProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private ProductController productController;
	
	@Mock
	private IProductService productService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testGetProducts() throws Exception {

		mockMvc.perform(get("/user/products")).andExpect(status().isOk());

	}

	@Test
	public void testGetProductById() throws Exception {

		mockMvc.perform(get("/user/product/{id}",2)).andExpect(status().isOk());

	}
	
	@Test
	public void testDeleteProduct() throws Exception {
		mockMvc.perform(delete("/user/product/10").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

	}

	/*@Test
	public void testPostProduct() throws Exception {
		String productJson = "{\"name\": \"Tane\", \"description\":\"jjjj\"}";
		mockMvc.perform(post("/user/product").accept(MediaType.APPLICATION_JSON).content(productJson)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}*/

	/*@Test
	public void testPostProduct2() throws Exception {
		Product product = new Product("product1", "desc1", 4, 6);
		mockMvc.perform(post("/user/product").contentType(MediaType.APPLICATION_JSON).content(json(product)))
				.andExpect(status().isCreated());

	}*/
	/*@Test
	public void testUpdateProduct() throws Exception {

		String productJson = "{\"id\":1,\"name\": \"Tane\", \"description\":\"jjjj\"}";
		mockMvc.perform(put("/user/product").accept(MediaType.APPLICATION_JSON).content(productJson)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		AbstractHttpMessageConverter<Object> mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}*/
}
