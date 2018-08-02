package com.mwtraking.beinmedia.hajjhealthy.Network;

import com.mwtraking.beinmedia.hajjhealthy.models.LocationResponse.LocationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApi {

    @GET(Urls.GETLOCATION)
    Call<LocationResponse> getLocation(
            @Query("latlng") String lng,
            @Query("language") String languge
    );

//    @FormUrlEncoded
//    @POST(Urls.UPDATE_DEVICE_TOKEN)
//    Call<BaseResponse> updateDeviceToken(
//            @Field("token") String token,
//            @Field("device_token") String device_token
//    );
//
//    @GET(Urls.GET_FAVOURITES)
//    Call<AdvertResposne> getFavourites(
//            @Query("page") int page,
//            @Query("api_token") String api_token);

}
