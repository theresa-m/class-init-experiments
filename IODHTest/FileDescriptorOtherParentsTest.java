import java.io.Closeable;
import java.util.List;
import java.lang.reflect.Field;
import java.io.FileInputStream;
import java.io.FileDescriptor;

/* Test for java.io.FileDescriptor.otherParents replacement
 *  - used in FileDescriptor.attach
 *  - called by FileInputStream(File file) initializer
 */
public class FileDescriptorOtherParentsTest {
    static FileDescriptor fd;
    static FileInputStream fis;
    static FileInputStream fis2;
    static {
        fd = new FileDescriptor();
        fis = new FileInputStream(fd); // set FileDescriptor.parents
        fis2 = new FileInputStream(fd); // set FileDescriptor.otherParents
    }

    public  static void testJavaIoFileDescriptor() throws Throwable {
        Field otherParentsField = fd.getClass().getDeclaredField("otherParents");
        otherParentsField.setAccessible(true);
        Object otherParentsObject = otherParentsField.get(fd);
        List<Closeable> otherParents = (List<Closeable>)otherParentsObject;

        System.out.println("List size is (should be 0): " + otherParents.size());
    }
}