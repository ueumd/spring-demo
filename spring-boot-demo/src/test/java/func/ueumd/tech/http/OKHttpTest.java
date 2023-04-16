package func.ueumd.tech.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * OKHttp3
 * https://blog.csdn.net/gqg_guan/article/details/126603225
 */
public class OKHttpTest {

    @Test
    public void test() throws InterruptedException {
        //1. 构建OkHttpClient实例
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS) //链接超时为2秒，单位为秒
                .writeTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();

        // 2. 通过Builder辅助类构建请求对象
        final Request  request = new Request.Builder()
                .url("https://www.zhihu.com/api/v4/columns/c_1060581544644718592/items")
                .get()
                .build();

        System.out.println(request);

        // 创建线程，在子线程中运行
        new Thread(() -> {
            try {

                //3. 通过mOkHttpClient调用请求得到Call
                final Call call = okHttpClient.newCall(request);

                //4. 执行同步请求，获取响应体Response对象
                Response response = call.execute();
                System.out.println("response=" + response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(5000);
    }

    @Test
    public void test2() throws IOException {
        OkHttpClient client = new OkHttpClient();

        String url = "https://www.zhihu.com/api/v4/v columns/c_1060581544644718592/items";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        ResponseBody body = response.body();

        String result = body.string();


        JSONObject json = JSON.parseObject(result);
        System.out.println(json.get("paging"));
    }
}
