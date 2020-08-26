import java.io.*;

/**
 * 分别通过DataOutputStram类的writeUTF(),writeChars(),writeBytes()方式写入，只有
 * writeUTF()方法读取比较容易，使用writeChars()和writeBytes()会出现乱码
 */
public class DataStreamTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fs = new FileOutputStream("word.txt");
            DataOutputStream ds = new DataOutputStream(fs);
            ds.writeUTF("使用writeUTF()方法写入；");
            ds.writeChars("使用writeChars()方法写入；");
            ds.writeBytes("使用writeBytes()方法写入；");
            ds.close();

            FileInputStream fis = new FileInputStream("word.txt");
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
