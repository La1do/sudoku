
import java.util.Random;
import java.util.Scanner;

public class Create_topic {
    private static final int GRID_SIZE = 9;
    public static int[][]  board = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    public static int[][] tmp = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    static Create_topic topic = new Create_topic();
    public static int[][] solve = tmp;
    public static void Change(){
        Scanner scanner = new Scanner(System.in);
        randomBox1();
        if(SolveSudoku(topic.board)){
            copySolve(topic.tmp, topic.board);
            System.out.print("Nhap che do choi: ");
            String chedo = "hard";
            switch(chedo){
                case "easy" -> randomSudoku(topic.board, 41, 4);
                case "medium" -> randomSudoku(topic.board, 47, 3);
                case "hard" -> randomSudoku(topic.board, 51, 3);
                case "master" -> randomSudoku(topic.board, 58, 2);
                case "GOD" -> randomSudoku(topic.board, 80, 0);
            }
            
        }  
        printBoard();
        
    }
    private static void printBoard(){
        for(int i=0; i<GRID_SIZE; i++){
                if(i%3==0 && i!=0){
                    System.out.println("-------------------");
                }
                for(int j=0; j<GRID_SIZE; j++){
                    if(j%3==0 && j!=0){
                        System.out.print("|");
                    }
                    System.out.print(topic.board[i][j] + " ");
                }
                System.out.println();
            }
    }
    
    private static void randomBox1(){
        Random random = new Random();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int temp;
                do{
                    temp = random.nextInt(9) + 1;
                }while(checkBox(topic.board, temp, i, j));
                board[i][j] = temp;
            }
        }
    }
    
    private static void copySolve(int[][] tmp, int[][] board){
        for(int i=0; i<GRID_SIZE; i++){
            for(int j=0; j<GRID_SIZE; j++){
                tmp[i][j] = board[i][j];
            }
        }
    }
    
    private static boolean checkRow(int[][] board, int number, int row){
      for(int i = 0; i < GRID_SIZE; i++){
          if(board[row][i] == number){
              return true;
          }
      }
      return false;
    }
    
    private static boolean checkColums(int[][] board, int number, int colums){
      for(int i = 0; i < GRID_SIZE; i++){
          if(board[i][colums] == number){
              return true;
          }
      }
      return false;
    }
    
    private static boolean checkBox(int[][] board, int number, int row, int colums){
        int LocalBoxRow = row - row%3;
        int LocalBoxColums = colums - colums%3;
        
        for(int i = LocalBoxRow; i < LocalBoxRow + 3; i++){
            for(int j = LocalBoxColums; j < LocalBoxColums + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }      
        }
        return false;
    }
    
    private static boolean checkSudoku(int[][] board, int number, int row, int colums){
        return !checkRow(board, number, row) 
               && !checkColums(board, number, colums) 
               && !checkBox(board, number, row, colums);
    }
    
    private static boolean SolveSudoku(int[][] board){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j< GRID_SIZE; j++){
                if(board[i][j] == 0){
                    for(int numbertotry = 1; numbertotry <= GRID_SIZE; numbertotry++){
                        if(checkSudoku(board, numbertotry, i, j)){
                            board[i][j] = numbertotry;
                            if(SolveSudoku(board)){
                                return true;
                            }
                            else{
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static int countBox(int[][] board, int row, int colums){
        int count = 0;
        int LocalBoxRow = row - row%3;
        int LocalBoxColums = colums - colums%3;
        
        for(int i = LocalBoxRow; i < LocalBoxRow + 3; i++){
            for(int j = LocalBoxColums; j < LocalBoxColums + 3; j++){
                if(board[i][j] != 0){
                    count++;
                }
            }      
        }
        return count;
    }
    private static void randomSudoku(int[][] board, int ghtong, int gho){
        int i = 0;
        int x, y;
        Random random = new Random();
        while(i<ghtong){
            do{
                x = random.nextInt(9);
                y = random.nextInt(9);
            }while(board[x][y]==0 || countBox(board, x, y)<gho+1);
            board[x][y] = 0;
            i++;
        }
    }
    
}
