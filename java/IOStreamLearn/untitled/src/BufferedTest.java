import java.io.*;

/**
 * 通过BufferedReader和BufferedWriter测试文件
 * 首先要使用FileWriter和FileReader
 */
public class BufferedTest {
    public static void main(String[] args) {
        String content[] = {"好久不见","最近好吗","常联系"};
        File file = new File("word.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bufw = new BufferedWriter(fw);
            for(String line : content){
                bufw.write(line);
                bufw.newLine();                         //以单行的形式输入
            }
            bufw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            String line = null;
            int i = 0;
            while((line = bufr.readLine()) != null){    //以单行的形式读出
                i++;
                System.out.println("第"+i+"行："+line);
            }
            bufr.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
