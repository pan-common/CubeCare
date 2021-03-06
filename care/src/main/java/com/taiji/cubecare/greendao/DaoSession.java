package com.taiji.cubecare.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.taiji.cubecare.patient.data.entity.Patient;

import com.taiji.cubecare.greendao.PatientDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig patientDaoConfig;

    private final PatientDao patientDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        patientDaoConfig = daoConfigMap.get(PatientDao.class).clone();
        patientDaoConfig.initIdentityScope(type);

        patientDao = new PatientDao(patientDaoConfig, this);

        registerDao(Patient.class, patientDao);
    }
    
    public void clear() {
        patientDaoConfig.clearIdentityScope();
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }

}
