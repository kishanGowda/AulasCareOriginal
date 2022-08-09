package com.example.aulascare.AulasCareStudent.Api;





import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface LoginService {
    String token = "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTg1MSwicGhvbmUiOiIrOTE4ODg0ODMxMjgyIiwidXJsIjoidGVzdC50aGVjbGFzc3Jvb20uYml6Iiwib3JnSWQiOiI0Y2IyNTA5ZC03MGY1LTQzNWUtODc5Mi1kMjQ5Mzc3NDNiNTMiLCJicm93c2VyTG9naW5Db2RlIjpudWxsLCJkZXZpY2VMb2dpbkNvZGUiOiIrOTE4ODg0ODMxMjgyMTg1MWJiOTBhODc3LWE0YzktNDE5MC04ZmI1LWFlOWRlNDdmZTQ2MiIsImlhdCI6MTY1OTk2NzkyNX0.BBAKbfv0CydKCR76Nm_x43OOm3GBTaFBlYcX4Vx30m8";

    String link = "orgurl:test.theclassroom.biz";

    //get care data admin
    @Headers({token, link})
    @GET("care")
    Call<FsqResponse> GET_CARE_DATA_ADMIN_RESPONSE_CALL();
//
//    @Headers({token, link})
//    @GET("care/admin")
//    Call<> GET_USER_DETAILS_RESPONSE_CALL(@QueryMap Map<String,String> query);
////
//    @Headers({token, link})
//    @GET("care/admin/user-conversation")
//    Call<GetStatusAndChatResponse> GET_STATUS_AND_CHAT_RESPONSE_CALL(@QueryMap Map<String,String> query);
//}
}
