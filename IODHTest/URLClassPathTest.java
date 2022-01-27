import java.net.URL;
import java.net.URLClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class URLClassPathTest {
    URLClassPathTest() {
        System.out.println("run init");
    }

    static URLClassLoader ucl;
    static {
       // System.out.println("run clinit");
//        try {
//            URL[] urls = new URL[]{
//                    new File("test1.jar").toURI().toURL(),
//                    new File("test2.jar").toURI().toURL()
//            };
//            ucl = new URLClassLoader(urls);
//
//            Class urlClassLoaderClass = Class.forName("java.net.URLClassLoader");
//            Class urlClassPathClass = Class.forName("jdk.internal.loader.URLClassPath");
//            Class runtimeHelperClass = Class.forName("jdk.internal.loader.URLClassPath$RuntimeHelper");
//
//            /* get URLClassPath ucp */
//            Field ucpField = urlClassLoaderClass.getDeclaredField("ucp");
//            ucpField.setAccessible(true);
//            Object ucpObject = ucpField.get(ucl);
//
//            /* get RuntimeHelper rh */
//            Field rhField = urlClassPathClass.getDeclaredField("rh");
//            rhField.setAccessible(true);
//            Object rhObject = rhField.get(ucpObject);
//
//            /* get ArrayList path */
//            Field pathField = runtimeHelperClass.getDeclaredField("path");
//            pathField.setAccessible(true);
//            Object pathObject = pathField.get(rhObject);
//
//            ArrayList pathArray = (ArrayList)pathObject;
//            System.out.println("size is: " + pathArray.size());
//            for (Object o : pathArray) {
//                System.out.println(o.hashCode());
//            }
//        } catch (Throwable e) {
//            System.out.println("Exception while initializing" + e.getMessage());
//            throw new RuntimeException(e.getMessage());
//        }
    }

    /*
     * URLClassPath is created by URLClassLoader
     * URLClassLoader has URLClassPath ucp
     * URLClassPath has RuntimeHelper rh
     * RuntimeHelper has path
     */
    public static void testURLClassPath() throws Throwable {
//        Class urlClassLoaderClass = Class.forName("java.net.URLClassLoader");
//        Class urlClassPathClass = Class.forName("jdk.internal.loader.URLClassPath");
//        Class runtimeHelperClass = Class.forName("jdk.internal.loader.URLClassPath$RuntimeHelper");
//
//        /* get URLClassPath ucp */
//        Field ucpField = urlClassLoaderClass.getDeclaredField("ucp");
//        ucpField.setAccessible(true);
//        Object ucpObject = ucpField.get(ucl);
//
//        /* get RuntimeHelper rh */
//        Field rhField = urlClassPathClass.getDeclaredField("rh");
//        rhField.setAccessible(true);
//        Object rhObject = rhField.get(ucpObject);
//
//        /* get ArrayList path */
//        Field pathField = runtimeHelperClass.getDeclaredField("path");
//        pathField.setAccessible(true);
//        Object pathObject = pathField.get(rhObject);
//
//        ArrayList pathArray = (ArrayList)pathObject;
//        System.out.println("size is: " + pathArray.size());
    }
}