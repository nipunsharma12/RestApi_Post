 package com.example.rai.restapi_post;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONObject;


//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

 public class MainActivity extends AppCompatActivity {

    Button b1;
    String json;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                json = jsonPostrecord();
                SendDataPost(json);


            }
        });
    }

    public String jsonPostrecord() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("username", "doc");
            jsonObject.accumulate("password","doc");
            jsonObject.accumulate("deviceToken","23123123fgf213dfd31");
            jsonObject.accumulate("deviceType","Doctor");
            return jsonObject.toString();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

     public void uploadFile() {


         int serverResponseCode = 0;
         Map<String, String> params = new HashMap<String, String>(6);
         params.put("username", "doc");
         params.put("password", "doc");
         params.put("deviceToken", "121213");
         params.put("deviceType", "Doctor");


         HttpURLConnection connection;
         DataOutputStream dataOutputStream;
         String lineEnd = "\r\n";
         String twoHyphens = "--";
         String boundary = "*****";

         StringBuffer jsonString = new StringBuffer();
         String line;



             try {
                 URL url = new URL("Http://skoolroom.in/vgs_new/webservice/login_post");
                 connection = (HttpURLConnection) url.openConnection();
                 connection.setDoInput(true);//Allow Inputs
                 connection.setDoOutput(true);//Allow Outputs
                 connection.setUseCaches(false);//Don't use a cached Copy
                 connection.setRequestMethod("POST");
                 connection.setRequestProperty("Connection", "Keep-Alive");
                 connection.setRequestProperty("ENCTYPE", "multipart/form-data");
                 connection.setRequestProperty(
                         "Content-Type", "multipart/form-data;boundary=" + boundary);
                 //creating new dataoutputstream
                 dataOutputStream = new DataOutputStream(connection.getOutputStream());



                 Iterator<String> keys = params.keySet().iterator();
                 while (keys.hasNext()) {
                     String key = keys.next();
                     String value = params.get(key);
                     //write the bytes read from inputstream
                     dataOutputStream.writeBytes(twoHyphens + boundary + lineEnd);
                     System.out.println(twoHyphens + boundary + lineEnd);
                     dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"" + lineEnd);
                     System.out.println("Content-Disposition: form-data; name=\"" + key + "\"" + lineEnd);
                     dataOutputStream.writeBytes("Content-Type: text/plain" + lineEnd);
                     System.out.println("Content-Type: text/plain" + lineEnd);
                     dataOutputStream.writeBytes(lineEnd);
                     dataOutputStream.writeBytes(value);
                     dataOutputStream.writeBytes(lineEnd);
                 }


                 dataOutputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);


                     serverResponseCode = connection.getResponseCode();


                 String serverResponseMessage = connection.getResponseMessage();

                System.out.println("Server Response is: " + serverResponseMessage + ": " + serverResponseCode);

                 dataOutputStream.close();
                 dataOutputStream.flush();
                 BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                 while ((line = br.readLine()) != null) {
                     System.out.println("response " +line);
                     jsonString.append(line);
                 }
                 br.close();




                 System.out.println("response "+jsonString.toString());

             }
             catch (Exception e) {
                 e.printStackTrace();
             }

     }
     public void uploadFile1() {


         int serverResponseCode = 0;
         Map<String, String> params = new HashMap<String, String>(6);
         params.put("username", "doc");
         params.put("password", "doc");
         params.put("deviceToken", "121213");
         params.put("deviceType", "Doctor");


         HttpURLConnection connection;
         DataOutputStream dataOutputStream;
         String lineEnd = "\r\n";
         String twoHyphens = "--";
         String boundary = "*****";

         StringBuffer jsonString = new StringBuffer();
         String line;


         int bytesRead, bytesAvailable, bufferSize;
         byte[] buffer;
         int maxBufferSize = 1 * 1024 * 1024;


//         String[] parts = selectedFilePath.split("/");
//         final String fileName = parts[parts.length - 1];


         try {
             URL url = new URL("Http://skoolroom.in/vgs_new/webservice/login_post");
             connection = (HttpURLConnection) url.openConnection();
             connection.setDoInput(true);//Allow Inputs
             connection.setDoOutput(true);//Allow Outputs
             connection.setUseCaches(false);//Don't use a cached Copy
             connection.setRequestMethod("POST");
             connection.setRequestProperty("Connection", "Keep-Alive");
             connection.setRequestProperty("ENCTYPE", "multipart/form-data");
             connection.setRequestProperty(
                     "Content-Type", "multipart/form-data;boundary=" + boundary);
//                 connection.setRequestProperty("image", selectedFilePath);

             //creating new dataoutputstream
             dataOutputStream = new DataOutputStream(connection.getOutputStream());


             //writing bytes to data outputstream
//                 dataOutputStream.writeBytes(twoHyphens + boundary + lineEnd);
//                 dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"image\";filename=\""
//                         + selectedFilePath + "\"" + lineEnd);
//
//                 dataOutputStream.writeBytes(lineEnd);

             //returns no. of bytes present in fileInputStream
//                 bytesAvailable = fileInputStream.available();
//                 //selecting the buffer size as minimum of available bytes or 1 MB
//                 bufferSize = Math.min(bytesAvailable, maxBufferSize);
//                 //setting the buffer as byte array of size of bufferSize
//                 buffer = new byte[bufferSize];
//
//                 //reads bytes from FileInputStream(from 0th index of buffer to buffersize)
//                 bytesRead = fileInputStream.read(buffer, 0, bufferSize);

//
//                 //loop repeats till bytesRead = -1, i.e., no bytes are left to read
//                 while (bytesRead > 0) {
//
//                     try {
//
//                         //write the bytes read from inputstream
//                         dataOutputStream.write(buffer, 0, bufferSize);
//                     } catch (OutOfMemoryError e) {
//                         Toast.makeText(UploadAsignmentActivity.this, "Insufficient Memory!", Toast.LENGTH_SHORT).show();
//                     }
//                     bytesAvailable = fileInputStream.available();
//                     bufferSize = Math.min(bytesAvailable, maxBufferSize);
//                     bytesRead = fileInputStream.read(buffer, 0, bufferSize);
//                 }
//
//                 dataOutputStream.writeBytes(lineEnd);


             Iterator<String> keys = params.keySet().iterator();
             while (keys.hasNext()) {
                 String key = keys.next();
                 String value = params.get(key);
                 //write the bytes read from inputstream
                 dataOutputStream.writeBytes(twoHyphens + boundary + lineEnd);
                 dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"" + lineEnd);
                 dataOutputStream.writeBytes("Content-Type: text/plain" + lineEnd);
                 dataOutputStream.writeBytes(lineEnd);
                 dataOutputStream.writeBytes(value);
                 dataOutputStream.writeBytes(lineEnd);
             }


             dataOutputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);


             serverResponseCode = connection.getResponseCode();


             String serverResponseMessage = connection.getResponseMessage();

             System.out.println("Server Response is: " + serverResponseMessage + ": " + serverResponseCode);

             dataOutputStream.close();
             BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             while ((line = br.readLine()) != null) {
                 System.out.println("response " +line);
                 jsonString.append(line);
             }
             br.close();




             System.out.println("response "+jsonString.toString());

         }
         catch (Exception e) {
             e.printStackTrace();
         }





         //closing the input and output streams
