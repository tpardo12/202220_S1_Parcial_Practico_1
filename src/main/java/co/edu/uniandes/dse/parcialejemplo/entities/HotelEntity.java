package co.edu.uniandes.dse.parcialejemplo.entities;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity
public class HotelEntity extends BaseEntity {


    private String nombre;
    private String direccion;
    private Integer numeroEstrellas;
	
    @PodamExclude
	@OneToMany(mappedBy="hotel", fetch = FetchType.LAZY)
	private List<HabitacionEnity> habitaciones = new ArrayList<HabitacionEnity>(); 
    
}