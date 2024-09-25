
import java.util.Random;
import java.util.Scanner;
 
public class Create_topic {
    private static final int GRID_SIZE = 9;//kích thước bảng
    public static int[][]  board = new int[GRID_SIZE][GRID_SIZE];
    public static int[][] tmp = new int[GRID_SIZE][GRID_SIZE];
    public static int[][] first_board = new int[GRID_SIZE][GRID_SIZE];
    public static int[] so_dem = new int[GRID_SIZE];
    static Create_topic topic = new Create_topic();
    public static int[][] solve = tmp; // sallow copy mảng tmp sang mảng solve vì nếu tmp thay đổi thì solve cũng có thể thay đổi
    public static int[] first_so_dem = new int[GRID_SIZE];
    // hàm random số theo chế độ
    public static void Change(){
        Scanner scanner = new Scanner(System.in);
        randomBox1();
        if(SolveSudoku(topic.board)){
            copySolve(topic.tmp, topic.board);
            String chedo = "hard";
            switch(chedo){
                case "easy" -> randomSudoku(topic.board,topic.so_dem , 41, 4, 7);
                case "medium" -> randomSudoku(topic.board,topic.so_dem , 47, 3, 7);
                case "hard" -> randomSudoku(topic.board,topic.so_dem , 51, 3, 7);
                case "master" -> randomSudoku(topic.board,topic.so_dem , 58, 2, 7);
                case "GOD" -> randomSudoku(topic.board,topic.so_dem , 80, 0, 9);
            }

            copySolve(topic.first_board, topic.board);
            copy_sodem(topic.first_so_dem, topic.so_dem);
        }
            
        }

        
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
                    System.out.print(topic.solve[i][j] + " ");
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
    private static void copy_sodem(int[] first_so_dem, int[] so_dem){
        for(int i=0; i<GRID_SIZE; i++){
            first_so_dem[i] = so_dem[i];
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
    public static boolean checkSudoku(int[][] board, int number, int row, int colums){
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
    private static void randomSudoku(int[][] board, int[] so_dem, int gioi_han_tong, int gioi_han_o, int gioi_han_so){
        int i = 0;
        int x, y;
        Random random = new Random();
        while(i<gioi_han_tong){
            do{
                x = random.nextInt(9);
                y = random.nextInt(9);
            }while(board[x][y]==0 || countBox(board, x, y)<gioi_han_o+1 || topic.so_dem[board[x][y]-1]>=gioi_han_so);
            topic.so_dem[board[x][y]-1] += 1;
            board[x][y] = 0;
            i++;
        }
    }
    
}
