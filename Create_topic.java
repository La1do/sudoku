
import java.util.Random;
import java.util.Scanner;
 
public class Create_topic {
    private static final int GRID_SIZE = 9;//kích thước bảng
    private static int[][]  board = new int[GRID_SIZE][GRID_SIZE];
    private static int[][] tmp = new int[GRID_SIZE][GRID_SIZE];
    private static int[][] first_board = new int[GRID_SIZE][GRID_SIZE];
    private static int[] so_dem = new int[GRID_SIZE];
    private static int[][] solve; // sallow copy mảng tmp sang mảng solve vì nếu tmp thay đổi thì solve cũng có thể thay đổi
    private static int[] first_so_dem = new int[GRID_SIZE];
    public static int[][] getBoard() {
        return board;
    }

    public static int getIndexBoard(int i, int j){
        return board[i][j];
    }

    public static void setIndexBoard(int i, int j, int n) {
        Create_topic.board[i][j] = n;
    }

    public static void setBoard(int[][] board){
        Create_topic.board = board;
    }

    public static int[][] getTmp() {
        return tmp;
    }

    public static void setTmp(int[][] tmp) {
        for(int i=0; i<GRID_SIZE; i++){
            for(int j=0; j<GRID_SIZE; j++){
                Create_topic.tmp[i][j] = tmp[i][j];
            }
        }
    }

    public static int[][] getFirst_board() {
        return first_board;
    }

    public static int getIndexFirst_board(int i, int j){
        return first_board[i][j];
    }

    public static void setFirst_board(int[][] first_board) {
        for(int i=0; i<GRID_SIZE; i++){
            for(int j=0; j<GRID_SIZE; j++){
                Create_topic.first_board[i][j] = first_board[i][j];
            }
        }
    }

    public static int[] getSo_dem() {
        return so_dem;
    }

    public static int getIndexSo_dem(int i){
        return so_dem[i];
    }

    public static void setIndexSo_dem(int i, int n) {
        Create_topic.so_dem[i] = n;
    }

    public static void setSo_dem(int[] so_dem){
        Create_topic.so_dem = so_dem;
    }

    public static int[][] getSolve() {
        return solve;
    }

    public static int getIndexSolve(int i, int j){
        return solve[i][j];
    }

    public static void setSolve(int[][] solve) {
        Create_topic.solve = solve;
    }

    public static int[] getFirst_so_dem() {
        return first_so_dem;
    }

    public static int getIndexFirst_so_dem(int i){
        return first_so_dem[i];
    }

    public static void setFirst_so_dem(int[] first_so_dem) {
        for(int i=0; i<GRID_SIZE; i++){
            Create_topic.first_so_dem[i] = first_so_dem[i];
        }
    }
    static Create_topic topic = new Create_topic();
    // hàm random số theo chế độ
    public static void Change(){
        Scanner scanner = new Scanner(System.in);
        randomBox1();
        if(SolveSudoku()){
            topic.setTmp(topic.getBoard());
            topic.setSolve(topic.getTmp());
            String chedo = "hard";
            switch(chedo){
                case "easy" -> randomSudoku(41, 4, 7);
                case "medium" -> randomSudoku(47, 3, 7);
                case "hard" -> randomSudoku(51, 3, 7);
                case "master" -> randomSudoku(58, 2, 7);
                case "GOD" -> randomSudoku(80, 0, 9);
            }
            topic.setFirst_board(topic.getBoard());
            topic.setFirst_so_dem(topic.getSo_dem());
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
                }while(checkBox(temp, i, j));
                topic.setIndexBoard(i, j, temp);
            }
        }
    }
    // kiểm tra hàng xem có bị trùng không
    private static boolean checkRow(int number, int row){
      for(int i = 0; i < GRID_SIZE; i++){
          if(topic.getIndexBoard(row, i) == number){
              return true;
          }
      }
      return false;
    }
    // kiểm tra cột xem có bị trùng không
    private static boolean checkColums(int number, int colums){
      for(int i = 0; i < GRID_SIZE; i++){
          if(topic.getIndexBoard(i, colums) == number){
              return true;
          }
      }
      return false;
    }
    // kiểm tra trong ô 
    private static boolean checkBox(int number, int row, int colums){
        int LocalBoxRow = row - row%3;
        int LocalBoxColums = colums - colums%3;
        
        for(int i = LocalBoxRow; i < LocalBoxRow + 3; i++){
            for(int j = LocalBoxColums; j < LocalBoxColums + 3; j++){
                if(topic.getIndexBoard(i, j) == number){
                    return true;
                }
            }      
        }
        return false;
    }
    // kiểm tra toàn bộ
    public static boolean checkSudoku(int number, int row, int colums){
        return !checkRow(number, row) 
               && !checkColums(number, colums) 
               && !checkBox(number, row, colums);
    }
    // viết đáp án cho board hiện thời
    private static boolean SolveSudoku(){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j< GRID_SIZE; j++){
                if(topic.getIndexBoard(i, j) == 0){
                    for(int numbertotry = 1; numbertotry <= GRID_SIZE; numbertotry++){ 
                        if(checkSudoku(numbertotry, i, j)){  // thử từng số xem có phù hợp k
                            topic.setIndexBoard(i, j, numbertotry);;
                            if(SolveSudoku()){ //đệ quy xem các bước tiếp theo có phù hợp so với số hiện tại không
                                return true;
                            }
                            else{ // nếu không gán lại 0 cho ô
                                topic.setIndexBoard(i, j, 0);
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
    private static int countBox(int row, int colums){
        int count = 0;
        int LocalBoxRow = row - row%3;
        int LocalBoxColums = colums - colums%3;
        
        for(int i = LocalBoxRow; i < LocalBoxRow + 3; i++){
            for(int j = LocalBoxColums; j < LocalBoxColums + 3; j++){
                if(topic.getIndexBoard(i, j) != 0){
                    count++;
                }
            }      
        }
        return count;
    }
    // random ô trong board để xóa ngẫu nhiên
    private static void randomSudoku(int gioi_han_tong, int gioi_han_o, int gioi_han_so){
        int i = 0;
        int x, y;
        Random random = new Random();
        while(i<gioi_han_tong){
            do{
                x = random.nextInt(9);
                y = random.nextInt(9);
            }while(topic.getIndexBoard(x, y)==0 || countBox(x, y)<gioi_han_o+1 || topic.getIndexSo_dem(board[x][y]-1)>=gioi_han_so);
            topic.setIndexSo_dem(board[x][y]-1, topic.getIndexSo_dem(board[x][y]-1)+1);
            topic.setIndexBoard(x, y, 0);
            i++;
        }
    }
    
}
