package com.shujun.bao.androidthreaddemo.countdownlatch;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    //声明线程池
    private static ExecutorService executor = Executors.newFixedThreadPool(2);
    //两个步骤1.煮米饭 2.炒菜
    private static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        //获取数组
        int[] data = query();
        //两次线程去操作逻辑
        for (int i = 0; i < data.length; i++) {
            executor.execute(new CookRice(latch));

        }
        //保证所有线程执行完毕，再执行下面程序
        latch.await();
        executor.shutdown();
        //获取处理过的数据
        System.out.println("取到数字" + Arrays.toString(data));
    }

    static class CookRice implements Runnable {
        private final CountDownLatch latch;

        public CookRice(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5 *1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(Thread.currentThread().getName() + "结束");
            latch.countDown();
        }
    }

    private static int[] query() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
}

//    await(long timeout, TimeUnit unit)
//
//    await(long timeout, TimeUnit unit)：表示等待最长时间。

//package com.example.demo.three.untils.countdownlouch;
//
//        import java.util.concurrent.CountDownLatch;
//        import java.util.concurrent.TimeUnit;
//public class CountDownLunchTest2 {
//    public static void main(String[] args) throws InterruptedException {
//        //new CountDownLatch(0)当为0时，latch.await()无效果
//        CountDownLatch latch = new CountDownLatch(1);
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    latch.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//        /**
//         * 最多等待10秒
//         * 1.如果10秒内，没有countDown为0，10秒后发行
//         * 2.如果10秒内，countDown为0，立刻发行，不用等待10秒
//         */
//        latch.await(10, TimeUnit.SECONDS);
//        System.out.println("==========");
//    }
//}
//}
