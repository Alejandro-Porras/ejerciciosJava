package ud02;

import java.util.Scanner;

public class Actividad14 {
    private int cif;
    private String nombreEmpresa;
    private String descripcion;
    private String sector;
    private String direccion;
    private int telefono;
    private String poblacion;
    private int codigoPostal;
    private String correo;

    public Actividad14(){

    }

    public Actividad14(int cif, String nombreEmpresa, String descripcion, 
    String sector, String direccion, int telefono, String poblacion, 
    int codigoPostal, String correo){
        this.cif=cif;
        this.nombreEmpresa=nombreEmpresa;
        this.descripcion=descripcion;
        this.sector=sector;
        this.direccion=direccion;
        this.telefono=telefono;
        this.poblacion=poblacion;
        this.codigoPostal=codigoPostal;
        this.correo=correo;
    }

    public void cambioSector(String sector2){
        this.sector=sector2;
    }

    public boolean verificaCorreo(){
        return (this.correo.contains("@"));
    }

    @Override
    public String toString(){
        return "\n+--------------------------\n" +
               "|Proveedor\n" + 
               "|\n" +
               "|CIF:\t\t\t" + this.cif + "\n" +
               "|Nombre Empresa:\t" + this.nombreEmpresa + "\n" +
               "|Descripcion:\t\t" + this.descripcion + "\n" +
               "|Sector:\t\t" + this.sector + "\n" +
               "|Direccion:\t\t" + this.direccion + "\n" +
               "|Telefono:\t\t" + this.telefono + "\n" +
               "|Poblacion:\t\t" + this.poblacion + "\n" +
               "|Codigo Postal:\t\t" + this.codigoPostal + "\n" +
               "|Correo:\t\t" + this.correo + "\n" +
               "+--------------------------\n";
    }
    

    public static void main(String[] args) throws InterruptedException{
    Scanner entrada = new Scanner(System.in);

     int cif;
     String nombreEmpresa;
     String descripcion;
     String sector;
     String direccion;
     int telefono;
     String poblacion;
     int codigoPostal;
     String correo;
     String sino;
     String sector2;

    System.out.println("Introduzca los siguientes datos: ");

    System.out.print("CIF: ");
    cif=entrada.nextInt();
    
    System.out.print("Nombre de la empresa: ");
    entrada.nextLine();
    nombreEmpresa=entrada.nextLine();

    System.out.print("Descripcion de la empresa: ");
    descripcion=entrada.nextLine();

    System.out.print("Sector de la empresa: ");
    sector=entrada.nextLine();

    System.out.print("Direccion de la empresa: ");
    direccion=entrada.nextLine();

    System.out.print("Telefono de la empresa: ");
    telefono=entrada.nextInt();

    System.out.print("Poblacion de la empresa: ");
    entrada.nextLine();
    poblacion=entrada.nextLine();

    System.out.print("Codigo Postal de la empresa: ");
    codigoPostal=entrada.nextInt();

    System.out.print("Correo de la empresa: ");
    correo=entrada.next();

    Actividad14 prov1 = new Actividad14(cif, nombreEmpresa, descripcion, sector, direccion, telefono, poblacion, codigoPostal, correo);

    System.out.println("\n\n\nEl correo es :" + prov1.verificaCorreo());

    Thread.sleep(3*1000);
    System.out.println(prov1.toString());

    Thread.sleep(3*1000);
    System.out.println("\n\nQuiere cambiar el sector? (si/no)");
    sino = entrada.next();

    switch (sino.toLowerCase()) {
        case "si":
            System.out.print("\nIntroduzca nuevo sector: ");
            entrada.nextLine();
            sector2=entrada.nextLine();

            prov1.cambioSector(sector2);

            System.out.println("\n\nINFORMACION CAMBIADA:");
            System.out.println(prov1.toString());
            break;

        case "no":
            System.out.println("\nSe acabó el programa.");
            break;

        default:
            System.out.println("No has introducido un valor correcto.");
            break;
    }

    entrada.close();
    }

}
