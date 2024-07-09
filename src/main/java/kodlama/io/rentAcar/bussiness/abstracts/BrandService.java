package kodlama.io.rentAcar.bussiness.abstracts;
import java.util.List;
import kodlama.io.rentAcar.entites.concrete.Model;
import kodlama.io.rentAcar.bussiness.DTO.requests.CreateBrandRequest;
import kodlama.io.rentAcar.bussiness.DTO.requests.UpdateBrandRequset;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetAllBrandsResponse;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetByIdResponse;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();
	GetByIdResponse getbyID(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequset updateBrandRequset);
	void delete(int id);


}
