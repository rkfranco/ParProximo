package divisaoconquista.forkjoin;

import utils.Ponto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

import static utils.Utils.getMenorDistanciaOtimizada;

public class ParProximoTask extends RecursiveTask<Double> {

    private final List<Ponto> pontos;

    public ParProximoTask(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    private static double menorEntreConjuntos(List<Ponto> pontos, double dist, int div) {
        double x1 = pontos.get(div).getX() + dist;
        double y1 = pontos.get(div).getY() + dist;
        double x2 = pontos.get(div).getX() - dist;
        double y2 = pontos.get(div).getY() - dist;

        List<Ponto> selecionados = pontos.stream()
                .filter(p -> p.getX() < x1)
                .filter(p -> p.getX() > x2)
                .filter(p -> p.getY() < y1)
                .filter(p -> p.getY() > y2)
                .collect(Collectors.toList());

        return forcaBruta(selecionados);
    }

    private static double forcaBruta(List<Ponto> pontos) {
        double distancia = Double.MAX_VALUE;

        for (int i = 0; i < pontos.size(); i++) {
            for (int j = i + 1; j < pontos.size(); j++) {
                distancia = getMenorDistanciaOtimizada(distancia, pontos.get(i), pontos.get(j));
            }
        }

        return distancia;
    }

    @Override
    protected Double compute() {
        if (pontos.size() <= 3) return forcaBruta(pontos);

        int div = pontos.size() / 2;
        double menorDistancia = ForkJoinTask
                .invokeAll(createSubtasks(div)).stream()
                .mapToDouble(ForkJoinTask::join).min()
                .orElseThrow(() -> new NullPointerException("Nenhum valor numerico encontrado"));

        return Math.min(menorDistancia, menorEntreConjuntos(pontos, menorDistancia, div));
    }

    private Collection<ParProximoTask> createSubtasks(int div) {
        List<ParProximoTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new ParProximoTask(pontos.subList(0, div)));
        dividedTasks.add(new ParProximoTask(pontos.subList(div, pontos.size())));
        return dividedTasks;
    }
}
