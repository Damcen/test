package a.nothing.day5_6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/12/22.
 */

public class MyImage extends AsyncTask<String, Integer, Bitmap>
{
    private ImageView iv;

    public MyImage(ImageView iv)
    {
        this.iv = iv;
    }

    @Override
    protected Bitmap doInBackground(String... strings)
    {
        byte[] bytes = null;
        try
        {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            ByteArrayOutputStream bo = null;
            InputStream is = null;
            if (connection.getResponseCode() == 200)
            {
                is = connection.getInputStream();
                bo = new ByteArrayOutputStream();
                int len = 0;
                byte datas[] = new byte[1024];
                while ((len = is.read(datas)) != -1)
                {
                    bo.write(datas, 0, len);
                    bo.flush();
                }
            }
            return BitmapFactory.decodeByteArray(bo.toByteArray(), 0, bo.toByteArray().length);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap)
    {
        super.onPostExecute(bitmap);
        iv.setImageBitmap(bitmap);
    }
}
