package kodlama.io.rentAcar.bussiness.concretes;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import kodlama.io.rentAcar.bussiness.abstracts.BrandService;
import kodlama.io.rentAcar.entites.concrete.Brand;
import kodlama.io.rentAcar.dataAccess.abstracts.BrandRepository;

@Service // bu sınıf bir bussines nesnesidir
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	
	
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<Brand> getAll() {

		//iş kuralları
		return  brandRepository.findAll();
	}

}
