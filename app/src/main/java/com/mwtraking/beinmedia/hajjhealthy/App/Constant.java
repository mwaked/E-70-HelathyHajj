package com.mwtraking.beinmedia.hajjhealthy.App;


import com.mwtraking.beinmedia.hajjhealthy.R;

public class Constant {


    public static final class RequestCode {

        public static final int GET_LOCATION = 500;

        public static final int PHOTO_CHOOSE = 3;

        public static final int GPS_ENABLING = 300;

        public static final int Take_PICTURE = 9;
    }

    public static final class RequestPermission {

        final public static int REQUEST_GPS_LOCATION = 800;

        final public static int REQUEST_IMAGES = 200;

    }


    public static final class NotificationType {

        public static final int ChatSound = R.raw.message;

        public static final int NotificationSound = R.raw.notification;


    }

    public static final class BundleData {

    }


    public static class LocationConstant {

        public static String LAT = "lat";

        public static String LNG = "lng";

        public  static String COUNTRY_NAME = "counry_name" ;


        public  static String CITY = "city" ;

        public static String LOCATION = "location";
    }


    public static final class InfinitScroll {

        public static final int ITEM = 0;

        public static final int LOADING = 1;

        public static final int SELF_TEXT = 100;

        public static final int OTHER_TEXT = 101;
        public static final int SELF_IMAGE = 103;

        public static final int OTHER_IMAGE = 104;
    }


    public static class SharedPrefKey {

        public final static String SHARED_PREF_NAME = "mal3bk_shared_pref";

        public final static String LOGIN_STATUS = "mal3bk_login_status";

        public final static String TREATMENT_NAME = "mal3bk_treatment_name";

        public final static String SELECTED_DATE = "mal3bk_selected_date";

        public final static String USER = "mal3bk_user_data";

        public final static String IS_NEW = "mal3bk_is_new";

        public final static String RECEIVE_MESSAGE = "mal3bk_receive_message";

        public final static String NOTIFICATION_ENABLED = "mal3bk_notification_enabled";

        public final static String STEP = "mal3bk_step";

        public static final String LANGUAGE = "mal3bk_language";

        public static final String USER_TYPE = "mal3bk_user_type";
    }

    public static final class UsageMethod {
        public static final String USER = "user";
        public static final String PLAYGROUND = "playground ";
        public static final String COACH = "cocah ";

        public static final int USER_STATUSE = 0;
        public static final int COACH_STATUSE = 1;
        public static final int PLAYGROUND_STATUSE = 2;
    }


}
