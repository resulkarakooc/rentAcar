package kodlama.io.rentAcar.webApi.controllers;
import java.util.List;

import kodlama.io.rentAcar.bussiness.requests.CreateBrandRequest;
import kodlama.io.rentAcar.bussiness.responses.GetAllBrandsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.rentAcar.bussiness.abstracts.BrandService;


@RestController // annotion dip not derleyiciye bunun bir controller olduğunu belirtir
@RequestMapping("/api/brands") 
public class BrandsController {

	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		
		this.brandService = brandService;
	}
	
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateBrandRequest createBrandRequest){

		this.brandService.add(createBrandRequest);
	}
}
