package com.taiji.library.http.download;

/**
 * Created by panho on 2016/10/19.
 */

public class FileLoadEvent {
    /**
     * 文件大小
     */
    long total;
    /**
     * 已下载大小
     */
    long progress;

    public FileLoadEvent(long total, long progress) {
        this.total = total;
        this.progress = progress;
    }

    public FileLoadEvent() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getProgress() {
        return progress;
    }

    public void setProgress(long progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "FileLoadEvent{" +
                "total=" + total +
                ", progress=" + progress +
                '}';
    }
}
