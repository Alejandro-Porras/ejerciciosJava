package ud08.Ejercicios._04_centrocomercial;

public class TestTelevisor {
    public static void main(String[] args) {
        TVLCD teleLcd = new TVLCD("Sony", "si", 100, 33, 1920, 1080);
        TVTubo teleTubo = new TVTubo("HP", "no", 120, 333, 100);

        System.out.println(teleLcd);

        System.out.println(teleTubo);
    }
}
