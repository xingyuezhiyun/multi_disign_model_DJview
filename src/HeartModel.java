import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class HeartModel implements HeartModelInterface,Runnable {
    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    int time = 1000;
    int bpm = 90;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;
    public HeartModel(){
        thread = new Thread(this);
        thread.start();
    }
    public void run(){
        int lastrate = -1;
        for (;;){
            int change = random.nextInt(10);
            if (random.nextInt(2)==0){
                change = 0 - change;
            }
            int rate = 6000/(time + change);
            if (rate < 120 && rate > 50){
                time += change;
                notifyBeatObservers();
                if (rate != lastrate){
                    lastrate = rate;
                    notifyBeatObservers();
                }
            }
            try {
                Thread.sleep(time);
            }catch (Exception e){

            }
        }
    }
    public void notifyBeatObservers(){
        for (int i = 0;i < beatObservers.size(); i++){
            BeatObserver observer = (BeatObserver) beatObservers.get(i);
            observer.updateBeat();
        }
    }
    public void notifyBPMObservers(){
        for (int i = 0;i < beatObservers.size(); i++){
            BPMObserver observer = (BPMObserver) beatObservers.get(i);
            observer.updateBPM();
        }
    }
    @Override
    public int getHeartRate() {
        return 60000/time;
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if (i>=0){
            beatObservers.remove(i);
        }
    }

    @Override
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i>=0){
            bpmObservers.remove(i);
        }
    }
}
