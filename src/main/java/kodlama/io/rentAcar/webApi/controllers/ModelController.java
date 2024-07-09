package kodlama.io.rentAcar.webApi.controllers;
import java.util.List;

import kodlama.io.rentAcar.bussiness.DTO.requests.CreateBrandRequest;
import kodlama.io.rentAcar.bussiness.DTO.requests.CreateModelRequest;
import kodlama.io.rentAcar.bussiness.DTO.requests.UpdateBrandRequset;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetAllBrandsResponse;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetAllModelResponse;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetByIdResponse;
import kodlama.io.rentAcar.bussiness.abstracts.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import kodlama.io.rentAcar.bussiness.abstracts.BrandService;


@RestController // annotion dip not derleyiciye bunun bir controller olduğunu belirtir
@RequestMapping("/api/models")
public class ModelController {

    private ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {

        this.modelService = modelService;
    }

    @GetMapping()
    public List<GetAllModelResponse> getAll(){
        return  modelService.getAll();
    }

  /*  @GetMapping("/{id}")
    public GetByIdResponse getById(@PathVariable int id){
        return  modelService.getbyID(id);
    }*/

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateModelRequest createModelRequest){

        this.modelService.add(createModelRequest);
    }

    /*@PutMapping
    public void  update(UpdateBrandRequset updateBrandRequset){

        this.modelService.update(updateBrandRequset);
    }
*/
  /*  @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }*/


}

