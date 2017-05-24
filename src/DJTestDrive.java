/**
 * Created by Administrator on 2017/5/21 0021.
 */
public class DJTestDrive {
    public static void main(String[] args){
        BeatModelInterface model = new BeatModel();
        ControllerInterface controllerInterface = new BeatController(model);
    }
}
