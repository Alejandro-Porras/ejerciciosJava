package ud08.Ejercicios._15_mascotas;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Mascota> animales;

    public Inventario() {
        animales = new ArrayList<>();
    }

    public void insertarAnimal(Mascota animal) {
        animales.add(animal);
    }

    public void eliminarAnimal(Mascota animal) {
        animales.remove(animal);
    }

    public void vaciarInventario() {
        animales.clear();
    }

    public void mostrarListaAnimales() {
        for (Mascota animal : animales) {
            System.out.println(animal.getClass().getSimpleName() + ": " + animal.getNombre());
        }
    }

    public void mostrarDatosAnimal(String nombre) {
        for (Mascota animal : animales) {
            if (animal.getNombre().equals(nombre)) {
                System.out.println(animal);
                return;
            }
        }
        System.out.println("No se encontró ningún animal con ese nombre.");
    }

    public void mostrarTodosDatosAnimales() {
        for (Mascota animal : animales) {
            System.out.println(animal);
        }
    }

    public class Main {
        public static void main(String[] args) {
            Inventario inventario = new Inventario();
    
            inventario.insertarAnimal(new Perro("Bobby", 3, "Feliz", "01/01/2019", "Labrador", false));
            inventario.insertarAnimal(new Gato("Garfield", 5, "Durmiendo", "01/03/2017", "Naranja", true));
            inventario.insertarAnimal(new Loro("Paco", 2, "Jugando", "10/05/2020", "Amarillo", true, "América", true));
            inventario.insertarAnimal(new Canario("Piolin", 1, "Cantando", "05/02/2021", "Corto", true, "Amarillo", true));
    
            System.out.println("Lista de animales en el inventario:");
            inventario.mostrarListaAnimales();
            System.out.println();
    
            System.out.println("gato Garfield:");
            inventario.mostrarDatosAnimal("Garfield");
            System.out.println();
    
            System.out.println("Datos de todos los animales en el inventario:");
            inventario.mostrarTodosDatosAnimales();
        }
    }
    
}
