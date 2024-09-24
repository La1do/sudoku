
import java.util.Random;
import java.util.Scanner;
 
public class Create_topic {
    private static final int GRID_SIZE = 9;//kích thước bảng
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
    public static int[][] solve = tmp; // sallow copy mảng tmp sang mảng solve vì nếu tmp thay đổi thì solve cũng có thể thay đổi
    // hàm random số theo chế độ
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
    // xuất bảng
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
    // random ô 3x3 đầu tiên
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
    // deep copy đáp án sang mảng tmp để khi mảng board thay đổi thì tmp k thay đổi
    private static void copySolve(int[][] tmp, int[][] board){
        for(int i=0; i<GRID_SIZE; i++){
            for(int j=0; j<GRID_SIZE; j++){
                tmp[i][j] = board[i][j];
            }
        }
    }
    // kiểm tra hàng xem có bị trùng không
    private static boolean checkRow(int[][] board, int number, int row){
      for(int i = 0; i < GRID_SIZE; i++){
          if(board[row][i] == number){
              return true;
          }
      }
      return false;
    }
    // kiểm tra cột xem có bị trùng không
    private static boolean checkColums(int[][] board, int number, int colums){
      for(int i = 0; i < GRID_SIZE; i++){
          if(board[i][colums] == number){
              return true;
          }
      }
      return false;
    }
    // kiểm tra trong ô 
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
    // kiểm tra toàn bộ
    private static boolean checkSudoku(int[][] board, int number, int row, int colums){
        return !checkRow(board, number, row) 
               && !checkColums(board, number, colums) 
               && !checkBox(board, number, row, colums);
    }
    // viết đáp án cho board hiện thời
    private static boolean SolveSudoku(int[][] board){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j< GRID_SIZE; j++){
                if(board[i][j] == 0){
                    for(int numbertotry = 1; numbertotry <= GRID_SIZE; numbertotry++){ 
                        if(checkSudoku(board, numbertotry, i, j)){  // thử từng số xem có phù hợp k
                            board[i][j] = numbertotry;
                            if(SolveSudoku(board)){ //đệ quy xem các bước tiếp theo có phù hợp so với số hiện tại không
                                return true;
                            }
                            else{ // nếu không gán lại 0 cho ô
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
    // đếm số lượng số hiện tại trong ô
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
    // random ô trong board để xóa ngẫu nhiên
    private static void randomSudoku(int[][] board, int gioi_han_tong, int gioi_han_o){
        int i = 0;
        int x, y;
        Random random = new Random();
        while(i<gioi_han_tong){
            do{
                x = random.nextInt(9);
                y = random.nextInt(9);
            }while(board[x][y]==0 || countBox(board, x, y)<gioi_han_o+1);
            board[x][y] = 0;
            i++;
        }
    }
    
}
