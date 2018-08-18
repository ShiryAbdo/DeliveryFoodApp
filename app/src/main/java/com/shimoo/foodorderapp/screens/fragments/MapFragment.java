package com.shimoo.foodorderapp.screens.fragments;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.shimoo.foodorderapp.R;
import com.shimoo.foodorderapp.helper.CustomInfoWindowGoogleMap;
import com.shimoo.foodorderapp.helper.GPSTracker;
import com.shimoo.foodorderapp.models.InfoWindowData;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    View rootView ;
    GPSTracker gps;
    double latitude = 0;
    double longitude = 0;

    String[] permissionCamera={Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private static final int MY_CAMERA_REQUEST_CODE = 2;
    ProgressDialog pDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          rootView = inflater.inflate(R.layout.fragment_map, container, false);
        getActivity().setTitle("Your Location");
        getActivity().findViewById(R.id.toolbar).setBackgroundColor(Color.parseColor("#31D896"));
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);

        }else {
            showMap();
        }

        return rootView;


    }
    @Override
    public void onResume() {
        super.onResume();
        if(mMapView!=null )

            mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mMapView!=null )
            mMapView.onPause();
        if(pDialog!=null && pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mMapView!=null )

            mMapView.onDestroy();
        if(pDialog!=null && pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if(mMapView!=null )
            mMapView.onLowMemory();
    }



    @SuppressLint("ResourceAsColor")
    private  void showMap(){
        MapView mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(new Bundle());
        mMapView.onResume();
//        mMapView.setBackgroundColor(R.color.colorPrimaryDark);
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap = googleMap;
                googleMap.clear();
                googleMap = googleMap;
//

                MapStyleOptions style = new MapStyleOptions("[\n" +
                        "  {\n" +
                        "    \"elementType\": \"geometry\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#f5f5f5\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"elementType\": \"labels.icon\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"visibility\": \"off\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"elementType\": \"labels.text.fill\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#616161\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"elementType\": \"labels.text.stroke\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#f5f5f5\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"administrative.land_parcel\",\n" +
                        "    \"elementType\": \"labels.text.fill\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#bdbdbd\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"poi\",\n" +
                        "    \"elementType\": \"geometry\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#eeeeee\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"poi\",\n" +
                        "    \"elementType\": \"labels.text.fill\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#757575\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"poi.park\",\n" +
                        "    \"elementType\": \"geometry\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#e5e5e5\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"poi.park\",\n" +
                        "    \"elementType\": \"labels.text.fill\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#9e9e9e\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"road\",\n" +
                        "    \"elementType\": \"geometry\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#ffffff\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"road.arterial\",\n" +
                        "    \"elementType\": \"labels.text.fill\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#757575\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"road.highway\",\n" +
                        "    \"elementType\": \"geometry\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#dadada\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"road.highway\",\n" +
                        "    \"elementType\": \"labels.text.fill\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#616161\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"road.local\",\n" +
                        "    \"elementType\": \"labels.text.fill\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#9e9e9e\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"transit.line\",\n" +
                        "    \"elementType\": \"geometry\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#e5e5e5\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"transit.station\",\n" +
                        "    \"elementType\": \"geometry\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#eeeeee\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"water\",\n" +
                        "    \"elementType\": \"geometry\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#c9c9c9\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"featureType\": \"water\",\n" +
                        "    \"elementType\": \"labels.text.fill\",\n" +
                        "    \"stylers\": [\n" +
                        "      {\n" +
                        "        \"color\": \"#9e9e9e\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }\n" +
                        "]");

                googleMap.setMapStyle(style);
//                setMapStyle();
//                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                 try {

                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                            ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                MY_PERMISSIONS_REQUEST_LOCATION);

                    }else {
                        googleMap.setMyLocationEnabled(true);
                        LatLng latLngSrc = new LatLng(29.965496, 31.279569);
                        gps = new GPSTracker(getActivity());
                        if (gps.canGetLocation()) {
                            latitude = gps.getLatitude();
                            longitude = gps.getLongitude();
                            latLngSrc = new LatLng(latitude, longitude);
                            new FindMyAddress().execute();
                        } else {
                            gps.showSettingsAlert();
                        }

                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLngSrc)
                                .title("Snowqualmie Falls")
                                .snippet("Snoqualmie Falls is located 25 miles east of Seattle.")
                                .icon(BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_BLUE));

                        InfoWindowData info = new InfoWindowData();
                        info.setImage("snowqualmie");
                        info.setHotel("Hotel : excellent hotels available");
                        info.setFood("Food : all types of restaurants available");
                        info.setTransport("Reach the site by bus, car and train.");

                        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(getActivity());
//                        googleMap.setInfoWindowAdapter(customInfoWindow);
//
//                        Marker m = googleMap.addMarker(markerOptions);
//                        m.setTag(info);
//                        m.showInfoWindow();
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngSrc, 15.0f));


                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


                googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
                    @Override
                    public void onCameraChange(CameraPosition cameraPosition) {
                        latitude = cameraPosition.target.latitude;
                        longitude = cameraPosition.target.longitude;
                        new FindMyAddress().execute();
                    }
                });

            }
        });




    }

    public class FindMyAddress extends AsyncTask<String, Void, Void> {


        String prob_plac;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Search place");
//            pDialog.show();

        }

        @Override
        protected Void doInBackground(String... params) {
            List<Address> addresses;
            try {
                if (latitude == 0 || longitude == 0) {
                    latitude = gps.getLatitude();
                    longitude = gps.getLongitude();
                } else {
                    Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
                    addresses = geocoder.getFromLocation(latitude, longitude, 1);
                    if(addresses!=null)
                    prob_plac = addresses.get(0).getAddressLine(0) + " - ";
                    prob_plac += addresses.get(0).getAddressLine(1) + " - ";
                    prob_plac += addresses.get(0).getAddressLine(2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pDialog.dismiss();
//            pin_address.setText(prob_plac);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case MY_PERMISSIONS_REQUEST_LOCATION:{

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showMap();

                } else {
                    Toast.makeText(getActivity(), "Permission denied to read your LOCATION", Toast.LENGTH_SHORT).show();
                }
                break;

            }

        }
    }

    private void setMapStyle() {
        MapStyleOptions style = new MapStyleOptions("[" +
                "  {" +
                "    \"featureType\":\"poi.business\"," +
                "    \"elementType\":\"all\"," +
                "    \"stylers\":[" +
                "      {" +
                "        \"visibility\":\"off\"" +
                "      }" +
                "    ]" +
                "  }," +
                "  {" +
                "    \"featureType\":\"transit\"," +
                "    \"elementType\":\"all\"," +
                "    \"stylers\":[" +
                "      {" +
                "        \"visibility\":\"off\"" +
                "      }" +
                "    ]" +
                "  }" +
                "]");

        googleMap.setMapStyle(style);
    }
}
