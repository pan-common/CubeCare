package com.taiji.cubecare.patient.data;

import android.content.Context;

import com.taiji.cubecare.patient.data.entity.Patient;
import com.taiji.cubecare.patient.data.remote.PatientRemoteDataSource;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Response;

import rx.Observable;

/**
 * Created by panho on 2017-9-3.
 */

public class PatientRepository implements PatientDataSource{

    private static PatientRepository mInstance;

    private PatientRemoteDataSource mPatientRemoteDataSource;

    private PatientRepository(Context context){
        mPatientRemoteDataSource = PatientRemoteDataSource.getmInstance(context);
    }

    public static PatientRepository getmInstance(Context context){
        if(mInstance==null){
            synchronized (PatientRepository.class){
                mInstance = new PatientRepository(context);
            }
        }
        return mInstance;
    }

    @Override
    public Observable<Response<PageInfo<Patient>>> getPatients(String area_id, int pageNum, int pageSize) {
        return mPatientRemoteDataSource.getPatients(area_id,pageNum,pageSize);
    }
}
