package com.empover.common;

import java.util.Hashtable;

import android.app.Application;
import android.content.Context;

public class ApplicationContext extends Application
{
    private static ApplicationContext applicationContext;

    private Hashtable<String, String> applicationValues =   new Hashtable<String, String>();
    
    public void onCreate()
    {
        super.onCreate();
        ApplicationContext.applicationContext = this;
        System.out.println("Base ApplicationContext has been created.........");
    }

    public static Context getInstance()
    {
        return ApplicationContext.applicationContext;
    }
    
    public void setValue(String key,String value)
    {
        applicationValues.put(key, value);
    }
    
    public String getValue(String key)
    {
        return applicationValues.get(key);
    }
    
    
}
