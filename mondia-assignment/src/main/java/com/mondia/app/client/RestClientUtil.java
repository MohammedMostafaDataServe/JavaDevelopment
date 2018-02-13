package com.mondia.app.client;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mondia.app.entity.Product;
import com.mondia.app.entity.Service;

public class RestClientUtil {
	

	public void addProduct() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/product";
	    Product product=new Product();
	    product.setName("product4");
	    product.setDescription("desc4");
		HttpEntity<Product> requestEntity = new HttpEntity<Product>(product, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
	}
	public void deleteProduct() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/product/{id}";
		HttpEntity<Product> requestEntity = new HttpEntity<Product>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 16);
	}
	public void updateProduct() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/product";
	    Product product=new Product();
	    product.setId(19);
	    product.setName("product3");
	    product.setDescription("desc3");
		HttpEntity<Product> requestEntity = new HttpEntity<Product>(product, headers);
		restTemplate.put(url, requestEntity);
	}
	public void getProductById() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/product/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Product> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Product.class, 29);
		Product product = responseEntity.getBody();
		System.out.println("Id:" + product.getId() + ", Name:"  +product.getName()+ ", Description:"
				+ product.getDescription()+", serviceList:"+product.getServicesList());
	}

	public void getAllProducts() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/products";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Product[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Product[].class);
		Product[] products = responseEntity.getBody();
		for (Product product : products) {
			System.out.println("Id:" + product.getId() + ", Name:"  +product.getName()+ ", Description:"
					+ product.getDescription());
		}
	}
	public static void main(String args[]) {
		RestClientUtil util = new RestClientUtil();
		//util.getAllProducts();
         util.getProductById();
		// util.addProduct();
		//util.deleteProduct();
		//util.updateProduct();
	//	util.getServiceById();

	}
	public void getServiceById() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/service/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Service> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Service.class, 16);
		Service service = responseEntity.getBody();
		System.out.println("Id:" + service.getId() + ", Name:"  +service.getName()+ ", productId:"
				+ service.getProductId().getId()+", operatorId:"+service.getOperatorId().getId());
	}
}

