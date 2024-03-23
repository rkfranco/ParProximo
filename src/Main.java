import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
    private static final int xSize = 1000;
    private static final int ySize = 100;
    private static final String consoleBar = "----------------------------------------";

    public static void main(String[] args) {
        int qtdPontos = xSize * ySize;
        List<Ponto> pontos = new ArrayList<>(qtdPontos);
        inicializar(qtdPontos, pontos);
        executarParProximoIngenuo(pontos);
        executarParProximoDivisaoConquista(pontos);
        executarParProximoDivisaoConquistaForkJoin(pontos);
        System.out.println("FIM DA EXECUCAO");
    }

    private static void executarParProximoIngenuo(List<Ponto> pontos) {
        System.out.println(consoleBar);
        System.out.println("Iniciando par proximo ingenuo");
        long startTime = System.currentTimeMillis();
        double temp = ParProximoIngenuo.executar(pontos);
        System.out.println("Tempo de execucao: " + (System.currentTimeMillis() - startTime) + " milisegundos.");
        System.out.println("Distancia minima entre pontos: " + temp);
        System.out.println(consoleBar);
    }

    private static void executarParProximoDivisaoConquista(List<Ponto> pontos) {
        System.out.println("\n" + consoleBar);
        System.out.println("Iniciando par proximo divisao e conquista");
        long startTime = System.currentTimeMillis();
        double temp_2 = ParProximo.executar(pontos);
        System.out.println("Tempo de execucao: " + (System.currentTimeMillis() - startTime) + " milisegundos.");
        System.out.println("Distancia minima entre pontos: " + temp_2);
        System.out.println(consoleBar);
    }

    private static void executarParProximoDivisaoConquistaForkJoin(List<Ponto> pontos) {
        System.out.println("\n" + consoleBar);
        System.out.println("Iniciando par proximo divisao e conquista com Fork\\Join");
        long startTime = System.currentTimeMillis();
        double temp_3 = forkJoinPool.invoke(new ParProximoTask(pontos));
        System.out.println("Tempo de execucao: " + (System.currentTimeMillis() - startTime) + " milisegundos.");
        System.out.println("Distancia minima entre pontos: " + temp_3);
        System.out.println(consoleBar);
    }

    private static void inicializar(int qtdPontos, List<Ponto> pontos) {
        System.out.println(consoleBar);
        System.out.println("Criando " + qtdPontos + " pontos...");
        populatePoints(pontos);
        System.out.println("Misturando ordem dos pontos...");
        Collections.shuffle(pontos);
        System.out.println("Inicializacao finalizada");
        System.out.println("\n--- Iniciando algoritmos ---\n");
    }

    private static void populatePoints(List<Ponto> pontos) {
        for (int i = 1; i <= xSize; i++) {
            for (int j = 1; j <= ySize; j++) {
                pontos.add(new Ponto(i, j));
            }
        }
    }
}