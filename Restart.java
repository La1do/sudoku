public class Restart {
    public static void call_restart(){
        Create_topic.topic.setBoard(Create_topic.topic.getFirst_board());
        Hint.hint.count_hint = 0;
        Validate.validate.count_validate = 0;
        Create_topic.topic.setSo_dem(Create_topic.topic.getFirst_so_dem());
    }
}
