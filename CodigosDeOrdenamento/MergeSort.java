package aula03_analise_algoritmos_ordenacao;

public class MergeSort {
    private int[] numbers;
    private int[] helper;

    private int number;

    private int operacoes;

    public int getOperacoes() {
        return operacoes;
    }


    public int ordenar(int[] values) {
        operacoes = 0;

        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
        return this.operacoes;
    }

    private void mergesort(int low, int high) {
        operacoes++;
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
            operacoes++;
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            operacoes++;
            k++;
        }
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
            operacoes++;
        }
    }

    public static void main(String[] args) {
        int[] sizes = {100,101,104,120,180,200,250,350,400,423,455,480,500,1000,5000,10000,50000}; // Tamanhos dos arrays a serem testados
        
        for (int size : sizes) {
            int[] arrayToSort = generateRandomArray(size); // Gera um array de tamanho 'size'
            MergeSort mergeSort = new MergeSort();
            int operations = mergeSort.ordenar(arrayToSort);
            
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
