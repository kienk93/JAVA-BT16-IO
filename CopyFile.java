import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class CopyFile {
    public void copy(String source, String target){

        try {
            File sourceFile = new File(source);
            File targetFile = new File(target);

            if (!sourceFile.exists()){
                throw new FileNotFoundException();
            }

            if (targetFile.exists()){
                throw new FileAlreadyExistsException(target);
            }

            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));

            String line = "";
            while ((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();

        } catch (FileNotFoundException e){
            System.err.println("The source file doesn't exist!");
        } catch (FileAlreadyExistsException e){
            System.err.println("The target file already exists");
        } catch (IOException e){
            System.err.println("Error in the source file or the target file");
        }
    }

    public static void main(String[] args) {
        String source = "source.txt";
        String target = "target.txt";

        CopyFile test = new CopyFile();
        test.copy(source, target);
    }
}
