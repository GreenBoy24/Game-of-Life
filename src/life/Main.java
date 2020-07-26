package life;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int numberOfSeed = scanner.nextInt();
        int countOfGeneration = scanner.nextInt();
        Random random = new Random(numberOfSeed);
        char[][] generationOne = new char[numberOfSeed][numberOfSeed];
        char[][] generationN = new char[numberOfSeed][numberOfSeed];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(random.nextBoolean()){
                    System.out.print('O');
                    generationN[i][j] = 'O';
                } else{
                    System.out.print(' ');
                    generationN[i][j] = ' ';
                }
            }
            System.out.println();
        }

    }

    public static char[][] nextGeneration(char[][] oldGeneration, int size){
        char[][] newGeneration = new char[size][size];
        for (int i = 0; i < size; i++) {
            int countSeed = 0;
            for (int j = 0; j < size; j++) {

            }
        }
        return newGeneration;
    }
}
