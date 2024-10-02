public class Validate {
    public static int count_validate = 0;
    static Validate validate = new Validate();
    public static boolean check_validate(){
        count_validate += 1;
        for(int i=0; i<=9; i++){
            for(int j=0; j<=9; j++){
                if(Create_topic.topic.getIndexBoard(i, j)!=0){
                    if(Create_topic.topic.getIndexBoard(i, j)!=Create_topic.topic.getIndexSolve(i, j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
