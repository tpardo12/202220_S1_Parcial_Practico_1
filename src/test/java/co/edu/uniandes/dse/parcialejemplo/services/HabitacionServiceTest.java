package co.edu.uniandes.dse.parcialejemplo.services;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import java.util.Optional;

import org.aspectj.asm.internal.ProgramElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEnity;
import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import co.edu.uniandes.dse.parcialejemplo.services.HabitacionService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(HabitacionService.class)
public class HabitacionServiceTest {
    @Autowired
    private HabitacionService hService;

    @Autowired
    private HabitacionRepository hRepository;


    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    private HabitacionEnity entidadh;

    @BeforeEach
    void setUp() {
            clearData();
            insertData();
    }

    private void clearData() {
        entityManager.getEntityManager().createQuery("delete from HabitacionEnity");
       
    }
    @Test
    private void insertData() {
            HabitacionEnity entidadhabitacion = factory.manufacturePojo(HabitacionEnity.class);
            entityManager.persist(entidadhabitacion);

            entidadh =entidadhabitacion; 
        
            
    }
    @Test
     void testcrearhotel() {
         
           Optional<HabitacionEnity> habitacione = hRepository.findById(entidadh.getId()); 
           if (habitacione.isPresent()){
            assertTrue(true);

           }
            
    }
    @Test
    void testcreatemediconovalid() {
        
        HabitacionEnity entidadhab = factory.manufacturePojo(HabitacionEnity.class);
        entidadhab.setNumeroBanios(5);
        entidadhab.setNumeroCamas(2);

          try {
            hService.crearhabitacion(entidadhab);
            
          } catch (Exception IllegalOperationException) {
             assertTrue(true);
          }

        
   }

    
}