import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DecimalFormat df2 = new DecimalFormat(".##");
        PrintWriter pw = new PrintWriter(new File("data.csv"));
        String ColumnNamesList = "P,A,C\n";
        pw.write(ColumnNamesList);
        int NUMBER_OF_SIMULATIONS = 10000;
        for(double p = 0.1; p < 1.0; p+=0.01){
            Slot s = new Slot(p);
            int throughputC = 0;
            int throughputA = 0;

            for(int i=0; i< NUMBER_OF_SIMULATIONS; i++){
                if(s.simulateC()) throughputC++;
            }

            for(int i=0; i< NUMBER_OF_SIMULATIONS; i++){
                if(s.simulateA()) throughputA++;
            }
           pw.write(df2.format(p) + "," + (double)throughputA/NUMBER_OF_SIMULATIONS
                   + "," + (double)throughputC/NUMBER_OF_SIMULATIONS + "\n");
        }
        pw.close();
        System.out.println("Finished Simulation");
    }
}
