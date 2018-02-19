import java.util.Random;

public class Main {
    static class Slot{
        double p;
        Random r;
        Slot(double p){
            this.p = p;
             r = new Random();
        }

        boolean simulate(){
            double input1 = r.nextDouble();
            double input2 = r.nextDouble();
            double input3 = r.nextDouble();
            double input4 = r.nextDouble();
            return (input1 <= p) || (input2 <= p) || (input3 <= p) || (input4 <= p);
        }
    }
    public static void main(String[] args) {
        int NUMBER_OF_SIMULATIONS = 100;

        for(double p = 0.1; p < 1.0; p+=0.01){
            Slot s = new Slot(p);
            int throughput = 0;
            for(int i=0; i< NUMBER_OF_SIMULATIONS; i++){
                if(s.simulate()) throughput++;
            }
            System.out.println("P: " +  (double)throughput/NUMBER_OF_SIMULATIONS);

        }

    }
}
