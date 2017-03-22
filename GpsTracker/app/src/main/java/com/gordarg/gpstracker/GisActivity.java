package com.gordarg.gpstracker;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class GisActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gis);



        org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants.setUserAgentValue(BuildConfig.APPLICATION_ID);

        try {
            InputStream in = null;
            OutputStream fout = null;
            int count = 0;

            try
            {
                /*
                String sSDpath = null;
                File   fileCur = null;
                for( String sPathCur : Arrays.asList( "MicroSD","external_SD","sdcard1","ext_card", "external_sd", "ext_sd", "external", "extSdCard",  "externalSdCard")) // external sdcard
                {

                    fileCur = new File( "/mnt/", sPathCur);
                    if( fileCur.isDirectory() && fileCur.canWrite())
                    {
                        sSDpath = fileCur.getAbsolutePath();
                        break;
                    }
                    if( sSDpath == null)  {
                        fileCur = new File( "/storage/", sPathCur);
                        if( fileCur.isDirectory() && fileCur.canWrite())
                        {
                            sSDpath = fileCur.getAbsolutePath();
                            break;
                        }
                    }
                    if( sSDpath == null)  {
                        fileCur = new File( "/storage/emulated", sPathCur);
                        if( fileCur.isDirectory() && fileCur.canWrite())
                        {
                            sSDpath = fileCur.getAbsolutePath();

                            Log.e("path",sSDpath);
                            break;
                        }
                    }
                }
                File folder = new File(sSDpath+"/osmdroid");
                */
                File folder = new File( Environment.getExternalStorageDirectory()+"/osmdroid");
                boolean success = true;
                if (!folder.exists()) {
                    success = folder.mkdir();
                }
                if (success) {
                    in = getApplicationContext().getAssets().open("Map.zip");
                    fout = new FileOutputStream(new File(folder, "Map.zip"));
                    byte data[] = new byte[3000000];
                    while ((count = in.read(data, 0, data.length)) != -1)
                    {
                        fout.write(data, 0, count);
                    }
                } else {
                    // Do something else on failure
                }


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (in != null)
                {
                    try {
                        in.close();
                    } catch (IOException e)
                    {
                    }
                }
                if (fout != null)
                {
                    try {
                        fout.close();
                    } catch (IOException e) {
                    }
                }
            }



            org.osmdroid.views.MapView map = (org.osmdroid.views.MapView) findViewById(R.id.mapViewOSM);
            map.setTileSource(TileSourceFactory.MAPNIK);
            map.setBuiltInZoomControls(true);
            map.setMultiTouchControls(true);
            IMapController mapController = map.getController();
            mapController.setZoom(9);
            GeoPoint startPoint = new GeoPoint(34.800175, 48.501682);
            mapController.setCenter(startPoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}