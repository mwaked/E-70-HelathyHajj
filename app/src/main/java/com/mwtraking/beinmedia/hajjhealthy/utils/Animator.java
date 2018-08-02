package com.mwtraking.beinmedia.hajjhealthy.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class Animator {

    private Context context;


    /*
     * Constructor
     */
    public Animator(Context context) {
        this.context = context;
    }


    /*
     * Load Animation File according to animationResourceID then Start Animation
     */
    public Animation loadAnimation(View view, int animResource) {


        Animation anim = AnimationUtils.loadAnimation(context, animResource);
        anim.reset();
        view.clearAnimation();
        view.startAnimation(anim);
        return anim;
    }


}
