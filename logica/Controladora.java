package lorenzo.peluqueriacanina.logica;

import java.util.List;
import javax.persistence.metamodel.SingularAttribute;
import lorenzo.peluqueriacanina.persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia ();
    

    public void guardar(String mascota, String raza, String color, String duenio,
            String observaciones, String alergias, String ateEspecial, String telDuenio) {
        
        Duenio elDuenio = new Duenio();
        elDuenio.setNombre(duenio);
        elDuenio.setTelefono(telDuenio);
        
        Mascota masc = new Mascota();
        masc.setNombre(mascota);
        masc.setRaza(raza);
        masc.setColor(color);
        masc.setUnDuenio(elDuenio);
        masc.setObservaciones(observaciones);
        masc.setAlergico(alergias);
        masc.setAtencion_especial(ateEspecial);
        masc.setUnDuenio(elDuenio);
        
        controlPersis.guardar(elDuenio, masc);
                
    }

    public List<Mascota> traerMascotas(int num_cliente) {
        return controlPersis.traerMascota();
    
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    
    }
    
    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascotaG, String mascota, String raza, String color, String observaciones,
            String alergias, String ateEspecial, String duenio, String telDuenio) {
        mascotaG.setNombre(mascota);
        mascotaG.setRaza(raza);
        mascotaG.setColor(color);
        mascotaG.setObservaciones(observaciones);
        mascotaG.setAlergico(alergias);
        mascotaG.setAtencion_especial(ateEspecial);
        
        controlPersis.modificarMascota(mascotaG);
    
        Duenio dueno = this.buscarDuenio(mascotaG.getUnDuenio().getId_duenio());
        dueno.setNombre(duenio);
        dueno.setTelefono(telDuenio);
        
        this.modifarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);        
    }

    private void modifarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }

    public List<Mascota> traerMascota() {
        
        return controlPersis.traerMascota();
    
    }

        
    
}
