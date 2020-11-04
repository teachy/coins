


package com.teachy.coins.gateapi.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * OrderBook
 */
public class OrderBook {
    public static final String SERIALIZED_NAME_ASKS = "asks";
    @SerializedName(SERIALIZED_NAME_ASKS)
    private List<List<String>> asks = new ArrayList<>();

    public static final String SERIALIZED_NAME_BIDS = "bids";
    @SerializedName(SERIALIZED_NAME_BIDS)
    private List<List<String>> bids = new ArrayList<>();


    public OrderBook asks(List<List<String>> asks) {
        
        this.asks = asks;
        return this;
    }

    public OrderBook addAsksItem(List<String> asksItem) {
        this.asks.add(asksItem);
        return this;
    }

     /**
     * Asks order depth
     * @return asks
    **/
    public List<List<String>> getAsks() {
        return asks;
    }


    public void setAsks(List<List<String>> asks) {
        this.asks = asks;
    }

    public OrderBook bids(List<List<String>> bids) {
        
        this.bids = bids;
        return this;
    }

    public OrderBook addBidsItem(List<String> bidsItem) {
        this.bids.add(bidsItem);
        return this;
    }

     /**
     * Bids order depth
     * @return bids
    **/
    public List<List<String>> getBids() {
        return bids;
    }


    public void setBids(List<List<String>> bids) {
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
        OrderBook orderBook = (OrderBook) o;
        return Objects.equals(this.asks, orderBook.asks) &&
                Objects.equals(this.bids, orderBook.bids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asks, bids);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OrderBook {\n");
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

