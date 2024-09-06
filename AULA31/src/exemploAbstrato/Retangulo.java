package exemploAbstrato;

public class Retangulo extends Figura{
    private double altura;
    private double base;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public Retangulo(){
        super.setNomeFigura("Retângulo");
    }

    @Override
    public double calculaArea(){
        return altura*base;
    }

    public double calculaPerimetro(){
        return 2*altura+2*base;
    }

}
