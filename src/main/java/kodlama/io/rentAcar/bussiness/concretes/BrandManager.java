package kodlama.io.rentAcar.bussiness.concretes;
import kodlama.io.rentAcar.bussiness.DTO.requests.CreateBrandRequest;
import kodlama.io.rentAcar.bussiness.DTO.requests.UpdateBrandRequset;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetAllBrandsResponse;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetByIdResponse;
import kodlama.io.rentAcar.bussiness.rules.BrandBussinessRules;
import kodlama.io.rentAcar.core.utilities.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;

import kodlama.io.rentAcar.bussiness.abstracts.BrandService;
import kodlama.io.rentAcar.entites.concrete.Brand;
import kodlama.io.rentAcar.dataAccess.abstracts.BrandRepository;

@Service // bu sınıf bir bussines nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBussinessRules brandBussinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();

		List<GetAllBrandsResponse> brandsResponse =
				brands.stream().map(brand -> this.modelMapperService.forResponse()
						.map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());

		//iş kuralları
		return  brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) { //gelen nesneyi alma

		this.brandBussinessRules.checkIfBrandNameExists(createBrandRequest.getName());

		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class); //mapleme
		                                    //forRequest  ile aynı olan nesneleri eşlemeye yarar.
		this.brandRepository.save(brand);
	}

	@Override
	public void update(UpdateBrandRequset updateBrandRequset) {

		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequset,Brand.class);
		this.brandRepository.save(brand);

	}

	@Override
	public void delete(int id) {

		Brand brand = this.brandRepository.findById(id).orElseThrow();
		this.brandRepository.delete(brand);

		//deletbyId de kullanılabilir.
	}

	@Override
	public GetByIdResponse getbyID(int id) {
		Brand brand  = this.brandRepository.findById(id).orElseThrow();

		GetByIdResponse response = this.modelMapperService.forResponse().map(brand,GetByIdResponse.class);

		return response;
	}

}
