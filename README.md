# class-init-experiments

# Getting hotspot information on class memory

## Klass size from Xlog
- Klass: Represents object metadata information, a VM level representation of a Java class
- Wildcards aren't being recognized on my machine (`-Xlog:class*=debug)
- Number of Klass bytes: `-Xlog:class+load=debug`

```
[0.042s][info ][class,load] SingleStatic source: file:/Users/theresamammarella/local-test/class-init-size/
[0.042s][debug][class,load]  klass: 0x0000000800c00a08 super: 0x0000000800000d68 loader: [loader data: 0x00006000002a0dc0 for instance a 'jdk/internal/loader/ClassLoaders$AppClassLoader'{0x00000007ffb56908}] bytes: 288 checksum: 49d50d31

```
### Results

```
java -version
openjdk version "17" 2021-09-14
OpenJDK Runtime Environment Temurin-17+35 (build 17+35)
OpenJDK 64-Bit Server VM Temurin-17+35 (build 17+35, mixed mode, sharing)
```

1-single-static: klass bytes = 288

2-two-static: klass bytes = 324 _(36 extra from 1)_

3-three-static: klass bytes = 369 _(45 extra from 2)_

4-two-static-two-clinit
  TwoStaticTwoClinit klass bytes = 396
  TwoStaticTwoClinit$Helper klass bytes = 472
  
  
## JCMD class stats
- https://github.com/adinn/fosdem2018
- Run jvm with `-XX:+UnlockDiagnosticVMOptions`
- `jcmd <pid> GC.class_stats > stats.txt` this option is not available on Java 17
- `jcmd <pid> GC.class_histogram` shows instance memory that has been allocated for each class
