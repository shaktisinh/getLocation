# getLocation
Display Latitude Longitude with Time stamp after each 5 seconds

**ADD PERMISSIONS**
To access internet, Locatio/GPS, network state change, receive map

    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="com.javapapers.currentlocationinmap.permission.MAPS_RECEIVE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    
    
**ADD META TAG**

    <meta-data android:name="com.google.android.geo.API_KEY"
        android:value="@string/google_maps_key" />
        
*Note : Please add your Google Map API Key in google_maps_api.xml*

    <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">
        <!-- YOUR API KEY -->
    </string> 
    
    
**To Display Google Map**

        <fragment
            android:id="@+id/map"
            android:name="com.google.android.gms.maps.SupportMapFragment"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
            
**implement OnMapReadyCallback and LocationListener on FragmentActivity** to Sync with map and and process with location

  Obtain the SupportMapFragment and get notified when the map is ready to be used.

    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
    
 **Add following in Overriden method onMapReadyMethod(GoogleMap googleMap)**
 
 To assign Map to our GoogleMap
 
    GoogleMap mMap = googleMap; 
  
 To add Polygon line
  
    PolylineOptions line = new PolylineOptions();
    mMap.addPolyline(line);
  
 To decorate Polygon line you can give line width and color
 
    line.width(20).color(getResources().getColor(R.color.colorPrimary));
    
 To move screen focus on location
 
    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    
 To zoom screen 

    mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    
    
 To enable the location 
 (*Note: You may need to give runtime permission access, so please add that code before this*)

    mMap.setMyLocationEnabled(true);
    
 To get location service and current locations details
 
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        String bestProvider = locationManager.getBestProvider(new Criteria(), true);
        Location location = locationManager.getLastKnownLocation(bestProvider);

        if (location != null) {
            onLocationChanged(location);
        }
        
To update the location
(*here you can give condition base on time and meters it will updates*

    locationManager.requestLocationUpdates(bestProvider, millisecs, meters, this);
    
Based on above method conditions **onLocationChanged(Location location)** method will call


To get current timestamp

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    String timeStamp = simpleDateFormat.format(new Date());
    
    


**OTHER** </br>
Here I am using CoordinatorLayout to decorate Activity screen
and RecyclerView to display list of data


**NOTE**</br>
*Please make sure that internet and location is turned on on your device</br>
We need to give runtime permission option to access location of device if OS version is greater than L.</br>
We can create BroadcastReceiver to notify App if Internet or GPS state change*
