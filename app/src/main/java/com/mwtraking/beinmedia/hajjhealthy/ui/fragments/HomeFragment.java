package com.mwtraking.beinmedia.hajjhealthy.ui.fragments;


import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mwtraking.beinmedia.hajjhealthy.App.Constant;
import com.mwtraking.beinmedia.hajjhealthy.GPS.GPSTracker;
import com.mwtraking.beinmedia.hajjhealthy.GPS.GPSTrakerListner;
import com.mwtraking.beinmedia.hajjhealthy.Network.RetroWeb;
import com.mwtraking.beinmedia.hajjhealthy.Network.ServiceApi;
import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.BaseFragment;
import com.mwtraking.beinmedia.hajjhealthy.models.LocationResponse.LocationResponse;
import com.mwtraking.beinmedia.hajjhealthy.ui.activities.MainActivity;
import com.mwtraking.beinmedia.hajjhealthy.utils.CommonUtil;
import com.mwtraking.beinmedia.hajjhealthy.utils.PermissionUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends BaseFragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GPSTrakerListner {

    @BindView(R.id.map)
    MapView mapView;

    GoogleMap googleMap;

    Marker myMarker;

    GPSTracker gps;

    boolean startTracker = false;
    private String mResult;
    private String countryName;
    private LatLng currenLatlng;

    int REQUEST_CHECK_SETTINGS = 1001;
    private String TAG = HomeFragment.class.getSimpleName();

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    ArrayList<String> markerPlaces = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initializeComponents(View view) {

        mapView.onCreate(mSavedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);


        MapsInitializer.initialize(getActivity());

    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.setOnMapClickListener(this);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        getLocationWithPermission();


        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {

                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {


                        View v = getLayoutInflater().inflate(R.layout.info_window_form_fragment, null);
                        TextView tv_title =  v.findViewById(R.id.txttitle);
//                        TextView txtTime =  v.findViewById(R.id.txtTime);
                        ImageView iv_ad_image =  v.findViewById(R.id.iv_ad_image);

                        final int position = markerPlaces.indexOf(marker.getId());

                        tv_title.setText("Restaurant");


                        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                            public void onInfoWindowClick(Marker marker) {
                                marker.hideInfoWindow();
                            }
                        });

                        return (v);

            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
        switch (permsRequestCode) {
            case 800: {
                if (grantResults.length > 0) {
                    boolean Locationpermission = (grantResults[0] == PackageManager.PERMISSION_GRANTED);
                    getCurrentLocation();
                    for (int i = 0; i < grantResults.length; i++) {
                    }
                } else {
                    getLocationWithPermission();
                    Log.e("Permission", "permission arn't granted");
                }
                return;
            }
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {

        //
    }

    public void getLocationWithPermission() {
        gps = new GPSTracker(getActivity(), this);
        if (PermissionUtils.canMakeSmores(Build.VERSION_CODES.LOLLIPOP_MR1)) {
            if (!PermissionUtils.hasPermissions(getActivity(), PermissionUtils.GPS_PERMISSION)) {
                CommonUtil.PrintLogE("Permission not granted");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(PermissionUtils.GPS_PERMISSION,
                            Constant.RequestPermission.REQUEST_GPS_LOCATION);
                    Log.e("GPS", "1");
                }
            } else {
                getCurrentLocation();
                Log.e("GPS", "2");
            }
        } else {
            Log.e("GPS", "3");
            getCurrentLocation();
        }

    }

    public void getLocationInfo(final String lat, final String lng, final String lang) {

        RetroWeb.getLocationClint().create(ServiceApi.class).getLocation(lat + "," + lng, lang)
                .enqueue(new Callback<LocationResponse>() {
                    @Override
                    public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {

                        LocationResponse mLocation = response.body();
                        CommonUtil.onPrintLog(mLocation);
                        if (mLocation.getResults().size() != 0) {
                            if (mLocation.getResults().get(0).getFormattedAddress() != null) {
                                mResult = mLocation.getResults().get(0).getFormattedAddress();
                                try {
                                    countryName = mLocation.getResults().get(0).getAddressComponents().get(4).getLongName();
                                } catch (Exception e) {
                                }

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LocationResponse> call, Throwable t) {
                        CommonUtil.handleException(getActivity(), t);
                        CommonUtil.onPrintLog(t.getMessage());
                        t.printStackTrace();
                    }
                });
    }


    public void putMapMarker(Double lat, Double log) {
//        getLocationInfo("" + lat, "" + log, "ar");
        currenLatlng = new LatLng(lat, log);
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                currenLatlng, 15);
        googleMap.animateCamera(location);
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(lat, log));
//
         marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));

        myMarker = googleMap.addMarker(marker);
    }

    @Override
    public void onTrackerSuccess(Double lat, Double log) {
        Log.e("Direction", "Direction Success");
        // dismiss traker dialog
        if (startTracker) {
            if (lat != 0.0 && log != 0.0) {
                hideProgressDialog();
                putMapMarker(lat, log);
            }
        }
    }

    @Override
    public void onStartTracker() {
        startTracker = true;
        showProgressDialog(getString(R.string.detecting_location));
    }


    @Override
    public void onResume() {
        super.onResume();
        displayLocationSettingsRequest(getActivity());
    }


    private void displayLocationSettingsRequest(Context context) {
        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API).build();
        googleApiClient.connect();

        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(10000 / 2);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);

        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        Log.i(TAG, "All location settings are satisfied.");

                        getCurrentLocation();

                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        Log.i(TAG, "Location settings are not satisfied. Show the user a dialog to upgrade location settings ");

                        try {

                            status.startResolutionForResult(getActivity(), REQUEST_CHECK_SETTINGS);
                        } catch (IntentSender.SendIntentException e) {
                            Log.i(TAG, "PendingIntent unable to execute request.");
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        displayLocationSettingsRequest(getActivity());
                        Log.i(TAG, "Location settings are inadequate, and cannot be fixed here. Dialog not created.");
                        break;
                }
            }
        });
    }


    void getCurrentLocation() {
        gps = new GPSTracker(getActivity(), this);
        gps.getLocation();
        if (!gps.canGetLocation()) {
            displayLocationSettingsRequest(getActivity());
        } else {
            if (gps.getLatitude() != 0.0 && gps.getLongitude() != 0.0) {
                putMapMarker(gps.getLatitude(), gps.getLongitude());
            }
        }
    }


}