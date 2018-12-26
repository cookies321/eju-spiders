import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/19 20:22
 * @Description:
 */
public class JNALianjia {

    public interface CLibrary extends Library {
        /*//调用系统自带的动态链接库
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);
        void printf(String format, Object... args);*/

        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("SouFunSec", CLibrary.class);

        String getSec(String str);
    }

    public String getSec(String str){
        return CLibrary.INSTANCE.getSec(str);
    }


    public static void main(String[] args) {
        JNALianjia jnaLianjia = new JNALianjia();
        jnaLianjia.getSec(args[0]);
    }





}
