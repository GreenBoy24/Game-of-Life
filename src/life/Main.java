package life;

import java.util.*;

public class Main {
    private static char[][] generationN;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int numberOfSeed = 10;
        int countOfGeneration = 10;
        Random random = new Random();
        char[][] generationOne = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(random.nextBoolean()){
                    generationOne[i][j] = 'O';
                    System.out.print('O');
                } else{
                    generationOne[i][j] = ' ';
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
        generationN = generationOne;

        for (int i = 0; i < countOfGeneration; i++) {
            generationN = nextGeneration(generationN,size);
            print(generationN,size);
            System.out.println();
        }

        //for (int i = 0; i < size; i++) {

        //}

    }

    public static void print(char[][] generation, int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(generation[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] nextGeneration(char[][] oldGeneration, int size){
        char[][] newGeneration = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //Count live neighbors
                int countNeighbors = countNeighbors(oldGeneration,i,j,size);
                char state = oldGeneration[i][j];
                if(state == ' ' && countNeighbors == 3){
                    newGeneration[i][j] = 'O';
                } else if(state == 'O' && (countNeighbors < 2 || countNeighbors > 3)){
                    newGeneration[i][j] = ' ';
                } else {
                    newGeneration[i][j] = state;
                }
            }
        }
        return newGeneration;
    }

    public static int countNeighbors(char[][] oldGeneration,int x,int y, int size){
        var sum = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                var column = (x + i + size) % size;
                var row = (y + j + size)% size;
                if(oldGeneration[column][row] == 'O'){
                    sum++;
                }
            }
        }
        if(oldGeneration[x][y] == 'O'){
            sum--;
        }
        return sum;
    }
}
