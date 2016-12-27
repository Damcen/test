package a.nothing.day5_6;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/12/22.
 */

public interface Api
{
    public final static String URL_TEXT = "http://m2.qiushibaike.com/article/list/text?page=%d";
    public final static String URL_USER_ICON = "http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";
//    id/10000
//    id
//    icon

    @GET("http://m2.qiushibaike.com/article/list/text?")
    Call<Qb> getText(@Query("pager") int pager);

    @GET("http://pic.qiushibaike.com/system/avtnew/{_id}/{id}/thumb/{icon}")
    Call<RequestBody> getUserIcon(@Path("_id") int _id,
                                  @Path("id") int id,
                                  @Path("icon") String icon);
}
