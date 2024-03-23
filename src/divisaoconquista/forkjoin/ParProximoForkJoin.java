package divisaoconquista.forkjoin;

import utils.Ponto;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParProximoForkJoin {
    public static Double executar(List<Ponto> pontos) {
        try (ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors())) {
            Collections.sort(pontos);
            return forkJoinPool.invoke(new ParProximoTask(pontos));
        }
    }
}
