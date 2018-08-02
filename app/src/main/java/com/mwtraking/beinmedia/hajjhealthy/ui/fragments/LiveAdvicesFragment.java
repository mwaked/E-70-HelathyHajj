package com.mwtraking.beinmedia.hajjhealthy.ui.fragments;



import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.BaseFragment;

import butterknife.BindView;
import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;


public class LiveAdvicesFragment extends BaseFragment {

    @BindView(R.id.et_message_content)
    EmojiconEditText et_message_content;

    @BindView(R.id.iv_send)
    ImageView iv_send;

    @BindView(R.id.iv_emoj)
    ImageView iv_emoj;

    @BindView(R.id.layout)
    LinearLayout layout;

    private EmojIconActions emojIcon;

    public static LiveAdvicesFragment newInstance() {
        return new LiveAdvicesFragment();
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_live_advices;
    }

    @Override
    protected void initializeComponents(View view) {
        initEmojIcon();
    }

    private void initEmojIcon() {
        emojIcon = new EmojIconActions(getActivity(), layout, et_message_content, iv_emoj);
        emojIcon.ShowEmojIcon();
        emojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
            @Override
            public void onKeyboardOpen() {

            }

            @Override
            public void onKeyboardClose() {

            }
        });
    }

}