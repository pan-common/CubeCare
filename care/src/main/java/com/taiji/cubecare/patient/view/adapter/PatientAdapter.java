package com.taiji.cubecare.patient.view.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.taiji.cubecare.R;
import com.taiji.cubecare.patient.data.entity.Patient;

import java.util.List;

/**
 * Created by panho on 2017-9-5.
 */

public class PatientAdapter extends BaseQuickAdapter<Patient,BaseViewHolder>{

    public PatientAdapter(@Nullable List<Patient> data) {
        super(R.layout.patient_item_layout,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final Patient item) {
        helper.setText(R.id.bed_tv,item.getPp_bedNo()+"床");
        helper.setText(R.id.pname_tv,item.getP_name());
        helper.setText(R.id.sex_tv,item.getP_gender());
        helper.setText(R.id.age_tv,item.getAge());
        TextView pid_tv = helper.getView(R.id.pid_tv);
        pid_tv.setText(item.getP_id());
        helper.setText(R.id.other_tv,item.getPp_exten_2());

        if(item.getPp_careLevel()!=null){
            if(item.getPp_careLevel().equals("一级护理")){
                helper.setBackgroundRes(R.id.bed_tv,R.drawable.care_level1);
                pid_tv.setTextColor(ContextCompat.getColor(mContext,R.color.care_level_1));
            }else if(item.getPp_careLevel().equals("二级护理")){
                helper.setBackgroundRes(R.id.bed_tv,R.drawable.care_level2);
                pid_tv.setTextColor(ContextCompat.getColor(mContext,R.color.care_level_2));
            }else if(item.getPp_careLevel().equals("三级护理")){
                helper.setBackgroundRes(R.id.bed_tv,R.drawable.care_level3);
                pid_tv.setTextColor(ContextCompat.getColor(mContext,R.color.care_level_3));
            }else if(item.getPp_careLevel().equals("特级护理")){
                helper.setBackgroundRes(R.id.bed_tv,R.drawable.care_level4);
                pid_tv.setTextColor(ContextCompat.getColor(mContext,R.color.care_level_4));
            }else {
                helper.setBackgroundRes(R.id.bed_tv,R.drawable.care_level5);
                pid_tv.setTextColor(ContextCompat.getColor(mContext,R.color.care_level_5));
            }
        }else {
            helper.setBackgroundRes(R.id.bed_tv,R.drawable.care_level5);
            pid_tv.setTextColor(ContextCompat.getColor(mContext,R.color.care_level_5));
        }
    }

}
