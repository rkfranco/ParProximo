public class Utils {

    public static double getMenorDistancia(double menorDistancia, Ponto pontoUm, Ponto pontoDois) {
        return Math.min(menorDistancia, calcularDistancia(pontoUm, pontoDois));
    }

    public static double getMenorDistanciaOtimizada(double menorDistancia, Ponto pontoUm, Ponto pontoDois) {
        return Math.min(menorDistancia, calcularDistanciaOtimizada(pontoUm, pontoDois));
    }

    private static double calcularDistancia(Ponto pontoUm, Ponto pontoDois) {
        return Math.sqrt(Math.pow(pontoUm.getX() - pontoDois.getX(), 2) + Math.pow((pontoUm.getY() - pontoDois.getY()), 2));
    }

    private static double calcularDistanciaOtimizada(Ponto pontoUm, Ponto pontoDois) {
        return Math.abs(pontoUm.getX() - pontoDois.getX()) + Math.abs(pontoUm.getY() - pontoDois.getY());
    }


}
