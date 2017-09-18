package com.taiji.cubecare.patient.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by panho on 2017-9-3.
 */
@Entity
public class Patient {
    private String p_id;
    private String p_name;
    private String p_gender;
    private String p_birthday;
    private String p_inpno;
    private String pp_timeInHospital;
    private String pp_mainDoctor;
    private String pp_diagnosis;
    private String pp_wardCode;
    private String pp_wardName;
    private String pp_alergy_drugs;
    private String pp_patientStatus;
    private String pp_careLevel;
    private String pp_bedNo;
    private String pp_exten_2;
    private String pp_exten_3;
    private String pp_exten_4;
    private String pp_bedLabel;
    private String pp_visitid;
    private String db;
    private String pp_deptCode;
    private String pp_deptName;
    private String wardName;
    private String age;
    @Generated(hash = 1738242402)
    public Patient(String p_id, String p_name, String p_gender, String p_birthday,
            String p_inpno, String pp_timeInHospital, String pp_mainDoctor,
            String pp_diagnosis, String pp_wardCode, String pp_wardName,
            String pp_alergy_drugs, String pp_patientStatus, String pp_careLevel,
            String pp_bedNo, String pp_exten_2, String pp_exten_3,
            String pp_exten_4, String pp_bedLabel, String pp_visitid, String db,
            String pp_deptCode, String pp_deptName, String wardName, String age) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_gender = p_gender;
        this.p_birthday = p_birthday;
        this.p_inpno = p_inpno;
        this.pp_timeInHospital = pp_timeInHospital;
        this.pp_mainDoctor = pp_mainDoctor;
        this.pp_diagnosis = pp_diagnosis;
        this.pp_wardCode = pp_wardCode;
        this.pp_wardName = pp_wardName;
        this.pp_alergy_drugs = pp_alergy_drugs;
        this.pp_patientStatus = pp_patientStatus;
        this.pp_careLevel = pp_careLevel;
        this.pp_bedNo = pp_bedNo;
        this.pp_exten_2 = pp_exten_2;
        this.pp_exten_3 = pp_exten_3;
        this.pp_exten_4 = pp_exten_4;
        this.pp_bedLabel = pp_bedLabel;
        this.pp_visitid = pp_visitid;
        this.db = db;
        this.pp_deptCode = pp_deptCode;
        this.pp_deptName = pp_deptName;
        this.wardName = wardName;
        this.age = age;
    }
    @Generated(hash = 1655646460)
    public Patient() {
    }
    public String getP_id() {
        return this.p_id;
    }
    public void setP_id(String p_id) {
        this.p_id = p_id;
    }
    public String getP_name() {
        return this.p_name;
    }
    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
    public String getP_gender() {
        return this.p_gender;
    }
    public void setP_gender(String p_gender) {
        this.p_gender = p_gender;
    }
    public String getP_birthday() {
        return this.p_birthday;
    }
    public void setP_birthday(String p_birthday) {
        this.p_birthday = p_birthday;
    }
    public String getP_inpno() {
        return this.p_inpno;
    }
    public void setP_inpno(String p_inpno) {
        this.p_inpno = p_inpno;
    }
    public String getPp_timeInHospital() {
        return this.pp_timeInHospital;
    }
    public void setPp_timeInHospital(String pp_timeInHospital) {
        this.pp_timeInHospital = pp_timeInHospital;
    }
    public String getPp_mainDoctor() {
        return this.pp_mainDoctor;
    }
    public void setPp_mainDoctor(String pp_mainDoctor) {
        this.pp_mainDoctor = pp_mainDoctor;
    }
    public String getPp_diagnosis() {
        return this.pp_diagnosis;
    }
    public void setPp_diagnosis(String pp_diagnosis) {
        this.pp_diagnosis = pp_diagnosis;
    }
    public String getPp_wardCode() {
        return this.pp_wardCode;
    }
    public void setPp_wardCode(String pp_wardCode) {
        this.pp_wardCode = pp_wardCode;
    }
    public String getPp_wardName() {
        return this.pp_wardName;
    }
    public void setPp_wardName(String pp_wardName) {
        this.pp_wardName = pp_wardName;
    }
    public String getPp_alergy_drugs() {
        return this.pp_alergy_drugs;
    }
    public void setPp_alergy_drugs(String pp_alergy_drugs) {
        this.pp_alergy_drugs = pp_alergy_drugs;
    }
    public String getPp_patientStatus() {
        return this.pp_patientStatus;
    }
    public void setPp_patientStatus(String pp_patientStatus) {
        this.pp_patientStatus = pp_patientStatus;
    }
    public String getPp_careLevel() {
        return this.pp_careLevel;
    }
    public void setPp_careLevel(String pp_careLevel) {
        this.pp_careLevel = pp_careLevel;
    }
    public String getPp_bedNo() {
        return this.pp_bedNo;
    }
    public void setPp_bedNo(String pp_bedNo) {
        this.pp_bedNo = pp_bedNo;
    }
    public String getPp_exten_2() {
        return this.pp_exten_2;
    }
    public void setPp_exten_2(String pp_exten_2) {
        this.pp_exten_2 = pp_exten_2;
    }
    public String getPp_exten_3() {
        return this.pp_exten_3;
    }
    public void setPp_exten_3(String pp_exten_3) {
        this.pp_exten_3 = pp_exten_3;
    }
    public String getPp_exten_4() {
        return this.pp_exten_4;
    }
    public void setPp_exten_4(String pp_exten_4) {
        this.pp_exten_4 = pp_exten_4;
    }
    public String getPp_bedLabel() {
        return this.pp_bedLabel;
    }
    public void setPp_bedLabel(String pp_bedLabel) {
        this.pp_bedLabel = pp_bedLabel;
    }
    public String getPp_visitid() {
        return this.pp_visitid;
    }
    public void setPp_visitid(String pp_visitid) {
        this.pp_visitid = pp_visitid;
    }
    public String getDb() {
        return this.db;
    }
    public void setDb(String db) {
        this.db = db;
    }
    public String getPp_deptCode() {
        return this.pp_deptCode;
    }
    public void setPp_deptCode(String pp_deptCode) {
        this.pp_deptCode = pp_deptCode;
    }
    public String getPp_deptName() {
        return this.pp_deptName;
    }
    public void setPp_deptName(String pp_deptName) {
        this.pp_deptName = pp_deptName;
    }
    public String getWardName() {
        return this.wardName;
    }
    public void setWardName(String wardName) {
        this.wardName = wardName;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }

}
