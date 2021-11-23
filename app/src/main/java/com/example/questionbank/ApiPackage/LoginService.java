package com.example.questionbank.ApiPackage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {
    @Headers({
            "version:7",
            "orgurl:brigosha.classroom.digital"
    })

    @POST
    Call<SignInResponse> signInApiCall(@Body SignInRequest signInRequest);
}
