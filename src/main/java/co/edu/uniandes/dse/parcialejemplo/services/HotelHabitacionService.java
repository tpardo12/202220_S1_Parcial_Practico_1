package co.edu.uniandes.dse.parcialejemplo.services;



import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEnity;
import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;


import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelHabitacionService {

    @Autowired
	private HabitacionRepository habRepository;

	@Autowired
	private HotelRepository hotRepository;

    @Transactional
	public HotelEntity addhabitacionhotel(Long hotelid, Long habid) throws EntityNotFoundException, IllegalOperationException {
		
		Optional <HotelEntity> hotelentity = hotRepository.findById(hotelid);
        Optional <HabitacionEnity> habitacionentity = habRepository.findById(habid);

		if (hotelentity.isEmpty())
			throw new IllegalOperationException("Hotel no encontrado");
        if (habitacionentity.isEmpty())
			throw new IllegalOperationException("Habitacion no encontrada");
        
        hotelentity.get().getHabitaciones().add(habitacionentity.get());
        hotelentity.get().setHabitaciones(hotelentity.get().getHabitaciones());
		return hotelentity.get();
		
	}
} 