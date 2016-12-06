package com.example.alec.myapplication;

import android.support.design.widget.Snackbar;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
/*import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;*/
public class AirNowAPI {

    public static String getAirQuality()  {

        // API parameters
        Map  options = new HashMap();
        options.put("url", "https://airnowapi.org/aq/data/");
        options.put("start_date", "2014-09-23");
        options.put("start_hour_utc", "22");
        options.put("end_date", "2014-09-23");
        options.put("end_hour_utc", "23");
        options.put("parameters",  "o3,pm25");
        options.put("bbox", "-90.806632,24.634217,-71.119132,45.910790");
        options.put("data_type", "a");
        options.put("format", "application/vnd.google-earth.kml");
        options.put("ext", "kml");
        options.put("api_key", "FC2E4CF6-4A40-49F2-919B-5E7F8EB28B19");
        StringBuilder myThing = new StringBuilder();
        // API request URL
        final String REQUEST_URL = options.get("url")
                + "?startdate=" + options.get("start_date")
                + "t" + options.get("start_hour_utc")
                + "&enddate=" + options.get("end_date")
                + "t" + options.get("end_hour_utc")
                + "&parameters=" + options.get("parameters")
                + "&bbox=" + options.get("bbox")
                + "&datatype=" + options.get("data_type")
                + "&format=" + options.get("format")
                + "&api_key=" + options.get("api_key");

        try {
            // Request AirNowAPI data
            System.out.println("Requesting AirNowAPI data...");

            // User's dome directory (Windows only)
            String homeDir = System.getProperty("user.home");
            DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyymmddhhmmss");
            String downloadFileName = "AirNowAPI_".concat(fmt.print(new DateTime()) + "." + options.get("ext"));
            File downloadFile = new File(homeDir, downloadFileName);

            // Perform the AirNow API data request
            URL website = new URL(REQUEST_URL);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());

            ByteBuffer byteBuffer = ByteBuffer.allocate(512);

            while(rbc.read(byteBuffer) > 0)
            {

                //limit is set to current position and position is set to zero
                byteBuffer.flip();

                while(byteBuffer.hasRemaining()){
                    char ch = (char) byteBuffer.get();
                    System.out.print(ch);
                    myThing.append(ch);
                }
            }

            //FileOutputStream fos = new FileOutputStream(downloadFile);
            //fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

            // Download completed
            System.out.println("Request URL: " + REQUEST_URL);
            System.out.println("Download location: " + downloadFile.getPath());

        } catch (Exception e) {
            System.err.println("Unable to perform AirNowAPI request." + e.getMessage());
        }
        return myThing.toString();
    }
}
