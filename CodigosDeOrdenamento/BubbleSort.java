package aula03_analise_algoritmos_ordenacao;

public class BubbleSort {
    private int operacoes;
    private long tempoInicio;
    private long tempoFim;
    public int getOperacoes() {
        return operacoes;
    }

    public long getTempoExecucao() {
        long tempoExecucao = (tempoFim - tempoInicio) / 1_000_000  ;
        return tempoExecucao;
    }

    public void ordenar(int[] arrayInteiros) {
        tempoInicio = System.nanoTime();
        operacoes = 0;
        int tamanho = arrayInteiros.length;
        for (int i = 0; i < tamanho; i++) {
            //ArrayUtils.imprimir(arrayParaOrdenar);
            for (int j = i + 1; j < tamanho; j++) {
                if(arrayInteiros[j]<arrayInteiros[i]) {
                    int temp = arrayInteiros[i];
                    arrayInteiros[i] = arrayInteiros[j];
                    arrayInteiros[j] = temp;
                    operacoes++;
                    //System.out.printf("Trocou %d pelo %d %n", temp, arrayParaOrdenar[j-1]);
                }
                operacoes++;
            }
        }
        tempoFim = System.nanoTime();
    }

    public static void main(String[] args) {
        int[] sizes = {100,101,104,120,180,200,250,350,400,423,455,480,500,1000,5000,10000,50000};
        
        for (int size : sizes) {
            int[] arrayToSort = generateRandomArray(size);
            BubbleSort bubble = new BubbleSort();
            bubble.ordenar(arrayToSort);
            
            int operations = bubble.getOperacoes();
            System.out.println("Tamanho do array: " + size);
            System.out.println("Operacoes: " + operations);
        }
    }
    
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }

}
