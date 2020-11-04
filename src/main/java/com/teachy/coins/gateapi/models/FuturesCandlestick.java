


package com.teachy.coins.gateapi.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * data point in every timestamp
 */
public class FuturesCandlestick {
    public static final String SERIALIZED_NAME_T = "t";
    @SerializedName(SERIALIZED_NAME_T)
    private BigDecimal t;

    public static final String SERIALIZED_NAME_V = "v";
    @SerializedName(SERIALIZED_NAME_V)
    private Long v;

    public static final String SERIALIZED_NAME_C = "c";
    @SerializedName(SERIALIZED_NAME_C)
    private String c;

    public static final String SERIALIZED_NAME_H = "h";
    @SerializedName(SERIALIZED_NAME_H)
    private String h;

    public static final String SERIALIZED_NAME_L = "l";
    @SerializedName(SERIALIZED_NAME_L)
    private String l;

    public static final String SERIALIZED_NAME_O = "o";
    @SerializedName(SERIALIZED_NAME_O)
    private String o;


    public FuturesCandlestick t(BigDecimal t) {
        
        this.t = t;
        return this;
    }

     /**
     * Unix timestamp in seconds
     * @return t
    **/

    public BigDecimal getT() {
        return t;
    }


    public void setT(BigDecimal t) {
        this.t = t;
    }

    public FuturesCandlestick v(Long v) {
        
        this.v = v;
        return this;
    }

     /**
     * size volume. Only returned if &#x60;contract&#x60; is not prefixed
     * @return v
    **/

    public Long getV() {
        return v;
    }


    public void setV(Long v) {
        this.v = v;
    }

    public FuturesCandlestick c(String c) {
        
        this.c = c;
        return this;
    }

     /**
     * Close price
     * @return c
    **/

    public String getC() {
        return c;
    }


    public void setC(String c) {
        this.c = c;
    }

    public FuturesCandlestick h(String h) {
        
        this.h = h;
        return this;
    }

     /**
     * Highest price
     * @return h
    **/

    public String getH() {
        return h;
    }


    public void setH(String h) {
        this.h = h;
    }

    public FuturesCandlestick l(String l) {
        
        this.l = l;
        return this;
    }

     /**
     * Lowest price
     * @return l
    **/

    public String getL() {
        return l;
    }


    public void setL(String l) {
        this.l = l;
    }

    public FuturesCandlestick o(String o) {
        
        this.o = o;
        return this;
    }

     /**
     * Open price
     * @return o
    **/

    public String getO() {
        return o;
    }


    public void setO(String o) {
        this.o = o;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FuturesCandlestick futuresCandlestick = (FuturesCandlestick) o;
        return Objects.equals(this.t, futuresCandlestick.t) &&
                Objects.equals(this.v, futuresCandlestick.v) &&
                Objects.equals(this.c, futuresCandlestick.c) &&
                Objects.equals(this.h, futuresCandlestick.h) &&
                Objects.equals(this.l, futuresCandlestick.l) &&
                Objects.equals(this.o, futuresCandlestick.o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, v, c, h, l, o);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FuturesCandlestick {\n");
        sb.append("      t: ").append(toIndentedString(t)).append("\n");
        sb.append("      v: ").append(toIndentedString(v)).append("\n");
        sb.append("      c: ").append(toIndentedString(c)).append("\n");
        sb.append("      h: ").append(toIndentedString(h)).append("\n");
        sb.append("      l: ").append(toIndentedString(l)).append("\n");
        sb.append("      o: ").append(toIndentedString(o)).append("\n");
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

