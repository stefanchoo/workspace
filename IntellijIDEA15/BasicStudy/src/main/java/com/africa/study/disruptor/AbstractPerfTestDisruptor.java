package com.africa.study.disruptor;

/**
 * @author zhuhusheng
 * @date 2016/9/12
 */
public abstract class AbstractPerfTestDisruptor {
    public static final int RUNS = 7;

    protected void testImplementations()
            throws Exception {
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (getRequiredProcessorCount() > availableProcessors) {
            System.out.print("*** Warning ***: your system has insufficient processors to execute the test efficiently. ");
            System.out.println("Processors required = " + getRequiredProcessorCount() + " available = " + availableProcessors);
        }

        long[] disruptorOps = new long[RUNS];

        System.out.println("Starting Disruptor tests");
        for (int i = 0; i < RUNS; i++) {
            System.gc();
            disruptorOps[i] = runDisruptorPass();
            System.out.format("Run %d, Disruptor=%,d ops/sec%n", i, disruptorOps[i]);
        }
    }

    public static void printResults(final String className, final long[] disruptorOps, final long[] queueOps) {
        for (int i = 0; i < RUNS; i++) {
            System.out.format("%s run %d: BlockingQueue=%,d Disruptor=%,d ops/sec\n",
                    className, i, queueOps[i], disruptorOps[i]);
        }
    }

    protected abstract int getRequiredProcessorCount();

    protected abstract long runDisruptorPass() throws Exception;
}