//                 dataOutputStream.flush();
//                 dataOutputStream.close();


     }


 public String SendDataPost(String json1)
    {


        try {

            new AsyncTask<String,String,String>(){
                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                }

                @Override
                protected String doInBackground(String... strings) {

                    SendingRequest(json);
                    diff();
                    String resp=diff1();
                    System.out.println("resp"+resp);
                    uploadFile();
                    return null;
                }
            }.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    public String diff1() {

        HttpURLConnection uc = null;
        StringBuffer jsonString = new StringBuffer();
        try {

            String data = URLEncoder.encode("username", "UTF-8")
                    + "=" + URLEncoder.encode("doc", "UTF-8");

            data += "&" + URLEncoder.encode("password", "UTF-8") + "="
                    + URLEncoder.encode("doc", "UTF-8");

            data += "&" + URLEncoder.encode("deviceToken", "UTF-8")
                    + "=" + URLEncoder.encode("a213213", "UTF-8");

            data += "&" + URLEncoder.encode("deviceType", "UTF-8")
                    + "=" + URLEncoder.encode("android", "UTF-8");
            URL url = new URL("Http://skoolroom.in/vgs_new/webservice/login_post");
            uc = (HttpURLConnection) url.openConnection();
            String line;


            uc.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            uc.setRequestMethod("POST");
            uc.setDoInput(true);
            uc.setInstanceFollowRedirects(false);
            uc.connect();
            OutputStreamWriter writer = new OutputStreamWriter(uc.getOutputStream(), "UTF-8");
            writer.write(data);
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        uc.disconnect();
        return jsonString.toString();
    }
    public void diff()
    {
        String text = "";
        BufferedReader reader=null;
        try
        {

            String data = URLEncoder.encode("username", "UTF-8")
                    + "=" + URLEncoder.encode("doc", "UTF-8");

            data += "&" + URLEncoder.encode("password", "UTF-8") + "="
                    + URLEncoder.encode("doc", "UTF-8");

            data += "&" + URLEncoder.encode("deviceToken", "UTF-8")
                    + "=" + URLEncoder.encode("a213213", "UTF-8");

            data += "&" + URLEncoder.encode("deviceType", "UTF-8")
                    + "=" + URLEncoder.encode("android", "UTF-8");
            // Defined URL  where to send data
            URL url = new URL("Http://skoolroom.in/vgs_new/webservice/login_post");


            // Send POST data request

            URLConnection conn = url.openConnection();

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            // Get the server response

             reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
                System.out.println("sb"+sb);
            }


            text = sb.toString();
            System.out.println("text"+text);
        }
        catch(Exception ex)
        {

        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }

        // Show response on activity
      System.out.println(text);

    }

    public void SendingRequest(String json) {
        try {
            HttpPost post = new HttpPost("Http://skoolroom.in/vgs_new/webservice/login_post");

            StringEntity entity=new StringEntity(json);
            System.out.println(json);
            post.setEntity(entity);
           post.setHeader("Content-Type","application/json");

            DefaultHttpClient client=new DefaultHttpClient();
            BasicResponseHandler handler=new BasicResponseHandler();

            System.out.println(post.toString());

            String response=client.execute(post,handler);
            System.out.println(response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
