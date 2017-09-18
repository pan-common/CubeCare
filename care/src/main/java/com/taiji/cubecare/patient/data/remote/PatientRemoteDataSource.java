package com.taiji.cubecare.patient.data.remote;

import android.content.Context;

import com.taiji.cubecare.patient.data.PatientDataSource;
import com.taiji.cubecare.patient.data.entity.Patient;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Request;
import com.taiji.library.http.entity.Response;
import com.taiji.library.http.methods.HttpMethod;
import com.taiji.library.util.L;

import rx.Observable;

/**
 * Created by panho on 2017-9-4.
 */

public class PatientRemoteDataSource implements PatientDataSource{

    private static PatientRemoteDataSource mInstance;

    private Context mContext;

    private PatientService mPatientService;

    private PatientRemoteDataSource(Context context){
        this.mContext = context;
        try {
            mPatientService = HttpMethod.getInstance().getRetrofit(context).create(PatientService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PatientRemoteDataSource getmInstance(Context context){
        if(mInstance == null){
            synchronized (PatientRemoteDataSource.class) {
                mInstance = new PatientRemoteDataSource(context);
            }
        }
        return mInstance;
    }

    @Override
    public Observable<Response<PageInfo<Patient>>> getPatients(String area_id, int pageNum, int pageSize) {
        return mPatientService.getPatients(area_id,pageNum,pageSize);
    }
}
