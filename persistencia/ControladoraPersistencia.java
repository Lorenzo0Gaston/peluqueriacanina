package lorenzo.peluqueriacanina.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lorenzo.peluqueriacanina.logica.Duenio;
import lorenzo.peluqueriacanina.logica.Mascota;
import lorenzo.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

   DuenioJpaController duenioJpa = new DuenioJpaController();
   MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masc) {
    
        duenioJpa.create(duenio);
        
        mascotaJpa.create(masc);
        
    }

    public List<Mascota> traerMascota() {
        
        return mascotaJpa.findMascotaEntities();
    
    }

    public void borrarMascota(int num_cliente) {
       try {
           mascotaJpa.destroy(num_cliente);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }

    public Mascota traerMascota(int num_cliente) {
    
        return mascotaJpa.findMascota(num_cliente);
    
    }

    public void modificarMascota(Mascota mascotaG) {
       try {
           mascotaJpa.edit(mascotaG);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    
    
    }

    public void modificarDuenio(Duenio dueno) {
       try {
           duenioJpa.edit(dueno);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
