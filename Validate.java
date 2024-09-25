public class Validate {
    public static int count_validate = 0;
    static Validate validate = new Validate();
    public static boolean check_validate(int[][] board, int[][] solve){
        count_validate += 1;
        for(int i=0; i<=9; i++){
            for(int j=0; j<=9; j++){
                if(board[i][j]!=0){
                    if(board[i][j]!=solve[i][j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
