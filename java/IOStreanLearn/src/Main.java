import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("word.txt");
        if(file.exists()){
            file.delete();
            System.out.println("文件已删除");
        }else{
            try {
                boolean newFile = file.createNewFile();
                if(newFile)
                    System.out.println("文件创建成功");
                else
                    System.out.println("文件创建失败");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
