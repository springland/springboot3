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




