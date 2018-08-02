package com.mwtraking.beinmedia.hajjhealthy.ui.fragments;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.BaseFragment;
import com.mwtraking.beinmedia.hajjhealthy.models.TipsModel;
import com.mwtraking.beinmedia.hajjhealthy.ui.adapters.AdvicesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MedicalAdvicesFragment extends BaseFragment {


    @BindView(R.id.rvRecycle)
    RecyclerView recyclerView ;

    LinearLayoutManager linearLayoutManager ;
    AdvicesAdapter advicesAdapter ;
    List<TipsModel> tipsModels = new ArrayList<>();

    public static MedicalAdvicesFragment newInstance() {
        return new MedicalAdvicesFragment();
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_medical_advices;
    }

    @Override
    protected void initializeComponents(View view) {

        initAdapter();

    }

    private void initAdapter() {
        tipsModels.clear();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        advicesAdapter = new AdvicesAdapter(getActivity() , tipsModels , R.layout.recycle_incoming_message);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(advicesAdapter);

        tipsModels.add(new TipsModel("The Ministry of Health in the kingdom of Saudi Arabia recommends all pilgrims to comply with following: " , "a) Wash hands with soap and water or a disinfectant, especially after coughing and sneezing, after using toilets, before handling and consuming food, and after touching animals.\n" +
                "b) Use disposable tissues when coughing or sneezing and dispose of used tissues in a wastebasket. \n" +
                "c) Wear regular masks when in crowded places. \n" +
                "d) Avoid close contact with people who appear ill and avoid sharing their personal belongings. e) Avoid contact with camels in farms, markets, or barn.\n" +
                " f) Avoid drinking raw milk or eating meat that has not been thoroughly cooked."));
    }

}