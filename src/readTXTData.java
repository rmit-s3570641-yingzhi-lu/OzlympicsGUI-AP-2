import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class readTXTData {

    public static final int COLUMN_NUM = 5;//the column of the txt file
    static ArrayList<String[]> lineList = new ArrayList<String[]>();// ArrayList used to store the row of txt file


    //read the exact csv file，restore data and return ArrayList
    public static void getTXTData() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/participants.txt"));
        String line;
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
     * A method to seperate data into their own class
     * @return
     * @throws IOException
     */
    public static ArrayList<Participates> seperateData() throws IOException{

        //clean the line list and read again to prevent duplicate data
        lineList.clear();
        getTXTData();

        //From previous Assignment
        ArrayList<Participates> participates=new ArrayList<>();

        //initialize the data form file
        for (int i = 0; i < lineList.size(); i++) {
            if(lineList.get(i)[4].equals("SWIMMER")){
                    participates.add(new Swimmer(lineList.get(i)[0],lineList.get(i)[1],Integer.parseInt(lineList.get(i)[2]),lineList.get(i)[3]));
            }else if(lineList.get(i)[4].equals("CYCLIST")){
                    participates.add(new Cyclist(lineList.get(i)[0],lineList.get(i)[1],Integer.parseInt(lineList.get(i)[2]),lineList.get(i)[3]));
            }else if(lineList.get(i)[4].equals("SPRINTER")){
                    participates.add(new Sprinter(lineList.get(i)[0],lineList.get(i)[1],Integer.parseInt(lineList.get(i)[2]),lineList.get(i)[3]));
            }else if(lineList.get(i)[4].equals("SUPERATHLETE")){
                    participates.add(new superAthlete(lineList.get(i)[0],lineList.get(i)[1],Integer.parseInt(lineList.get(i)[2]),lineList.get(i)[3]));
            }else if(lineList.get(i)[4].equals("OFFICIAL")){
                    participates.add(new Official(lineList.get(i)[0],lineList.get(i)[1],Integer.parseInt(lineList.get(i)[2]),lineList.get(i)[3]));
            }
        }

        return participates;
    }

}


