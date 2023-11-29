import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Algorytm Plecakowy Ogólny");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę rodzajów pakowanych rzeczy");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Wpisz kolejno elementy tablicy wartości, potem tablicy wagi");
        int[] valueArray = new int[size];
        int[] weightArray = new int[size];
        for(int i = 0; i < size; i++){
            valueArray[i] = scanner.nextInt();
            weightArray[i] = scanner.nextInt();
        }

        arraysSort(valueArray ,weightArray);

        for(int i = 0; i < size; i++) System.out.print(valueArray[i] + "  |  ");
        System.out.println(" ");
        for(int i = 0; i < size; i++) System.out.print(weightArray[i] + "  |  ");
        System.out.println(" ");


        System.out.println("Podaj wagę plecaka");
        int weight = scanner.nextInt();
        int[] numberUsedProducts = new int[size];

        int value = packBackpack(valueArray,weightArray,weight,numberUsedProducts);
        System.out.println("Wartość plecaka to: " + value);

        System.out.println("Ilość kolejnych elementów w plecaku");
        for(int i = 0; i < size; i++) System.out.print(numberUsedProducts[i] + "  |  ");
    }
    public static int packBackpack(int[] valueArray, int[] weightArray,int weight , int[] numberUsedProducts){
        int size = valueArray.length;
        int result = 0;

        for(int i = 0; i < size; i++){
            numberUsedProducts[i] = weight / weightArray[i];
            weight -= numberUsedProducts[i] * weightArray[i];
            result += numberUsedProducts[i] * valueArray[i];
        }
        return result;
    }

    public static void arraysSort(int[] valueArray, int[] weightArray){
        int size = valueArray.length;
        int valueTemp;
        int weightTemp;
        for(int i = 1; i < size; i++){
            valueTemp = valueArray[i];
            weightTemp = weightArray[i];
            for(int j = i - 1; j >= 0; j--){
                if(((double) valueArray[j] / weightArray[j]) < (double) valueTemp / weightTemp){
                    valueArray[j + 1] = valueArray[j];
                    weightArray[j + 1] = weightArray[j];
                    valueArray[j] = valueTemp;
                    weightArray[j] = weightTemp;
                }
            }
        }
    }
}