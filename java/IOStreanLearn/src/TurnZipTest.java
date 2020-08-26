import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 在zip()方法中实现用ZipOutputStream类对文件进行压缩
 * 相应的解压在ZipTest()类里
 */
public class TurnZipTest {
    private void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(out,inputFile,"");
        System.out.println("压缩中...");
        out.close();
    }
    private void zip(ZipOutputStream out, File f, String base) throws IOException {
        boolean isDirectory = false;
        if(f.isDirectory()){
            isDirectory = true;
            File[] fl = f.listFiles();
            if(base.length()!=0){
                out.putNextEntry(new ZipEntry(base+"/"));       //写入此目录的条目(entry)
            }
            for(int i=0;i<fl.length;i++){
                zip(out, fl[i], base+fl[i]);
            }
        }else{
            if(!isDirectory)
                base = f.getName();
            out.putNextEntry(new ZipEntry(base));                       //创建新的进入点
            FileInputStream in = new FileInputStream(f);
            int b;                                                      //int类型只是起到一个结束的作用
            System.out.println(base);
            while((b=in.read())!=-1){
                out.write(b);
            }
            in.close();
        }
    }

    public static void main(String[] args) {
        TurnZipTest book = new TurnZipTest();
        try {
            //这里要写绝对路径，写相对路径会报错
            book.zip("/home/admin/Documents/hello.zip", new File("word.txt"));
            System.out.println("压缩完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
