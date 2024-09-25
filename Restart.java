public class Restart {
    public static void call_restart(){
        Create_topic.topic.board = Create_topic.topic.first_board;
        Hint.hint.count_hint = 0;
        Validate.validate.count_validate = 0;
        Create_topic.topic.so_dem = Create_topic.topic.first_so_dem;
    }
}
