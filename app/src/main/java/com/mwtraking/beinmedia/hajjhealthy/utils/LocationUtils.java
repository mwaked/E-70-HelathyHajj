package com.mwtraking.beinmedia.hajjhealthy.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.util.List;
import java.util.Locale;

/**
 * Created by Mahmoud Waked
 */

public class LocationUtils {

    public static List<Address> getAddressByLatLong(Context mContext , double latitude , double longitude){
        Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());

        List<Address> addresses = null; // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
        } catch (Exception e) {
            Log.e("EXCEPTION" , e.getMessage());
        }
        try {
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();
            // Only if available else return NULL
        }catch (Exception e){
        }

        return addresses ;
    }
}
