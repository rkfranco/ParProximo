import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParProximoIngenuo {

    public static double executar(List<Ponto> pontos) {
        double menorDistancia = Double.MAX_VALUE;
        int n = pontos.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                menorDistancia = getMenorDistancia(menorDistancia, pontos.get(i), pontos.get(j));
            }
        }
        return menorDistancia;
    }

    private static double getMenorDistancia(double menorDistancia, Ponto pontoUm, Ponto pontoDois) {
        double distancia = calcularDistancia(pontoUm, pontoDois);

        if (menorDistancia > distancia)
            return distancia;
        return menorDistancia;
    }

    private static double calcularDistancia(Ponto pontoUm, Ponto pontoDois) {
        return Math.sqrt(Math.pow(pontoUm.getX() - pontoDois.getX(), 2) + Math.pow((pontoUm.getY() - pontoDois.getY()), 2));
    }
}
