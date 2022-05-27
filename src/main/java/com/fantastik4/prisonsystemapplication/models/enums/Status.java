package com.fantastik4.prisonsystemapplication.models.enums;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public enum Status implements Serializable {
    @SerializedName("0")
    Waiting,
    @SerializedName("1")
    Denied,
    @SerializedName("2")
    Approved,
    @SerializedName("3")
    Fulfilled
}
