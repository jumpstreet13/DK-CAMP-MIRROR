package com.smedialink.abakarmagomedov.dk_camp_mirror.network;

import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Credential;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.POST;



public interface ApiDkService {

    String HEADER_API_TOKEN = "X-API-Client-Token";
    String API_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
            "eyJTaXRlR3VpZCI6IjEyMDAiLCJuYmYiOjE0ODUyNjQ5MzMsImV4cCI6MTUxNjgwMD" +
            "kzMywiaWF0IjoxNDg1MjY0OTMzLCJpc3MiOiJkay5jYW1waW5nLmFwaSJ9.cdkA3DdxzBy" +
            "b3j4ksKhZuYUbGRsmgHZWdPkElKWeQCA";
    String BASE_URL = "http://api.dk-camp.dk/api/";
    String REGISTRATION_URL = "http://fordelsklub.dk-camp.dk/medlemskab.html";
    String LOGIN_URL = "http://fordelsklub.dk-camp.dk/login.html";


    @Headers({
              HEADER_API_TOKEN+":"+ API_TOKEN
    })
    @POST(value = "users/login")
    Call<User> login (@Body Credential credential);
}
