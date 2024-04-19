package tests.ud06.serializable;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestCiber {
    public static void main(String[] args) {
        OrdenadorCiber pc1 = new OrdenadorCiber(0, 555, 2010);
        OrdenadorCiber pc2 = new OrdenadorCiber(1, 555, 2020);
        OrdenadorCiber pc3 = new OrdenadorCiber(2, 555, 2005);

        CreacionCiber c1 = new CreacionCiber(0, "Primer ciber", "si", pc3);
        CreacionCiber c2 = new CreacionCiber(1, "Primer ciber", "si", pc2);
        CreacionCiber c3 = new CreacionCiber(2, "Primer ciber", "si", pc1);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/tests/ud06/serializable/info.dat"))) {
            oos.writeObject(c1);
            oos.writeObject(c2);
            oos.writeObject(c3);
        } catch (FileNotFoundException e) {
            System.out.println("Error ->" + e.getMessage());
        } catch (IOException e) {
            System.out.println("ErrorR ->" + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/tests/ud06/serializable/info.dat"))) {
            while (true) {
                System.out.println(ois.readObject());
            }
        } catch (EOFException e) {
            // System.out.println("ERROR ->" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR ->" + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR ->" + e.getMessage());
        }
    }
}
