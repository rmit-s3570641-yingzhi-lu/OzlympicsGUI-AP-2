import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
 * readTXTData Class
 *
 * This class is used to read data from csv data file
 *
 * Created by Ningqi Lu on 3/27/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */

public class readTXTData {

    public static final int COLUMN_NUM = 5;//the column of the csv file
    static ArrayList<String[]> lineList = new ArrayList<String[]>();// ArrayList used to store the row of txt file


    //read the exact csv file，restore data and return ArrayList
    public static void getTXTData() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("participants.txt"));
        String line = "";
        // Read a single line from the file until there are no more lines to read
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ","); // using , to despite the content
            String[] currCol = new String[COLUMN_NUM]; // Each currCol has 5 fields, so we need room for the 4 tokens.
            for (int i = 0; i < COLUMN_NUM; i++) { // For each token in the line that we've read:
                //First to determine whether the data to be read, to prevent overflow
                if (st.hasMoreTokens()) {
                    currCol[i] = st.nextToken();
                    //System.out.print(currCol[i]);
                }
            }
            lineList.add(currCol);
            //System.out.println();
        }
        br.close();
    }

    /**
     * getter and setter of ArrayList lineList
     * @return lineList
     * @throws IOException
     */
    public static ArrayList<String[]> getLineList() throws IOException {
        lineList.clear();
        getTXTData();
        return lineList;
    }

}


