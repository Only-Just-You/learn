import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * 通过ZipInputStream类将生成的压缩文件解压
 * 到指定的文件夹中
 */
public class ZipTest {
    public static void main(String[] args) {
        File file = new File("/home/admin/Documents/hello.zip");
        ZipInputStream zin;
        try {
            ZipFile zipFile = new ZipFile(file);
            zin = new ZipInputStream(new FileInputStream(file));
//            ZipEntry entry = zin.getNextEntry();
            //如果该压缩文件只是压缩哟个文件而不是文件夹，一开始是不需要读取下一个ZipEntry的。
            ZipEntry entry;
            while(((entry = zin.getNextEntry()) != null) && !entry.isDirectory()){
                //这里要使用绝对路径
                File tmp = new File("/home/admin/Documents/" + entry.getName());
                if(!tmp.exists()){
                    tmp.getParentFile().mkdirs();
                    OutputStream os = new FileOutputStream(tmp);
                    InputStream in = zipFile.getInputStream(entry);
                    int count = 0;
                    while((count = in.read()) != -1){
                        os.write(count);
                    }
                    os.close();
                    in.close();
                }
                zin.closeEntry();
                System.out.println(entry.getName()+"解压成功");
            }
            zin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
