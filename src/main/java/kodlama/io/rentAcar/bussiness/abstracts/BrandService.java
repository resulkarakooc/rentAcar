package kodlama.io.rentAcar.bussiness.abstracts;
import java.util.List;

import kodlama.io.rentAcar.bussiness.requests.CreateBrandRequest;
import kodlama.io.rentAcar.bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentAcar.entites.concrete.Brand;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
}
