package ud08.Ejercicios._09_supermercado;

import java.time.LocalDate;

public interface EsAlimento {
    public void setCaducidad(LocalDate fc); 
    public LocalDate getCaducidad(); 
    public int getCalorias();
}
