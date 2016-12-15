package javamultithread.SingleThreadExecution;

/**
 * Created by stefan on 2016/1/14.
 */
public class GateThread extends Thread {

    private Gate gate = null;
    private String name = "nobody";
    private String address = "nowhere";

    public GateThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(name + " BEGIN");
            gate.pass(name,address);
        }
    }
}
