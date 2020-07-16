package com.bin.jmc.samples.stringcontract;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringDemo {

    @Benchmark
    public void stringAdd() {
        String a = "";
        for (int i = 0; i < 10; i++) {
            a += i;
        }
        //System.out.println(a);
    }

    @Benchmark
    public void stringBuildAdd() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(i);
        }
        //System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(StringDemo.class.getSimpleName())
                .output("D:\\benchlogs\\stringbench.log")
                .build();
        new Runner(options).run();
    }
}
