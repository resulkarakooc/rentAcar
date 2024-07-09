package kodlama.io.rentAcar;
import kodlama.io.rentAcar.core.utilities.Exceptions.BussinessException;
import kodlama.io.rentAcar.core.utilities.Exceptions.ProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class RentAcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentAcarApplication.class, args);
	}

	/*@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBussinessExceptions(BussinessException bussinessException){
		ProblemDetails problemDetails = new  ProblemDetails();

		problemDetails.setMessage(bussinessException.getMessage()+ "selam");

		return  problemDetails;
	}*/

/*	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage("Validasyon hatası");
		return  problemDetails;
	}*/


	@Bean
	public ModelMapper getmodelMapper(){
		return new ModelMapper();
	}

}


