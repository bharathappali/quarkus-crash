package dev.doofenshmirtz.cgroup;

public interface CgroupReader {
    long memoryLimitBytes();
    long memoryUsageBytes();
    String version();
}
