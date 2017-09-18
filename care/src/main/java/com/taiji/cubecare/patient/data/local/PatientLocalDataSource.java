package com.taiji.cubecare.patient.data.local;

import com.taiji.cubecare.patient.data.PatientDataSource;
import com.taiji.cubecare.patient.data.entity.Patient;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Request;
import com.taiji.library.http.entity.Response;

import java.util.List;

import rx.Observable;

/**
 * Created by panho on 2017-9-4.
 */

public class PatientLocalDataSource implements PatientDataSource{

    @Override
    public Observable<Response<PageInfo<Patient>>> getPatients(String area_id, int pageNum, int pageSize) {
        return null;
    }
}
