


package com.teachy.coins.gateapi.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 * FundingRateRecord
 */
public class FundingRateRecord {
    public static final String SERIALIZED_NAME_T = "t";
    @SerializedName(SERIALIZED_NAME_T)
    private Long t;

    public static final String SERIALIZED_NAME_R = "r";
    @SerializedName(SERIALIZED_NAME_R)
    private String r;


    public FundingRateRecord t(Long t) {
        
        this.t = t;
        return this;
    }

     /**
     * Unix timestamp in seconds
     * @return t
    **/

    public Long getT() {
        return t;
    }


    public void setT(Long t) {
        this.t = t;
    }

    public FundingRateRecord r(String r) {
        
        this.r = r;
        return this;
    }

     /**
     * Funding rate
     * @return r
    **/

    public String getR() {
        return r;
    }


    public void setR(String r) {
        this.r = r;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FundingRateRecord fundingRateRecord = (FundingRateRecord) o;
        return Objects.equals(this.t, fundingRateRecord.t) &&
                Objects.equals(this.r, fundingRateRecord.r);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, r);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FundingRateRecord {\n");
        sb.append("      t: ").append(toIndentedString(t)).append("\n");
        sb.append("      r: ").append(toIndentedString(r)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n        ");
    }

}

