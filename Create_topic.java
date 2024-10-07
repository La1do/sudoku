
import java.util.Random;
import java.util.Scanner;
 
public class Create_topic {
    private static final int GRID_SIZE = 9;//kích thước bảng
    private int[][]  board = new int[GRID_SIZE][GRID_SIZE];
    private int[][] board0 = new int[GRID_SIZE][GRID_SIZE];
    public int[][] getBoard0() { return board0; }
    private int[][] tmp = new int[GRID_SIZE][GRID_SIZE];
    private int[][] first_board = new int[GRID_SIZE][GRID_SIZE];
    private int[] so_dem = new int[GRID_SIZE];
    private int[][] solve; // sallow copy mảng tmp sang mảng solve vì nếu tmp thay đổi thì solve cũng có thể thay đổi
    private int[] first_so_dem = new int[GRID_SIZE];
    public int[][] getBoard() {
        return board;
    }

    public int getIndexBoard(int i, int j){
        return board[i][j];
    }

    public void setIndexBoard(int i, int j, int n) {
        board[i][j] = n;
    }

    public void setBoard(int[][] board){
        this.board = board;
    }

    public int[][] getTmp() {
        return tmp;
    }

    public void setTmp(int[][] tmp) {
        for(int i=0; i<GRID_SIZE; i++){
            for(int j=0; j<GRID_SIZE; j++){
                this.tmp[i][j] = tmp[i][j];
            }
        }
    }

    public int[][] getFirst_board() {
        return first_board;
    }

    public int getIndexFirst_board(int i, int j){
        return first_board[i][j];
    }

    public void setFirst_board(int[][] first_board) {
        for(int i=0; i<GRID_SIZE; i++){
            for(int j=0; j<GRID_SIZE; j++){
                this.first_board[i][j] = first_board[i][j];
            }
        }
    }

    public int[] getSo_dem() {
        return so_dem;
    }

    public int getIndexSo_dem(int i){
        return so_dem[i];
    }

    public void setIndexSo_dem(int i, int n) {
        this.so_dem[i] = n;
    }

    public void setSo_dem(int[] so_dem){
        this.so_dem = so_dem;
    }

    public int[][] getSolve() {
        return solve;
    }

    public int getIndexSolve(int i, int j){
        return solve[i][j];
    }

    public void setSolve(int[][] solve) {
        this.solve = solve;
    }

    public int[] getFirst_so_dem() {
        return first_so_dem;
    }

    public int getIndexFirst_so_dem(int i){
        return first_so_dem[i];
    }

    public void setFirst_so_dem(int[] first_so_dem) {
        for(int i=0; i<GRID_SIZE; i++){
            this.first_so_dem[i] = first_so_dem[i];
        }
    }
    private int level = 0;
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel(){
        return level;
    }
    // hàm random số theo chế độ
    public void Change(int chedo){
        // reset board và tất cả các mảng về 0 hết
        for(int i=0; i<GRID_SIZE; i++){
            for(int j=0; j<GRID_SIZE; j++){
                board[i][j] = 0;
                board0[i][j] = 0;
                tmp[i][j] = 0;
                first_board[i][j] = 0;
            }
            so_dem[i] = 0;
            first_so_dem[i] = 0;
        }
        
        
        randomBox1();
        if(SolveSudoku()){
            setTmp(getBoard());
            setSolve(getTmp());
            
            switch(level){
                case 1 -> randomSudoku(41, 4, 7);
                case 2 -> randomSudoku(47, 3, 7);
                case 3 -> randomSudoku(51, 3, 7);
                case 4 -> randomSudoku(58, 2, 7);
                case 5 -> randomSudoku(72, 1, 9);
            }
            setFirst_board(getBoard());
            setFirst_so_dem(getSo_dem());
        }  
    }

    public void printBoard(){
        for(int i=0; i<GRID_SIZE; i++){
            for(int j=0; j<GRID_SIZE; j++){
                System.out.print(getIndexBoard(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printSolve(){
        for(int i=0; i<GRID_SIZE; i++){
            for(int j=0; j<GRID_SIZE; j++){
                System.out.print(getIndexSolve(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // random ô 3x3 đầu tiên
    private void randomBox1(){
        Random random = new Random();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int temp;
                do{
                    temp = random.nextInt(9) + 1;
                }while(checkBox(temp, i, j));
                setIndexBoard(i, j, temp);
            }
        }
    }
    // kiểm tra hàng xem có bị trùng không
    private boolean checkRow(int number, int row){
      for(int i = 0; i < GRID_SIZE; i++){
          if(getIndexBoard(row, i) == number){
              return true;
          }
      }
      return false;
    }
    // kiểm tra cột xem có bị trùng không
    private boolean checkColums(int number, int colums){
      for(int i = 0; i < GRID_SIZE; i++){
          if(getIndexBoard(i, colums) == number){
              return true;
          }
      }
      return false;
    }
    // kiểm tra trong ô 
    private boolean checkBox(int number, int row, int colums){
        int LocalBoxRow = row - row%3;
        int LocalBoxColums = colums - colums%3;
        
        for(int i = LocalBoxRow; i < LocalBoxRow + 3; i++){
            for(int j = LocalBoxColums; j < LocalBoxColums + 3; j++){
                if(getIndexBoard(i, j) == number){
                    return true;
                }
            }      
        }
        return false;
    }
    // kiểm tra toàn bộ
    public boolean checkSudoku(int number, int row, int colums){
        return !checkRow(number, row) 
               && !checkColums(number, colums) 
               && !checkBox(number, row, colums);
    }
    // viết đáp án cho board hiện thời
    private boolean SolveSudoku(){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j< GRID_SIZE; j++){
                if(getIndexBoard(i, j) == 0){
                    for(int numbertotry = 1; numbertotry <= GRID_SIZE; numbertotry++){ 
                        if(checkSudoku(numbertotry, i, j)){  // thử từng số xem có phù hợp k
                            setIndexBoard(i, j, numbertotry);;
                            if(SolveSudoku()){ //đệ quy xem các bước tiếp theo có phù hợp so với số hiện tại không
                                return true;
                            }
                            else{ // nếu không gán lại 0 cho ô
                                setIndexBoard(i, j, 0);
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
    private int countBox(int row, int colums){
        int count = 0;
        int LocalBoxRow = row - row%3;
        int LocalBoxColums = colums - colums%3;
        
        for(int i = LocalBoxRow; i < LocalBoxRow + 3; i++){
            for(int j = LocalBoxColums; j < LocalBoxColums + 3; j++){
                if(getIndexBoard(i, j) != 0){
                    count++;
                }
            }      
        }
        return count;
    }
    // random ô trong board để xóa ngẫu nhiên
    private void randomSudoku(int gioi_han_tong, int gioi_han_o, int gioi_han_so){
        int i = 0;
        int x, y;
        Random random = new Random();
        while(i<gioi_han_tong){
            do{
                x = random.nextInt(9);
                y = random.nextInt(9);
            }while(getIndexBoard(x, y)==0 || countBox(x, y)<gioi_han_o+1 || getIndexSo_dem(getIndexBoard(x, y)-1)>=gioi_han_so);
            setIndexSo_dem(getIndexBoard(x, y)-1, getIndexSo_dem(getIndexBoard(x, y)-1)+1);
            setIndexBoard(x, y, 0);
            i++;
        }
    }
    
}
