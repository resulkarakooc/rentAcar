package kodlama.io.rentAcar.dataAccess.abstracts;
import kodlama.io.rentAcar.bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentAcar.entites.concrete.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//bu sınıf bir data access nesnesidir.
public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
