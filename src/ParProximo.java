import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParProximo {

    public static double executar(List<Ponto> pontos) {
        Collections.sort(pontos);
        return executarAux(pontos);
    }

    private static double executarAux(List<Ponto> pontos) {
        if (pontos.size() <= 3) return forcaBruta(pontos);

        int div = pontos.size() / 2;

        double distanciaUM = executarAux(pontos.subList(0, div));
        double distanciaDois = executarAux(pontos.subList(div, pontos.size()));

        double menorDistancia = Math.min(distanciaUM, distanciaDois);
        double menorEntreConjuntos = menorEntreConjuntos(pontos, menorDistancia, div);

        return Math.min(menorDistancia, menorEntreConjuntos);
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
                distancia = Utils.getMenorDistancia(distancia, pontos.get(i), pontos.get(j));
            }
        }

        return distancia;
    }
}
