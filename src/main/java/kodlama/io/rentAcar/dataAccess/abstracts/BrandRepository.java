package kodlama.io.rentAcar.dataAccess.abstracts;
import kodlama.io.rentAcar.entites.concrete.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //bu sınıf bir data access nesnesidir.
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);   //Spring Jpa keywords
}
