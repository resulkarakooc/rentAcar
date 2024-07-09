package kodlama.io.rentAcar.dataAccess.abstracts;

import kodlama.io.rentAcar.entites.concrete.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
