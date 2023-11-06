package ud02;

public class Actividad10 {
    private double km;
    private double litros;
    private double vmed;
    private double pgas;

    //constructor con todos los parámetros.
    public Actividad10 (double km, double litros, double vmed, double pgas){
        this.km = km; //Kilometro recorridos
        this.litros = litros; //litros de gasolina gastados en el viaje
        this.vmed = vmed; //velocidad media del viaje
        this.pgas = pgas; //precio de la gasolina
    }

    //conseguir tiempo del viaje
    public double getTiempo(){
        return this.km/this.vmed;
    }
    
    //conseguir el consumo medio
    public double consumoMedio(){
        return this.litros * 100 / this.km;
    }

    //conseguir precio del consumo cada 100%
    public double consumoEuros(){
        return this.litros * 100 /this.pgas;
    }
}
