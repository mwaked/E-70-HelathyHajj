package com.mwtraking.beinmedia.hajjhealthy.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mahmoud Waked
 */

public class ImagePreviewModel implements Serializable {
    List<String> imagsUrl ;
    String url ;

    public ImagePreviewModel(List<String> imagsUrl) {
        this.imagsUrl = imagsUrl;
    }

    public ImagePreviewModel(String url) {
        this.url = url;
    }

    public List<String> getImagsUrl() {
        return imagsUrl;
    }

    public void setImagsUrl(List<String> imagsUrl) {
        this.imagsUrl = imagsUrl;
    }
}
