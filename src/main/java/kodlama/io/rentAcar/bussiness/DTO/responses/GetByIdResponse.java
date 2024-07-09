package kodlama.io.rentAcar.bussiness.DTO.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdResponse {

    private int id;
    private String name;
}
