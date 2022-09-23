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
public class HabitacionEnity extends BaseEntity {
    private Integer numeroPersonas;
    private Integer numeroHabitacion;
    private Integer numeroCamas;
    private Integer numeroBanios;

    @PodamExclude
	@ManyToOne()
	private HotelEntity hotel;

   

}