package kodlama.io.rentAcar.bussiness.abstracts;


import kodlama.io.rentAcar.bussiness.DTO.requests.CreateModelRequest;
import kodlama.io.rentAcar.bussiness.DTO.responses.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
