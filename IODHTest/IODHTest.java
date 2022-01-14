import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

/**
 * Running test:
 * - Make sure FileDescriptorOtherParentsTest is initialized at build time w/  --initiailize-at-build-time
 * - Add reflection configuration JSON file to allow FileDescriptor fields to be accesed reflectively. This needs
 * to be done manually since automatic detection will reduce the reflective call to a contant. See
 * https://www.graalvm.org/reference-manual/native-image/Reflection/
 *

 --add-opens=java.base/java.io=ALL-UNNAMED \

  /usr/bin/python3 ~/github/mx/mx.py native-image \
            -cp ~/github/class-init-experiments/IODHTest \
           --initialize-at-build-time=FileDescriptorOtherParentsTest \
           -H:ReflectionConfigurationFiles=/Users/theresamammarella/github/class-init-experiments/IODHTest/reflectconfig.json \
           IODHTest
 */
public class IODHTest {

    public static void main(String[] args) throws Throwable {
        FileDescriptorOtherParentsTest.testJavaIoFileDescriptor();

        //testJavaNetURLClassLoader();
        //testJavaUtilMaps();
    }

    // TODO relation to URLClassPath
//    private static void testJavaNetURLClassLoader() throws Throwable {
//        URL[] urls = new URL[]{
//                new File("test1.jar").toURI().toURL(),
//                new File("test2.jar").toURI().toURL()
//        };
//
//        URLClassLoader urlcl = new URLClassLoader(urls);
//        URL url1 = urlcl.findResource("test1.txt");
//        URL url2 = urlcl.findResource("test2.txt");
//
//        if (url1 == null && url2 == null) {
//            System.out.println("FAIL: urls are null");
//        } else {
//            System.out.println(url1.toString());
//            System.out.println(url2.toString());
//        }
//    }

    private static void testJavaUtilMaps() {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 0);
        System.out.println("HashMap key size: " + hm.keySet().size());
        System.out.println("HashMap values size: " + hm.values().size());
    }
}
