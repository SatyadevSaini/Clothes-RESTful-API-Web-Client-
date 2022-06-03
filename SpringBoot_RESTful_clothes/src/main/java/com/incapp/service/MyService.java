package com.incapp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.incapp.bean.Clothes;


public interface MyService {

	public String addClothes(Clothes c , MultipartFile image) ;
	public	List<Clothes>  getAllClothes();
	public List<Integer> getClothesId();
	public	List<Clothes>  getAllClothesByName(String name);
	public String deleteClothes(int id );
	public String updateClothes(Clothes c ,int id );
	public  byte[] getImage(int id);
	public String updateImage(int id  , MultipartFile image);
}
