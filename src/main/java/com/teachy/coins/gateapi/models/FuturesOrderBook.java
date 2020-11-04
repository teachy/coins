


package com.teachy.coins.gateapi.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.teachy.coins.gateapi.models.FuturesOrderBookItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FuturesOrderBook
 */
public class FuturesOrderBook {
    public static final String SERIALIZED_NAME_ASKS = "asks";
    @SerializedName(SERIALIZED_NAME_ASKS)
    private List<FuturesOrderBookItem> asks = new ArrayList<>();

    public static final String SERIALIZED_NAME_BIDS = "bids";
    @SerializedName(SERIALIZED_NAME_BIDS)
    private List<FuturesOrderBookItem> bids = new ArrayList<>();


    public FuturesOrderBook asks(List<FuturesOrderBookItem> asks) {
        
        this.asks = asks;
        return this;
    }

    public FuturesOrderBook addAsksItem(FuturesOrderBookItem asksItem) {
        this.asks.add(asksItem);
        return this;
    }

     /**
     * Asks order depth
     * @return asks
    **/
    public List<FuturesOrderBookItem> getAsks() {
        return asks;
    }


    public void setAsks(List<FuturesOrderBookItem> asks) {
        this.asks = asks;
    }

    public FuturesOrderBook bids(List<FuturesOrderBookItem> bids) {
        
        this.bids = bids;
        return this;
    }

    public FuturesOrderBook addBidsItem(FuturesOrderBookItem bidsItem) {
        this.bids.add(bidsItem);
        return this;
    }

     /**
     * Bids order depth
     * @return bids
    **/
    public List<FuturesOrderBookItem> getBids() {
        return bids;
    }


    public void setBids(List<FuturesOrderBookItem> bids) {
        this.bids = bids;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FuturesOrderBook futuresOrderBook = (FuturesOrderBook) o;
        return Objects.equals(this.asks, futuresOrderBook.asks) &&
                Objects.equals(this.bids, futuresOrderBook.bids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asks, bids);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FuturesOrderBook {\n");
        sb.append("      asks: ").append(toIndentedString(asks)).append("\n");
        sb.append("      bids: ").append(toIndentedString(bids)).append("\n");
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

