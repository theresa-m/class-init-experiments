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
 --initialize-at-build-time=FileDescriptorOtherParentsTest \
 -H:ReflectionConfigurationFiles=/Users/theresamammarella/github/class-init-experiments/IODHTest/reflectconfig.json \

  /usr/bin/python3 ~/github/mx/mx.py native-image \
        --initialize-at-build-time=URLClassPathTest \
        -H:ReflectionConfigurationFiles=/Users/theresamammarella/github/class-init-experiments/IODHTest/reflectconfig.json \
            -cp ~/github/class-init-experiments/IODHTest \
            --add-opens=java.base/java.net=ALL-UNNAMED \
           IODHTest
 */
public class IODHTest {
    public static void main(String[] args) throws Throwable {
        URLClassPathTest mer = new URLClassPathTest();
        //FileDescriptorOtherParentsTest.testJavaIoFileDescriptor();

        //URLClassPathTest.testURLClassPath();
        
        //testJavaUtilMaps();
    }

    private static void testJavaUtilMaps() {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 0);
        System.out.println("HashMap key size: " + hm.keySet().size());
        System.out.println("HashMap values size: " + hm.values().size());
    }
}
