package com.yiliu.imhere.baidumap;

import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

public class MyBaiduLocationListenner implements BDLocationListener {

    private static final String TAG = "MyBaiduLocationListenner";

    private LocaltionCallback locCallback;

    public MyBaiduLocationListenner(LocaltionCallback callback) {
        this.locCallback = callback;
    }

    @Override
    public void onReceiveLocation(BDLocation location) {
        if (location == null)
            return;
        StringBuilder sb = new StringBuilder();
        sb.append("onReceiveLocation:");
        sb.append("\ntime : ");
        sb.append(location.getTime());
        sb.append("\nerror code : ");
        sb.append(location.getLocType());
        sb.append("\nlatitude : ");
        sb.append(location.getLatitude());
        sb.append("\nlontitude : ");
        sb.append(location.getLongitude());
        sb.append("\nradius : ");
        sb.append(location.getRadius());
        if (location.getLocType() == BDLocation.TypeGpsLocation) {
            sb.append("\nspeed : ");
            sb.append(location.getSpeed());
            sb.append("\nsatellite : ");
            sb.append(location.getSatelliteNumber());
        } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
            sb.append("\naddr : ");
            sb.append(location.getAddrStr());
        }

        Log.i("ReceiveLocation", sb.toString());
        if (location.getLocType() == BDLocation.TypeNetWorkLocation
                || location.getLocType() == BDLocation.TypeGpsLocation) {
            locCallback.returnLocation(location);
        }
        // mLocationClient.stop();
    }

    @Override
    public void onReceivePoi(BDLocation poiLocation) {
        if (poiLocation == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivePoi:");
        sb.append("\nPoi time : ");
        sb.append(poiLocation.getTime());
        sb.append("\nerror code : ");
        sb.append(poiLocation.getLocType());
        sb.append("\nlatitude : ");
        sb.append(poiLocation.getLatitude());
        sb.append("\nlontitude : ");
        sb.append(poiLocation.getLongitude());
        sb.append("\nradius : ");
        sb.append(poiLocation.getRadius());
        if (poiLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
            sb.append("\naddr : ");
            sb.append(poiLocation.getAddrStr());
        }
        if (poiLocation.hasPoi()) {
            sb.append("\nPoi:");
            sb.append(poiLocation.getPoi());
        } else {
            sb.append("noPoi information");
        }
        Log.i("ReceivePoi", sb.toString());
        if (poiLocation.getLocType() == BDLocation.TypeNetWorkLocation
                || poiLocation.getLocType() == BDLocation.TypeGpsLocation) {
            locCallback.returnLocation(poiLocation);
        }
        // mLocClient.stop();
    }

}
