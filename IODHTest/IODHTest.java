import java.io.File;
import java.io.FileInputStream;

public class IODHTest {

    public static void main(String[] args) throws Throwable {
	test1();
    }

    /* Test for java.io.FileDescriptor.otherParents replacement
    *  - used in FileDescriptor.attach
    *  - called by FileInputStream(File file) initializer
    */
    private static void test1() throws Throwable {
        File file = new File("file.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = fis.readAllBytes();
        System.out.println(new String(bytes));
        fis.close();
    }
}
