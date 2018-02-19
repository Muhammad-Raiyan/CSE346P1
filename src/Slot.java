import java.util.Random;

public class Slot{
    private double p;
    private Random r;
    Slot(double p){
        this.p = p;
        r = new Random();
    }
    boolean simulateC(){
        return simulateA() || simulateB();
    }
    boolean simulateA(){
        double input1 = r.nextDouble();
        double input2 = r.nextDouble();
        return (input1 <= p) || (input2 <= p);
    }
    boolean simulateB(){
        double input3 = r.nextDouble();
        double input4 = r.nextDouble();
        return (input3 <= p) || (input4 <= p);
    }
}