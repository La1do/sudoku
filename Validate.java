public class Validate {
    public static int count_validate = 0;
    static Validate validate = new Validate();
    public static boolean check_validate(){
        Create_topic create = new Create_topic();
        create = Board.create_topic;
        count_validate += 1;
        for(int i=0; i<=9; i++){
            for(int j=0; j<=9; j++){
                if(create.getIndexBoard(i, j)!=0){
                    if(create.getIndexBoard(i, j)!=create.getIndexSolve(i, j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
