/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class HeartController implements ControllerInterface {
    HeartModelInterface model;
    DJview view;
    public HeartController(HeartModelInterface model){
        this.model = model;
        view = new DJview(this,new HeartAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void increaseBPM() {

    }

    @Override
    public void decreaseBPM() {

    }

    @Override
    public void setBPM(int bpm) {

    }
}
