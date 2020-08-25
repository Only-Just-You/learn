import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**用FileOutputStream写入
 * 通过FileInputStream读出
 */
public class FileIOTest {
    public static void main(String[] args) {
        File file = new File("word.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);//也可以使用FileWriter
            byte buy[] = "我是你爸爸，哈哈哈哈".getBytes();
            out.write(buy);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream in = new FileInputStream(file);//也可以使用FileReader
            byte byt[] = new byte[1024];
            int len = in.read(byt);
            System.out.println("文件中的内容是：" + new String(byt,0,len));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
