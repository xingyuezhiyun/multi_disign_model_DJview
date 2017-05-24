/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class HeartTestDrive {
    public static void main(String [] args){
        HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
    }
}
