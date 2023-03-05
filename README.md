h2 console does not work with webflux

https://stackoverflow.com/questions/52949088/h2-db-not-accessible-at-localhost8080-h2-console-when-using-webflux

Go with Spring web for now


Build GraavlVM native image

https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html#native-image.testing

install gcc

1) Install GraavlVM
https://www.graalvm.org/22.1/docs/getting-started/windows/

config project to use graavlvm java


set PATH to use graavlvm  , it is openjdk  

set env GRAALVM_HOME=/opt/graalvm-ce-java17-22.3.1
$ java -version
openjdk version "17.0.6" 2023-01-17
OpenJDK Runtime Environment GraalVM CE 22.3.1 (build 17.0.6+10-jvmci-22.3-b13)
OpenJDK 64-Bit Server VM GraalVM CE 22.3.1 (build 17.0.6+10-jvmci-22.3-b13, mixe
d mode, sharing)


2) create user group to run graavlvm 
   groupadd graalvm-users
   chgrp -R graalvm-users /path/to/graalvm
    chmod -R g+x /path/to/graalvm/bin

2) Install docker

3) run maven command   mvn -Pnative native:compile


Need to install
Tools/Utilities:

Native Image – a technology to compile an application ahead-of-time into a native executable
LLVM toolchain – a set of tools and APIs for compiling native programs to bitcode that can be executed with on the GraalVM runtime

Check out https://www.graalvm.org/latest/docs/getting-started/linux/

After numerious trails finally I got
-rwxr-xr-x 1 root root   151049744 Mar  5 08:57 springboot3
-rw-r--r-- 1 root root    47007749 Mar  5 08:55 springboot3-0.0.1-SNAPSHOT.jar
-rw-r--r-- 1 root root      232739 Mar  5 08:55 springboot3-0.0.1-SNAPSHOT.jar.original


The springboot3 is the native image

However when I run it I got the below
***************************
APPLICATION FAILED TO START
***************************

Description:

Liquibase failed to start because no changelog could be found at 'classpath:/db/changelog.yml'.

Action:

Make sure a Liquibase changelog is present at the configured path.


Need to put directions to make GraalVM to be aware of the liquibase

Let me do a walkaround to turn it off for now



JVM Run
tion$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2023-03-05T09:19:52.064-05:00  INFO 10659 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-03-05T09:19:52.070-05:00  INFO 10659 --- [           main] c.e.s.Springboot3demoApplication         : Started Springboot3demoApplication in 2.411 seconds (process running for 2.673)

Native Run

3demoApplication         : Started Springboot3demoApplication in 0.082 seconds (process running for 0.085)

Seems I should just leverage https://www.graalvm.org/latest/docs/getting-started/container-images/ to do a two layers build








