import java.util.Random;
public class Hint {
    public static int[]toa_do_hint = new int[2];
    public static int count_hint = 0;
    static Hint hint = new Hint();
    public static void give_hint(){
        Random random = new Random();
        do{
            toa_do_hint[0] = random.nextInt(9);
            toa_do_hint[1] = random.nextInt(9);
        }while(Create_topic.topic.board[toa_do_hint[0]][toa_do_hint[1]]==0);
        Create_topic.topic.board[toa_do_hint[0]][toa_do_hint[1]] = Create_topic.topic.solve[toa_do_hint[0]][toa_do_hint[1]];
        count_hint += 1;
    }
}
