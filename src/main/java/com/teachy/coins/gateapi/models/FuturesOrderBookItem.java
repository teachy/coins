


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
 * FuturesOrderBookItem
 */
public class FuturesOrderBookItem {
    public static final String SERIALIZED_NAME_P = "p";
    @SerializedName(SERIALIZED_NAME_P)
    private String p;

    public static final String SERIALIZED_NAME_S = "s";
    @SerializedName(SERIALIZED_NAME_S)
    private Long s;


    public FuturesOrderBookItem p(String p) {
        
        this.p = p;
        return this;
    }

     /**
     * Price
     * @return p
    **/

    public String getP() {
        return p;
    }


    public void setP(String p) {
        this.p = p;
    }

    public FuturesOrderBookItem s(Long s) {
        
        this.s = s;
        return this;
    }

     /**
     * Size
     * @return s
    **/

    public Long getS() {
        return s;
    }


    public void setS(Long s) {
        this.s = s;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FuturesOrderBookItem futuresOrderBookItem = (FuturesOrderBookItem) o;
        return Objects.equals(this.p, futuresOrderBookItem.p) &&
                Objects.equals(this.s, futuresOrderBookItem.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, s);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FuturesOrderBookItem {\n");
        sb.append("      p: ").append(toIndentedString(p)).append("\n");
        sb.append("      s: ").append(toIndentedString(s)).append("\n");
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

