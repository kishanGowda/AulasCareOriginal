package com.example.aulascare.Api;



import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface LoginService {

    String token = "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTg1MywicGhvbmUiOiIrOTE4ODg0ODMxMjg0IiwidXJsIjoidGVzdC50aGVjbGFzc3Jvb20uYml6Iiwib3JnSWQiOiI0Y2IyNTA5ZC03MGY1LTQzNWUtODc5Mi1kMjQ5Mzc3NDNiNTMiLCJicm93c2VyTG9naW5Db2RlIjpudWxsLCJkZXZpY2VMb2dpbkNvZGUiOiIrOTE4ODg0ODMxMjg0MTg1MzIwOGY3ODcwLTY2ZmYtNDJlZi04OWI5LWY3MDk0M2U3YWZmNiIsImlhdCI6MTY1OTUxNjE4Nn0.xsqorjlatNNWDOucp-pJ1M7Hh7IRbbgVgKX_u-6RRcY";
    String link = "orgurl:test.theclassroom.biz";

    //get care data admin
    @Headers({token, link})
    @GET("care")
    Call<GetCareDataAdminResponse> GET_CARE_DATA_ADMIN_RESPONSE_CALL();
//
    @Headers({token, link})
    @GET("care/admin")
    Call<GetUserDetailsResponse> GET_USER_DETAILS_RESPONSE_CALL(@QueryMap Map<String,String> quesry);
//}
}
