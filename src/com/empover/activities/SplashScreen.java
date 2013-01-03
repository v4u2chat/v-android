package com.empover.activities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.widget.TextView;

public class SplashScreen extends Activity
{
    private TextView splashLoadingTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        
        splashLoadingTextView   =   (TextView)findViewById(R.id.splashLoadingTextView);
        
        init(this);
        
        splashLoadingTextView.setText("Initialization is done.");
        
        new CountDownTimer(2000, 1000)
        {

            public void onTick(long millisUntilFinished)
            {

            }

            public void onFinish()
            {

                Intent loginIntent  =   new Intent(SplashScreen.this,LoginActivity.class);
                loginIntent.putExtra("RAJESH", "GADIPARTI");
                SplashScreen.this.startActivity(loginIntent);
            }

        }.start();
        
        
    }

    public void init(Context context)
    {
        AssetManager assetManager = this.getResources().getAssets();
        try
        {
            splashLoadingTextView.setText("Loading init.properties....");
            InputStream inputStream = assetManager.open("init.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            
            
            SharedPreferences sharedPreferences = context.getSharedPreferences("init", MODE_PRIVATE);
            Editor sharedPreferencesEditor  = sharedPreferences.edit();
            
            Enumeration<Object> keys =   properties.keys();
            while(keys.hasMoreElements())
            {
                String key  =   (String)keys.nextElement();
                sharedPreferencesEditor.putString(key, properties.getProperty(key));
            }
            splashLoadingTextView.setText("Commiting init.properties to SharedPreferences....");
            sharedPreferencesEditor.commit();
            

        } catch (IOException e)
        {
            System.err.println("Failed to open microlog property file");
            e.printStackTrace();
        }

    }
}
