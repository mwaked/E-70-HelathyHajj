package com.mwtraking.beinmedia.hajjhealthy.ui.activities;



import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.ParentActivity;
import com.mwtraking.beinmedia.hajjhealthy.models.TipsModel;
import com.mwtraking.beinmedia.hajjhealthy.ui.adapters.AdvicesAdapter;
import com.mwtraking.beinmedia.hajjhealthy.ui.adapters.DiseaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DiseasesActivity extends ParentActivity {


    @BindView(R.id.rvRecycle)
    RecyclerView recyclerView ;

    LinearLayoutManager linearLayoutManager ;
    DiseaseAdapter diseaseAdapter ;
    List<TipsModel> tipsModels = new ArrayList<>();


    public static void startActivity(AppCompatActivity mAppCompatActivity) {
        Intent mIntent = new Intent(mAppCompatActivity, DiseasesActivity.class);
        mAppCompatActivity.startActivity(mIntent);
    }


    @Override
    protected void initializeComponents() {

        initAdapter();

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_diseases;
    }

    @Override
    protected boolean isEnableToolbar() {
        return false;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }

    @Override
    protected boolean isEnableBack() {
        return false;
    }

    @Override
    protected boolean hideInputType() {
        return false;
    }

    private void initAdapter() {

        tipsModels.clear();
        linearLayoutManager = new LinearLayoutManager(DiseasesActivity.this);
        diseaseAdapter = new DiseaseAdapter(DiseasesActivity.this , tipsModels , R.layout.recycle_desaeses);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(diseaseAdapter);

        String[] diseasesArr = getResources().getStringArray(R.array.diseases);
        for (int i = 0; i <diseasesArr.length ; i++) {
            tipsModels.add(new TipsModel(diseasesArr[i]));
        }
    }

    @OnClick(R.id.btnSignUp)
    void onSignUpClick(){
        MainActivity.startActivity(DiseasesActivity.this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
    }

}
