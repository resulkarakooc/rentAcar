package kodlama.io.rentAcar.core.utilities.mappers;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ModelMapperManager implements  ModelMapperService{

    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {  // cevaplar için
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {  //istekler için
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
