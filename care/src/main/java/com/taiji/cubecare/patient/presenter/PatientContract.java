package com.taiji.cubecare.patient.presenter;

import com.taiji.cubecare.patient.data.entity.Patient;
import com.taiji.library.mvp.presenter.BasePresenter;
import com.taiji.library.mvp.view.CommonListPageView;

/**
 * Created by panho on 2017-9-3.
 */

public interface PatientContract {

    interface View extends CommonListPageView<Patient,Presenter>{

    }

    interface Presenter extends BasePresenter{
        public void loadPatients(String area_id,boolean isRefresh);
    }

}
