package com.lianekai.retrofit.api;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.lianekai.retrofit.pojo.Persion;
import retrofit2.http.Query;

import javax.xml.transform.Result;

/**
 * @author Administrator
 */
@RetrofitClient(baseUrl = "{test.baseUrl}")
public interface HttpApi {
    Result getPersion(@Query("id") Long id);
}
