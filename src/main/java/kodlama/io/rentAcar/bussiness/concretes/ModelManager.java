package kodlama.io.rentAcar.bussiness.concretes;
import kodlama.io.rentAcar.bussiness.DTO.requests.CreateModelRequest;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetAllModelResponse;
import kodlama.io.rentAcar.bussiness.abstracts.ModelService;
import kodlama.io.rentAcar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentAcar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentAcar.entites.concrete.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager  implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelResponse> getAll() {

        List<Model> models = modelRepository.findAll();

        List<GetAllModelResponse> modelsResponse =
                models.stream().map(model -> this.modelMapperService.forResponse()
                        .map(model,GetAllModelResponse.class)).collect(Collectors.toList());

        //iş kuralları
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class); //mapleme
        //forRequest  ile aynı olan nesneleri eşlemeye yarar.
        this.modelRepository.save(model);
    }
}
