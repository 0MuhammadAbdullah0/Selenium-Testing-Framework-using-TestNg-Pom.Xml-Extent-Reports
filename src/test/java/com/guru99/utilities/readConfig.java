package com.guru99.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
    Properties property;

    public readConfig()
    {
        File src= new File("configurations/config.properties");
        try {
            FileInputStream fis=new FileInputStream(src);
            property=new Properties();
            property.load(fis);


        }
        catch (Exception e)
        {
            System.out.println("the exception is"+ e.getMessage());

        }

    }
    public String getBaseUrl()
    {
        String url=property.getProperty("baseUrl");
        return url ;
    }
    public String getUsername()
    {
        String username=property.getProperty("username");
        return username;
    }
    public String getPassword()
    {
        String password=property.getProperty("password");
        return password;
    }


}
