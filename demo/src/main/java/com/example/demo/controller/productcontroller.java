package com.example.demo.controller;
import java.util.*;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import java.util.logging.Logger;

import com.example.demo.model.Product;
@RestController
@RequestMapping("/product/api1.0")
public class productcontroller {
	 ArrayList<Product> productList=new ArrayList<>();
	 {
		 productList.add(new Product(100,"tre","  n",12,833000));
		 productList.add(new Product(101,"e"," dwnd",145,3000));
		 productList.add(new Product(102,"nu"," kyg",922,54800));
	 }
	 @GetMapping(value="/product/{id}")
	 public ResponseEntity<Product> getById(@PathVariable int id)
	 {
		 Optional<Product> optional =productList.stream().filter(product->product.getProductId()==id).findFirst();	 
		 return ResponseEntity.status(HttpStatus.OK).body(optional.get());
	
	 }
	@GetMapping(value="/productinfo",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> displayProducts()
	{
		return ResponseEntity.ok(productList);
	}
	@GetMapping(value="/product/brand/{brand}")
	public ResponseEntity<Product> getByBrand(@PathVariable String brand)
	{
		Optional<Product> optional =productList.stream().filter(product->brand.equals(product.getBrand())).findFirst();	 
		 return ResponseEntity.status(HttpStatus.OK).body(optional.get());
	}
	@GetMapping(value="/product/brandId/{id}")
	public ResponseEntity<Integer> getIdByBrand(@PathVariable int id)
	{
		Optional<Product> optional =productList.stream().filter(product-> product.getProductId() == id).findFirst();	 
		 return ResponseEntity.status(HttpStatus.OK).body(optional.get().getProductId());
	}
	@PostMapping(value="/addProduct",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		boolean flag=false;
		if(product!=null)
		{
			flag=productList.add(product);
		}
		return flag?ResponseEntity.status(201).body(product):
			ResponseEntity.status(404).body(null);
	}
	@PutMapping(value="/modify",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
	    Optional<Product> optional=productList.stream().filter(p->p.getProductId()==product.getProductId()).findFirst();
	    Product temp=optional.get();
	    temp.setBrand(product.getBrand());
	    temp.setDescription(product.getDescription());
	    temp.setQty(product.getQty());
	    temp.setPrice(product.getPrice());
	    return null;
	}
	@DeleteMapping(value="/delete/{id}")
	public void deleteproduct(@PathVariable("id") int id) {
	    Optional<Product> optional=productList.stream().filter(p->p.getProductId()==id).findFirst();
	    productList.remove(optional.get());
		
	}	
	@GetMapping("/status")
	public String status()
	{
		return  "up and running......... ";
	}
	@GetMapping("/time")
	public String time()
	{
		return new java.util.Date().getTime()+"";
	}
}
