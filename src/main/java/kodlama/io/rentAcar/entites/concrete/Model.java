package kodlama.io.rentAcar.entites.concrete;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "models")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_Id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Cars> cars;

}
