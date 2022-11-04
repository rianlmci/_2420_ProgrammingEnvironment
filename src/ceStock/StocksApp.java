package ceStock;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StocksApp {
    //2 points XC if you update date with a non deprecated class of the java API
    /**
     * Readsin data from CSV file where key is on position keyfield,
     * and data is the value of type doule in position valuefield
     *
     * @param file
     * @param keyField
     * @param valueField
     */
    private ST<Date, Double> readCSV(String file, int keyField, int valueField) {
        ST newST = new ST<Date, Double>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        //read in the data from CSV file
        In in = new In(file);
        in.readLine(); //skips header

        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            try {
                Date key = formatter.parse(tokens[keyField]);
                Double val = Double.parseDouble(tokens[valueField]);
                newST.put(key, val);
            }
            catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return newST;
    }
    // = = = = = TEST CLIENT = = = = = //
    public static void main(String args[]){
        String filename = "src/ceStock/resource/AMZN.csv";
        int keyField = 1;
        int valueField = 4;
        //ST<Date,Double> st = readCSV
    }
}
