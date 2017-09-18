package com.taiji.cubecare.patient.data.remote;

import com.taiji.cubecare.patient.data.entity.Patient;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by panho on 2017-9-4.
 */

public interface PatientService {

    @GET("patient/getPatients")
    Observable<Response<PageInfo<Patient>>> getPatients(
            @Query("area_id")String area_id,
            @Query("pageNum")int pageNum,
            @Query("pageSize")int pageSize);

}
