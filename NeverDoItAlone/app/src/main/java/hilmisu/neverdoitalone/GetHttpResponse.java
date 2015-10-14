package hilmisu.neverdoitalone;

import android.os.AsyncTask;
import android.util.Log;

import java.io.*;
import java.net.*;


/**
 * Created by Hakan on 12.10.2015.
 */
public class GetHttpResponse extends AsyncTask<URL, Integer, String> {
    protected String doInBackground(URL... urls) {
        StringBuilder response = new StringBuilder();
        URL url = urls[0];
        URLConnection urlConnection;
        InputStream in;
        try{
            urlConnection = url.openConnection();
            in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            //response = in.toString();
            in.close();
        }catch(Exception exc){
            Log.d("Async Task (HttpGet)","Bir hata oluştu"+exc.getMessage());
        }

        return response.toString();
    }

    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
    }

    protected void onPostExecute(String result) {
        Log.d("Cevap : ",result);
    }
}
