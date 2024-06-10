package ud08.Ejercicios._04_centrocomercial;

public class TVLCD extends Televisor {
    private int pixelHorizontal;
    private int pixelVertical;

    public TVLCD(String marca, String modelo, double precio, double pulgadas, int pixelHorizontal, int pixelVertical) {
        super(marca, modelo, precio, pulgadas);
        this.pixelHorizontal = pixelHorizontal;
        this.pixelVertical = pixelVertical;
    }

    @Override
    public String resulucion() {
        return this.pixelHorizontal + " x " + this.pixelVertical + " pixels";
    }
}
