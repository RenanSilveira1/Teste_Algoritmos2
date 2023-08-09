package aula03_analise_algoritmos_ordenacao;
public class InsertionSort {
    private int operacoes;
    public int getOperacoes() {
        return operacoes;
    }
    public void ordenar(int[] arrayInteiros) {
        operacoes = 0;
        int tamanho = arrayInteiros.length;
        int chave;
        for (int j = 1; j < tamanho; j++) { //inicia no elemento 1
            chave = arrayInteiros[j];
            //System.out.printf("chave = %d%n", chave);
            int i = j - 1;
            while ( (i>=0) && (arrayInteiros[i] > chave) ) {
                //System.out.printf("Trocou %d pelo %d%n", arrayInteiros[i+1], arrayInteiros[i]);
                arrayInteiros[i+1] = arrayInteiros[i];
                i = i -1;
                operacoes++;
            }
            operacoes++;
            arrayInteiros[i+1] = chave;
        }
    }
    public static void main(String[] args) {
        int[] sizes = {100,101,104,120,180,200,250,350,400,423,455,480,500,1000,5000,10000,50000}; // Tamanhos dos arrays a serem testados
        
        for (int size : sizes) {
            int[] arrayToSort = generateRandomArray(size); // Gera um array de tamanho 'size'
            InsertionSort insertion = new InsertionSort();
            insertion.ordenar(arrayToSort);
            
            int operations = insertion.getOperacoes();
            System.out.println("Array size: " + size);
            System.out.println("Operations: " + operations);
        }
    }
    
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000); // Preenche o array com valores aleatórios
        }
        return array;
    }
}
