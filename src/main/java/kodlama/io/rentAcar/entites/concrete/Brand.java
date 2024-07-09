package kodlama.io.rentAcar.entites.concrete;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	@Column(name="name")
	private String name;

	@OneToMany(mappedBy = "brand")
	private List<Model> models;
}
