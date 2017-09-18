package com.taiji.cubecare.patient.data;

import com.taiji.cubecare.patient.data.entity.Patient;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Request;
import com.taiji.library.http.entity.Response;

import java.util.List;

import rx.Observable;

/**
 * Created by panho on 2017-9-3.
 */

public interface PatientDataSource {
    /**
     * 获取患者列表
     * @param
     * @return
     */
    Observable<Response<PageInfo<Patient>>> getPatients(
            String area_id,
            int pageNum,
            int pageSize);


}
