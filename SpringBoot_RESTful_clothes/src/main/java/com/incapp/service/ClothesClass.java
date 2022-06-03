package com.incapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.incapp.bean.Clothes;
import com.incapp.repo.ClothesRepo;

@Service
public class ClothesClass  implements MyService{
	
	      @Autowired
	      ClothesRepo clothesRepo;

	@Override
	public String addClothes(Clothes c , MultipartFile image) {
		
		return clothesRepo.addClothes(c , image);
	}
	
	@Override
	public List<Clothes> getAllClothes() {
		
		return clothesRepo.getAllClothes();
	}

	@Override
	public List<Integer> getClothesId() {
	
		return clothesRepo.getClothesId();
	}

	@Override
	public List<Clothes> getAllClothesByName(String name) {
		
		return clothesRepo.getAllClothesByName(name);
	}

	@Override
	public String deleteClothes(int id) {
		
		return clothesRepo.deleteClothes(id);
	}

	@Override
	public String updateClothes(Clothes c, int id) {
		
		return clothesRepo.updateClothes(c, id);
	}

	@Override
	public byte[] getImage(int id) {
		// TODO Auto-generated method stub
		return clothesRepo.getImage(id);
	}
  @Override
	public String updateImage(int id, MultipartFile image) {
		
		return clothesRepo.updateImage(id, image);
	}

}
