import java.io.*;


public class WriterReader {

    String path = "rank";

    WriterReader() {
        try {
            new File("rank").createNewFile();
        } catch (IOException e) {

        }
    }

    public String readFile() {

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();

        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (stringBuffer != null) {

            return stringBuffer.toString();
        }
        return null;


    }


    public void writeFile(String name, int k, int time) {

        StringBuffer stringBuffer = new StringBuffer();

        if (readFile() != null) {
            stringBuffer.append(readFile());
            //System.out.println(stringBuffer.toString());
        }

        stringBuffer.append(name + " " + k + "x" + k + " " + time / 60 + " " + time % 60 + " " + (int) (10 * ((double) (k * k) / (double) time)) + "\n");

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

