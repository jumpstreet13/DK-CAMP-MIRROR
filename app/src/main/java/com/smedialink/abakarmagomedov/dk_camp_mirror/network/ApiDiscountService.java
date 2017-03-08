package com.smedialink.abakarmagomedov.dk_camp_mirror.network;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discounts;

import retrofit2.Call;
import retrofit2.http.GET;



public interface ApiDiscountService {

    String BASE_URL = "http://dkcamp.billetsalget.dk";

    @GET(value = "/shop/da/export?token=9b2d07b15d8ab969f97f7ee871bf700c&output=json")
    Call<Discounts> getOplevelser();

}
