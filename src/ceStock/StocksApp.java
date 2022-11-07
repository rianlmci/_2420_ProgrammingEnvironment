package ceStock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

// 2 points extra credit if you update Date with a non-deprecated class of the Java API (line 27)

public class StocksApp {

    /**
     * Reads in data from CSV file where key is the date on position keyField,
     * and data is a value of type Double in position valueField.
     *
     * @param filename
     * @param keyField
     * @param valueField
     * @return
     */
    private static ST<Date, Double> readCSV(String filename, int keyField, int valueField) {
        ST<Date, Double> st = new ST<Date, Double>();
        SimpleDateFormat SDFormat = new SimpleDateFormat("yyyy-MM-dd"); //XC Non-Depreciated
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // read in the data from CSV file
        In in = new In(filename);
        in.readLine(); // discard header

        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");

            try {
                Date key = SDFormat.parse(tokens[(keyField)]); // parses the String token as a Date object
                Double val = Double.parseDouble(tokens[valueField]); // parses the String token as a Double
                st.put(key, val);
            }
            catch(ParseException e) {
                StdOut.println("A problem occurred parsing data from " + filename);
                e.getStackTrace();
            }
        }
        return st;
    }

    // = = = = = = = = TEST CLIENT = = = = = = = = //

    public static void main(String[] args) {
        String filename = "src/ceStock/resource/AMZN.csv";
        int keyField = 0;
        int valField = 4;

        ST<Date, Double> st = readCSV(filename, keyField, valField);
        StdOut.println("Number of elements: " + st.size());
        StdOut.print("\n");
        /*A*/StdOut.printf("A) Oldest closing price: %tY-%tm-%td $%.2f.\n",
                st.min(), st.min(), st.min(), st.get(st.min()));
        /*B*/ StdOut.printf("B) Newest closing price: %tY-%tm-%td $%.2f.\n",
                st.max(), st.max(), st.max(), st.get(st.max()));

        /*C*/StdOut.printf("C) The closing price "
                + (st.get(st.max()) - st.get(st.min()) > 0 ? "increased" : "decreased")
                + " by $%.2f.\n\n", Math.abs((st.get(st.max()) - st.get(st.min()))));

        /*D*/Date date1;
        /*E*/Date date2;
        /*F* : "Print the difference between the closing prices of D and E"/
        /*G*/Date date3;
        /*H*/Date date4;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-31");
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-10");

            StdOut.printf("D) Closing price from 08/31/18: $%.2f.\n", st.get(date1));
            StdOut.printf("E) Closing price from 03/10/20: $%.2f.\n", st.get(date2));
//			StdOut.printf("F) The closing price decreased by $%.2f.\n\n",
//					(st.get(date1) - st.get(date2)));

            StdOut.printf("F) The closing price "
                    + (st.get(date1) - st.get(date2) < 0 ? "increased" : "decreased")
                    + " by $%.2f.\n\n", Math.abs((st.get(date1) - st.get(date2))));

            date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01");
            StdOut.printf("G) First available closing price in 2019: %tm/%td/%tY $%.2f.\n",
                    st.ceiling(date3), st.ceiling(date3), st.ceiling(date3), st.get(st.ceiling(date3)));

            date4 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-31");
            StdOut.printf("H) Last available closing price in 2020: %tm/%td/%tY $%.2f.\n",
                    st.floor(date4), st.floor(date4), st.floor(date4), st.get(st.floor(date4)));

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
