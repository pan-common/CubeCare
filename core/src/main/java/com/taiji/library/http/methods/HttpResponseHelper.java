package com.taiji.library.http.methods;

import com.google.gson.Gson;
import com.taiji.library.http.entity.Header;
import com.taiji.library.http.entity.Response;
import com.taiji.library.http.entity.ResponseBody;
import com.taiji.library.util.MyUtil;

import java.util.UUID;

public class HttpResponseHelper<T> {

	private Response<T> response;
	
	private Gson gson;
	
	public HttpResponseHelper() {
		gson = new Gson();
	}
	/**
	 * 响应成功
	 * @param t 返回数据实体
	 * @return
	 */
	public String responseSuccess(T t){
		ResponseBody<T> responseBody = new ResponseBody<T>(ResponseBody.SUCCESS,"成功",t);
		Header header = new Header("CULTURE_AND_DATA_CENTER", MyUtil.getGUID(), "0");
		response = new Response<T>(header, responseBody);
		return gson.toJson(response);
	}

	/**
	 * 响应成功
	 * @param t
	 * @return
     */
	public Response<T> getResponse(T t){
		ResponseBody<T> responseBody = new ResponseBody<T>(ResponseBody.SUCCESS,"成功",t);
		Header header = new Header("CULTURE_AND_DATA_CENTER", MyUtil.getGUID(), "0");
		response = new Response<T>(header, responseBody);
		return response;
	}

	/**
	 * 响应失败
	 * @param errorMessage 返回错误信息
	 * @return
	 */
	public String responsefailed(String errorMessage){
		Header header = new Header("CULTURE_AND_DATA_CENTER", MyUtil.getGUID(), "0");
		ResponseBody<T> responseBody = new ResponseBody<T>(ResponseBody.FAILED,errorMessage,null);
		response = new Response<T>(header, responseBody);
		return gson.toJson(response);
	}
	
}
