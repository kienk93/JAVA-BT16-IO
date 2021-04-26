package test;
import java.io.*;


public class ReadCSVFile {
    public void read(String filePath){

        try {
            File source = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(source));
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String token : row) {
                    System.out.print(token + "   ");
                }
                System.out.println();
            }
            reader.close();

        } catch (FileNotFoundException e){
            System.err.println("The file cannot be found!");
        } catch (IOException e){
            System.err.println("");
        }
    }


    public static void main(String[] args) {
        ReadCSVFile readFile = new ReadCSVFile();
        readFile.read("countries.csv");
    }
}