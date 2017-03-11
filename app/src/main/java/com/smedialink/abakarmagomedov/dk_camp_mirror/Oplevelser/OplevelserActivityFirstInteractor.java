package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;


import android.util.Log;

import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discount;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discounts;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Home;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;
import com.smedialink.abakarmagomedov.dk_camp_mirror.network.ApiDiscountService;
import com.smedialink.abakarmagomedov.dk_camp_mirror.network.ApiDkService;
import com.smedialink.abakarmagomedov.dk_camp_mirror.network.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OplevelserActivityFirstInteractor implements OplevelserActivityInteractor {

    private static Retrofit.Builder sBuilder = new Retrofit.Builder().baseUrl(ApiDiscountService.BASE_URL);
    private final Home mHome;

    public OplevelserActivityFirstInteractor(Home home) {
        mHome = home;
    }


    @Override
    public void fetchOplevelsers(final OnFinishedListener listener) {
        Call<Discounts> call = ServiceGenerator.createService(ApiDiscountService.class, sBuilder).getOplevelser();
        call.enqueue(new Callback<Discounts>() {
            @Override
            public void onResponse(Call<Discounts> call, Response<Discounts> response) {
                Log.d("TAG", "success");
                for(Discount discount : response.body().getData()){
                    discount.setDetails(App.parseHtml(discount.getDetails()));
                    discount.setTitle(App.parseHtml(discount.getTitle()));
                }
                listener.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<Discounts> call, Throwable t) {
              listener.onError();
            }
        });

    }

    @Override
    public void setFocused(Discount discount) {
        mHome.setFocusedItem(discount);
    }
}
