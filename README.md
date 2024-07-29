# spotless-toolchains

A basic example to illustrate lack of [Java Toolchain](https://docs.gradle.org/7.6.4/userguide/toolchains.html]Java) 
support in the [Spotless Gradle Plugin](https://github.com/diffplug/spotless).

## Notes 

- [Java21Example.java](src%2Fmain%2Fjava%2Fcom%2Fshutch%2Fspotless%2FJava21Example.java) contains Java 21 
features.
- [build.gradle](build.gradle) configures a Java 21 toolchain. 

## Steps to recreate


- Ensure that you are running Java 17 locally

If using [sdkman](https://sdkman.io/)

```shell
sdk use java 17.0.11-amzn
```

- Test that the project compiles (This proves that compilation is using a toolchain-provided Javva 21 JDK)

```shell
 ./gradlew clean compileJava
 ```

- execute the spotlessCheck task

```shell
 ./gradlew clean spotlessCheck
 ```

You will see an error similar to:

```shell
Step 'removeUnusedImports' found problem in 'src/main/java/com/shutch/spotless/Java21Example.java':
8:33: error: ')' expected
```

Checking the stack trace shows that Java 17 and not the toolchain Java 21 is being used

```java
at java.base@17.0.11/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at java.base@17.0.11/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
at java.base@17.0.11/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)

```