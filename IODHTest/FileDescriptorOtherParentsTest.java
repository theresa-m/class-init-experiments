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
        // test before modifications
//        Field otherParentsField = fd.getClass().getDeclaredField("otherParents");
        
        Class fileDescriptorClass = Class.forName("java.io.FileDescriptor");
        Class runtimeHelperClass = Class.forName("java.io.FileDescriptor$RuntimeHelper");

        /* get RuntimeHelper rh field of FileDescriptor object */
        Field runtimeHelperField = fileDescriptorClass.getDeclaredField("rh");
        runtimeHelperField.setAccessible(true);
        Object runtimeHelperObject = runtimeHelperField.get(fd);

        /* get List otherParents of RuntimeHelper object */
        Field otherParentsField = runtimeHelperClass.getDeclaredField("otherParents");
        otherParentsField.setAccessible(true);
        Object otherParentsObject = otherParentsField.get(runtimeHelperObject);

        
        List<Closeable> otherParents = (List<Closeable>)otherParentsObject;

        if (otherParents == null) {
            System.out.println("List should be reset to null");
        } else {
            System.out.println("List was not reset: " + otherParents.size());
        }
    }
}