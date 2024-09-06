package exemploAbstrato;

public class Circulo extends Figura{
    private double raio;

    public Circulo(){
        super.setNomeFigura("Circulo");  // ou só setNomeFigura("Circulo");
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double calculaArea(){
        return Math.PI*Math.pow(raio, 2);
    }

    public double calculaPerimetro(){
        return 2*Math.PI*raio;
    }




}
