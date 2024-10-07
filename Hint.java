import java.util.Random;
public class Hint {
    public static int[]toa_do_hint = new int[2];
    public static int count_hint = 0;
    public static void give_hint(){
        Create_topic create = new Create_topic();
        create = Board.create_topic;
        Random random = new Random();
        do{
            toa_do_hint[0] = random.nextInt(9);
            toa_do_hint[1] = random.nextInt(9);
        }while(create.getIndexBoard(toa_do_hint[0], toa_do_hint[1])!=0);
        create.setIndexBoard(toa_do_hint[0], toa_do_hint[1], create.getIndexSolve(toa_do_hint[0], toa_do_hint[1]));
        count_hint += 1;
    }
}
