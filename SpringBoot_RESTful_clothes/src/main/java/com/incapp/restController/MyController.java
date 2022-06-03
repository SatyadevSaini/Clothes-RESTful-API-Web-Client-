package com.incapp.restController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.incapp.bean.Clothes;
import com.incapp.service.MyService;

@RestController
public class MyController {
	 
	 @Autowired
	 MyService myService;
	  
	  @GetMapping(value="/getcloths")
	  public List<Clothes> getAllCothes(){
		 List<Clothes> c = myService.getAllClothes();
		 return c;
	  }
	  
	  @GetMapping("/getid")
	  public List<Integer> getAllID(){
		 List<Integer> c = myService.getClothesId();
		 return c;
	  }
	  
	  @DeleteMapping("/delete/{id}")
	  public String deleteClothes(@PathVariable ("id") int id) {
		  
		  String result = myService.deleteClothes(id);
		  return result;  
	  }
	  
	  @PutMapping("/update/{id}")
      public String updateClothes(@PathVariable ("id") int id , @RequestBody Clothes c) {
		  String result = myService.updateClothes( c,id);
		  return result;  
	  }
	  
	  @GetMapping(value="/getclothsbyname/{name}")
	  public List<Clothes> getclotheslike(@PathVariable ("name") String name){
		 List<Clothes> c = myService.getAllClothesByName(name);
		 return c;
	  }
	  
	  @PostMapping("/addCloth")
	  public ResponseEntity<String> addcloth(@RequestPart("Clothes") Clothes c , @RequestPart("image") MultipartFile image) {
		 String s = myService.addClothes(c, image);
		   if(s=="t") {
		   return new ResponseEntity<>(s,HttpStatus.OK); }
		   else {
			   return new ResponseEntity<>(s,HttpStatus.NOT_MODIFIED); }
	  }
	  
	  //getImage
	  @GetMapping("/getImage/{id}")
	  public byte [] getImage(@PathVariable  int id , HttpServletResponse httpServletResponse) {
		  byte [] img = myService.getImage(id);
		  return img;	  
	  }
	  
	  //update image ....
	  @PutMapping("/updateImages")
	  public String updateImage( @RequestPart("id") int id , @RequestPart("image") MultipartFile image) {
		  
		  String result = myService.updateImage(id, image);
		  return result;
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
