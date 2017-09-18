package com.taiji.library.http.methods;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.taiji.library.http.entity.Request;

public class HttpRequestHelper<T>{

	private Gson gson;

	private Request<T> request = null;

	public HttpRequestHelper(){
		gson = new Gson();
	}

	public void fromJson(String json){
		request = gson.fromJson(json, new TypeToken<Request<T>>(){}.getType());
	}

	public T getParameter(){
		return request.getRequestBody().getParams();
	}

}
