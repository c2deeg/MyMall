
package com.app.mymall.Models.StorePriceTimming;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("coordinates")
    @Expose
    private List<Object> coordinates = null;

    public List<Object> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Object> coordinates) {
        this.coordinates = coordinates;
    }

}
