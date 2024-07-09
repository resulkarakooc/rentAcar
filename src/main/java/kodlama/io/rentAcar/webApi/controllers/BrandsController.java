package kodlama.io.rentAcar.webApi.controllers;
import java.util.List;

import jakarta.validation.Valid;
import kodlama.io.rentAcar.bussiness.DTO.requests.CreateBrandRequest;
import kodlama.io.rentAcar.bussiness.DTO.requests.UpdateBrandRequset;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetAllBrandsResponse;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import kodlama.io.rentAcar.bussiness.abstracts.BrandService;


@RestController // annotion dip not derleyiciye bunun bir controller olduğunu belirtir
@RequestMapping("/api/brands") 
public class BrandsController {

	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		
		this.brandService = brandService;
	}
	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdResponse getById(@PathVariable int id){
		return  brandService.getbyID(id);
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateBrandRequest createBrandRequest){

		this.brandService.add(createBrandRequest);
	}

	@PutMapping
	public void  update(UpdateBrandRequset updateBrandRequset){

		this.brandService.update(updateBrandRequset);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id){
		this.brandService.delete(id);
	}



}

