多线程之CountDownLatch对象

>在现实生活中有这样的场景，下面回家之后，非常饿，就想立马吃饭，作为单身狗，没有现成的饭吃，要么做饭，要么定外卖，先说煮饭，一般需要两步
1.用点电饭煲煮米饭
2.炒菜
现实中肯定不会有人等米煮好了去炒菜，一般都是先把米煮上，在等他米煮熟的过程中接着去炒菜，等两个都弄好了就可以吃饭了。
用程序实现就相当于开启了两个线程，等两个线程都报告完成了，如何知道两个线程都完成了呐，这时候就用到了CountDownLatch

CountDownLatch 介绍
>1.CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，计数器的值就会减1。
当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。

CountDownLatch执行步骤

>2.构造器中的计数值（count）实际上就是闭锁需要等待的线程数量。这个值只能被设置一次，而且CountDownLatch没有提供任何机制去重新设置这个计数值。

>3.与CountDownLatch的第一次交互是主线程等待其他线程。主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。

>4.其他N个线程必须引用闭锁对象，因为他们需要通知CountDownLatch对象，他们已经完成了各自的任务。这种通知机制是通过 CountDownLatch.countDown()方法来完成的；每调用一次这个方法，在构造函数中初始化的count值就减1。所以当N个线程都调 用了这个方法，count的值等于0，然后主线程就能通过await()方法，恢复执行自己的任务。