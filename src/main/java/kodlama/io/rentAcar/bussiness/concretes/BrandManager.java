package kodlama.io.rentAcar.bussiness.concretes;
import kodlama.io.rentAcar.bussiness.requests.CreateBrandRequest;
import kodlama.io.rentAcar.bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentAcar.core.utilities.mappers.ModelMapperService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import kodlama.io.rentAcar.bussiness.abstracts.BrandService;
import kodlama.io.rentAcar.entites.concrete.Brand;
import kodlama.io.rentAcar.dataAccess.abstracts.BrandRepository;

@Service // bu sınıf bir bussines nesnesidir
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	
	
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<GetAllBrandsResponse> getAll() {

		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandResponse = new ArrayList<GetAllBrandsResponse>();


		for (Brand brand : brands){
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			brandResponse.add(responseItem);

		}

		List<GetAllBrandsResponse> brandsResponse =
				brands.stream().map(brand -> this.modelMapperService.forResponse()
						.map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
		//iş kuralları
		return  brandResponse;
	}



	@Override
	public void add(CreateBrandRequest createBrandRequest) {


		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);


		this.brandRepository.save(brand);
	}

}
