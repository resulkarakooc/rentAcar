package kodlama.io.rentAcar.bussiness.rules;
import kodlama.io.rentAcar.core.utilities.Exceptions.BussinessException;
import kodlama.io.rentAcar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBussinessRules {

    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
             throw new BussinessException("Brand already exists");
        }
    }
}
