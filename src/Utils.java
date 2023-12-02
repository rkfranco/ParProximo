public class Utils {

    static double getMenorDistancia(double menorDistancia, Ponto pontoUm, Ponto pontoDois) {
        return Math.min(menorDistancia, calcularDistancia(pontoUm, pontoDois));
    }

    private static double calcularDistancia(Ponto pontoUm, Ponto pontoDois) {
        return Math.sqrt(Math.pow(pontoUm.getX() - pontoDois.getX(), 2) + Math.pow((pontoUm.getY() - pontoDois.getY()), 2));
    }
}
