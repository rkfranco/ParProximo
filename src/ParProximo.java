import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParProximo {

    public static Map<Double, List<Ponto>> executar(List<Ponto> pontos) {
        double menorDistancia = 0;
        Ponto pontoA = null;
        Ponto pontoB = null;
        int n = pontos.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                pontoA = pontos.get(i);
                pontoB = pontos.get(j);
                menorDistancia = getMenorDistancia(menorDistancia, pontoA, pontoB);

            }
        }
        List<Ponto> pontosRetorno = new ArrayList<>();
        pontosRetorno.add(pontoA);
        pontosRetorno.add(pontoB);
        HashMap<Double, List<Ponto>> retorno = new HashMap<>();
        retorno.put(menorDistancia, pontosRetorno);
        return retorno;
    }

    private static double getMenorDistancia(double menorDistancia, Ponto pontoUm, Ponto pontoDois) {
        double distancia = calcularDistancia(pontoUm, pontoDois);

        // Primeiro caso
        if (menorDistancia == 0)
            return distancia;

        if (menorDistancia > distancia)
            return distancia;
        return menorDistancia;
    }

    private static double calcularDistancia(Ponto pontoUm, Ponto pontoDois) {
        return Math.sqrt(Math.pow(pontoUm.getX() - pontoDois.getX(), 2) + Math.pow((pontoUm.getY() - pontoDois.getY()), 2));
    }
}
