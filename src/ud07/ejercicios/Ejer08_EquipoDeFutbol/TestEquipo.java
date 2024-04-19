package ud07.ejercicios.Ejer08_EquipoDeFutbol;

import ud07.ejercicios.Ejer08_EquipoDeFutbol.Equipo.posicionesMaximaException;
import ud07.ejercicios.Ejer08_EquipoDeFutbol.Futbolista.Posicion;

public class TestEquipo {
       public static void main(String[] args) {
   
           Equipo equipo = new Equipo("Valencia");
          
           Futbolista f1 = new Futbolista("Mamardashvili", 24, Posicion.PORTERO);
           f1.agregarEquipo("Sevilla");
           // f1.agregarEquipo("La Manco");
           // f1.agregarEquipo("Levante");
           try {
               equipo.agregarFutbolista(f1);
               equipo.agregarFutbolista(new Futbolista("Javi Guerra", 21, Posicion.CENTROCAMPISTA));
               equipo.agregarFutbolista(new Futbolista("Mosquera", 20, Posicion.DEFENSA));
               equipo.agregarFutbolista(new Futbolista("Canós", 27, Posicion.DELANTERO));
               equipo.agregarFutbolista(new Futbolista("Hugo Duro", 25, Posicion.DELANTERO));
               equipo.agregarFutbolista(new Futbolista("Domenech", 34, Posicion.PORTERO));
            //    equipo.agregarFutbolista(new Futbolista("C.Rivero", 26, Posicion.PORTERO));
               equipo.agregarFutbolista(new Futbolista("Diego López", 22, Posicion.DELANTERO));
               equipo.agregarFutbolista(new Futbolista("Yaremchuk", 29, Posicion.DELANTERO));
            //    equipo.agregarFutbolista(new Futbolista("A. Marí", 23, Posicion.DELANTERO));
               equipo.agregarFutbolista(new Futbolista("Diakhaby", 28, Posicion.DEFENSA));
               equipo.agregarFutbolista(new Futbolista("Pepelu", 26, Posicion.CENTROCAMPISTA));
               equipo.agregarFutbolista(new Futbolista("Fran Pérez", 22, Posicion.CENTROCAMPISTA));
               equipo.agregarFutbolista(new Futbolista("Hugo G.", 24, Posicion.DEFENSA));
        } catch (posicionesMaximaException e) {
            System.out.println(e.getMessage());
        }
        equipo.listarFormacionDelEquipo();
       }
   }
