package com.blink22.core.domain.model;

import com.blink22.core.util.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by m.hemdan on 8/22/17.
 */

public class BaseResponse {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private JsonElement data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData(String className) {

        try {
            if(data.isJsonArray()){
                Type listType = new TypeToken<List<Object>>(){}.getType();
                return new Gson().fromJson(data, listType);
            }else if(data.isJsonObject()) {
                return new Gson().fromJson(data, Class.forName(className));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }

    public boolean isSuccess(){
        return !status.equals(Constants.FAILURE_STATUS);
    }



}
