import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParProximo {

    public static double executar(List<Ponto> pontos) {
        Collections.sort(pontos);

        if (pontos.size() <= 3) {
            return forcaBruta(pontos);
        }

        int div = pontos.size() / 2;

        double distanciaUM = executar(pontos.subList(0, div));
        double distanciaDois = executar(pontos.subList(div, pontos.size()));

        double menorDistancia = distanciaUM < distanciaDois ? distanciaUM : distanciaDois;
        double menorEntreConjuntos = menorEntreConjuntos(pontos, menorDistancia, div);

        return menorDistancia < menorEntreConjuntos ? menorDistancia : menorEntreConjuntos;
    }

    private static double menorEntreConjuntos(List<Ponto> pontos, double dist, int div) {
        double a = pontos.get(div).getX() + dist;
        double b = pontos.get(div).getX() - dist;
        List<Ponto> selecionados = pontos.stream()
                .filter(p -> p.getX() < a && p.getX() > b)
                .collect(Collectors.toList());
        return forcaBruta(selecionados);
    }

    private static double forcaBruta(List<Ponto> pontos) {
        double distancia = Double.MAX_VALUE;
        for (int i = 0; i < pontos.size(); i++) {
            for (int j = i + 1; j < pontos.size(); j++) {
                distancia = getMenorDistancia(distancia, pontos.get(i), pontos.get(j));
            }
        }
        return distancia;
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
