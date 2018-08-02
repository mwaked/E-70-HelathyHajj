package com.mwtraking.beinmedia.hajjhealthy.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.ParentRecyclerAdapter;
import com.mwtraking.beinmedia.hajjhealthy.base.ParentRecyclerViewHolder;
import com.mwtraking.beinmedia.hajjhealthy.models.TipsModel;

import java.util.List;

import butterknife.BindView;


/**
 * Created by Mahmoud Waked
 */

public class DiseaseAdapter extends ParentRecyclerAdapter<TipsModel> {


    TipsModel tipsModel;

    public DiseaseAdapter(final Context context, final List<TipsModel> data, final int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public ParentRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ParentRecyclerViewHolder viewHolder = null;
        View viewItem = inflater.inflate(layoutId, parent, false);
        viewHolder = new ListHomeHolder(viewItem);
        return viewHolder;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(final ParentRecyclerViewHolder holder, final int position) {

        tipsModel = data.get(position);

        final ListHomeHolder viewHolder = (ListHomeHolder) holder;

        viewHolder.diseases_name.setText(tipsModel.getTips());

    }


    public class ListHomeHolder extends ParentRecyclerViewHolder {

        @BindView(R.id.diseases_name)
        CheckBox diseases_name;

        ListHomeHolder(View itemView) {
            super(itemView);
        }

    }

}
