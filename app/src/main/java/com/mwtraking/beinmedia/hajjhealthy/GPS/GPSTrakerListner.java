package com.mwtraking.beinmedia.hajjhealthy.GPS;

/**
 * Created by mahmoud Waked on 12/03/2017.
 */

public interface GPSTrakerListner {
    void onTrackerSuccess(Double lat, Double log);

    void onStartTracker();
}
