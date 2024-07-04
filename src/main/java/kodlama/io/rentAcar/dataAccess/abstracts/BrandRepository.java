package kodlama.io.rentAcar.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import kodlama.io.rentAcar.entites.concrete.Brand;

@Repository//bu sınıf bir data access nesnesidir.
public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
