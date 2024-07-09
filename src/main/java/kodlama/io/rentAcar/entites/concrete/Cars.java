package kodlama.io.rentAcar.entites.concrete;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cars {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(name="plate" , unique = true)
    private String plate;

    @Column(name="dailyPrice")
    private double dailyPrice;

    @Column(name="modelYear") 
    private String modelYear;

    @Column(name="state")
    private int state; //1-Available 2-Rented 3-Maintenance

    @ManyToOne
    @JoinColumn(name = "model_Id")
    private Model model;

}

