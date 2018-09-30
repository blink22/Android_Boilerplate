package com.blink22.core.domain.client;

import com.blink22.core.domain.URLS;
import com.blink22.core.domain.model.BaseResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ExampleApi {
//    this is example api for retrofit interface
    //Put KEYS HERE for the REQUEST
//    String EMAIL = "email";
//    String PROFILE_IMAGE = "profileImage";
//    String PHONE = "phone";
//    String FIRST_NAME = "firstName";
//    String FACEBOOK_ID = "facebook";
//
//    //    email=dsadas@gmail.com&phone=2001011164679&profileImage=dsadsadas&firstName=m.hemdan&facebook=31232asd
//    @FormUrlEncoded
//    @POST(URLS.REGISTER)
//    Single<BaseResponse> execute(
//            @Field(EMAIL)String email,
//            @Field(PHONE) String phone,
//            @Field(PROFILE_IMAGE)String profileImage,
//            @Field(FIRST_NAME) String firstName,
//            @Field(FACEBOOK_ID) String facebookId);
    @GET
    Single<BaseResponse> executeGetData();
}
