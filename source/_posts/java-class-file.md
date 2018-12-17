---
title: java字节码速查笔记
date: 2018-01-27 20:08:44
tags: java
---
## 执行原理
java文件到通过编译器编译成java字节码文件（也就是.class文件），这个过程是java编译过程；而我们的java虚拟机执行的就是字节码文件。不论该字节码文件来自何方，由哪种编译器编译，甚至是手写字节码文件，只要符合java虚拟机的规范，那么它就能够执行该字节码文件

## 字节码学习好文
1. [http://blog.csdn.net/shenhonglei1234/article/details/54861958]() 
 IDEA配置快速查看java字节码
2. [http://www.jianshu.com/p/252f381a6bc4]()  字节码基础学习笔记
3. [http://ifeve.com/javacode2bytecode/]()   比较详细



## 查看字节码 (以HelloWorld文件为实例)
1.  javac –verbose查看运行类是加载了那些jar文件
`javac –verbose HelloWorld.java`
可以看到虚拟机编译时做了那些事情……
2.  j`ava –verbose HelloWorld`
可以看到虚拟机运行一个程序时加载的jar包
更多内容查看`javac –help`命令
3.  javap查看字节码
首先使用javap –help可以查看到各种命令，各个命令什么作用，可以自己运行试试……
这里只测试`javap –c`和`javap –verbose`
`javap –c HelloWorld` 可以查看字节码，从中可以得到各种变量的信息等等
但是`javap –verbose`可以看到更加清楚的信息

### 简单的执行原理

- `iload_1 ` 整形压栈 同理
- `float_1`  是浮点型压栈
- `if_icmple 7` 如何栈顶参数1<=2的值 则调到第7行
- 被final修饰的变量我们称之为常量，在类文件中我们标识为ACC_FINAL。
- 静态变量的标志 `flags: ACC_PUBLIC, ACC_STATIC`

