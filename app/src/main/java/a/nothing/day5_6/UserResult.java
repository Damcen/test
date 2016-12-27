package a.nothing.day5_6;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.lang.ref.ReferenceQueue;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/12/22.
 */

public class UserResult implements Api
{
    private Qb qb;
    private int pager;
    private Api api;
    private static UserResult userResult;
    private Context context;

    public static synchronized UserResult getUserResult(Qb qb, int pager)
    {
        if (userResult == null)
            userResult = new UserResult(pager);
        return userResult;
    }

    private UserResult(int pager)
    {
        this.pager = pager;

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(
                String.format(Api.URL_TEXT, 1),
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Gson gson = new Gson();
                        qb = gson.fromJson(response, Qb.class);

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                    }
                });
        queue.add(request);
    }

    @Override
    public Call<Qb> getText(@Query("pager") int pager)
    {
        return api.getText(pager);
    }

    @Override
    public Call<RequestBody> getUserIcon(@Path("_id") int _id, @Path("id") int id, @Path("icon") String icon)
    {
        return api.getUserIcon(_id, id, icon);
    }
}
