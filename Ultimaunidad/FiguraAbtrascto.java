package Ultimaunidad;

public class FiguraAbtrascto {




        public static void main(String[] args) {
            FormaGeometrica[] formas = {
                    new Circulo(5.0),
                    new TrianguloEquilatero(4.0, 3.0),
                    new Rectangulo(6.0, 4.0)
            };

            for (FormaGeometrica forma : formas) {
                String tipo = forma.getClass().getSimpleName();
                System.out.printf("%s:\n", tipo);
                System.out.printf("  ↳ Área: %.2f unidades\n", forma.obtenerArea());
                System.out.printf("  ↳ Perímetro: %.2f unidades\n\n", forma.obtenerPerimetro());
            }
        }


}
abstract class FormaGeometrica {
    abstract double obtenerArea();
    abstract double obtenerPerimetro();
}

class Circulo extends FormaGeometrica {
    private final double radio;

    Circulo(double r) {
        this.radio = r;
    }

    @Override
    double obtenerPerimetro() {
        return Math.PI * 2 * radio;
    }

    @Override
    double obtenerArea() {
        return Math.PI * radio * radio;
    }
}

class TrianguloEquilatero extends FormaGeometrica {
    private final double longitudLado;
    private final double altura;

    TrianguloEquilatero(double lado, double h) {
        this.longitudLado = lado;
        this.altura = h;
    }

    @Override
    double obtenerArea() {
        return (longitudLado * altura) / 2.0;
    }

    @Override
    double obtenerPerimetro() {
        return 3.0 * longitudLado;
    }
}

class Rectangulo extends FormaGeometrica {
    private final double ancho;
    private final double alto;

    Rectangulo(double a, double h) {
        this.ancho = a;
        this.alto = h;
    }

    @Override
    double obtenerArea() {
        return ancho * alto;
    }

    @Override
    double obtenerPerimetro() {
        return 2.0 * (ancho + alto);
    }
}
