package com.taiji.library.http.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 描述：Retrofit文件下载接口
 * 创建人： panho
 * 创建时间： 2016-11-22
 */
public interface FileService {

    /**
     * 下载文件
     * @param fileName
     * @return
     */
    @GET("{fileName}")
    Call<ResponseBody> loadFile(@Path("fileName")String fileName);

}
