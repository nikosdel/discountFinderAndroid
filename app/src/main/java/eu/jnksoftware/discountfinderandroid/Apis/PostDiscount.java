package eu.jnksoftware.discountfinderandroid.Apis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PostDiscount {

    @SerializedName("logPos")
    @Expose
    private double logPos;

    @SerializedName("latPos")
    @Expose
    private double latPos;

    @SerializedName("distanceInMeters")
    @Expose
    private int distanceInMeters;

    public PostDiscount(double logPos, double latPos, int distanceInMeters) {
        this.logPos = logPos;
        this.latPos = latPos;
        this.distanceInMeters = distanceInMeters;
    }
}
