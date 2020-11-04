


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
 * InsuranceRecord
 */
public class InsuranceRecord {
    public static final String SERIALIZED_NAME_T = "t";
    @SerializedName(SERIALIZED_NAME_T)
    private Long t;

    public static final String SERIALIZED_NAME_B = "b";
    @SerializedName(SERIALIZED_NAME_B)
    private String b;


    public InsuranceRecord t(Long t) {
        
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

    public InsuranceRecord b(String b) {
        
        this.b = b;
        return this;
    }

     /**
     * Insurance balance
     * @return b
    **/

    public String getB() {
        return b;
    }


    public void setB(String b) {
        this.b = b;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InsuranceRecord insuranceRecord = (InsuranceRecord) o;
        return Objects.equals(this.t, insuranceRecord.t) &&
                Objects.equals(this.b, insuranceRecord.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, b);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InsuranceRecord {\n");
        sb.append("      t: ").append(toIndentedString(t)).append("\n");
        sb.append("      b: ").append(toIndentedString(b)).append("\n");
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

