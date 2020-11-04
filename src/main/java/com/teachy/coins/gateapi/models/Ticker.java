


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
 * Ticker
 */
public class Ticker {
    public static final String SERIALIZED_NAME_CURRENCY_PAIR = "currency_pair";
    @SerializedName(SERIALIZED_NAME_CURRENCY_PAIR)
    private String currencyPair;

    public static final String SERIALIZED_NAME_LAST = "last";
    @SerializedName(SERIALIZED_NAME_LAST)
    private String last;

    public static final String SERIALIZED_NAME_LOWEST_ASK = "lowest_ask";
    @SerializedName(SERIALIZED_NAME_LOWEST_ASK)
    private String lowestAsk;

    public static final String SERIALIZED_NAME_HIGHEST_BID = "highest_bid";
    @SerializedName(SERIALIZED_NAME_HIGHEST_BID)
    private String highestBid;

    public static final String SERIALIZED_NAME_CHANGE_PERCENTAGE = "change_percentage";
    @SerializedName(SERIALIZED_NAME_CHANGE_PERCENTAGE)
    private String changePercentage;

    public static final String SERIALIZED_NAME_BASE_VOLUME = "base_volume";
    @SerializedName(SERIALIZED_NAME_BASE_VOLUME)
    private String baseVolume;

    public static final String SERIALIZED_NAME_QUOTE_VOLUME = "quote_volume";
    @SerializedName(SERIALIZED_NAME_QUOTE_VOLUME)
    private String quoteVolume;

    public static final String SERIALIZED_NAME_HIGH24H = "high_24h";
    @SerializedName(SERIALIZED_NAME_HIGH24H)
    private String high24h;

    public static final String SERIALIZED_NAME_LOW24H = "low_24h";
    @SerializedName(SERIALIZED_NAME_LOW24H)
    private String low24h;


    public Ticker currencyPair(String currencyPair) {
        
        this.currencyPair = currencyPair;
        return this;
    }

     /**
     * Currency pair
     * @return currencyPair
    **/

    public String getCurrencyPair() {
        return currencyPair;
    }


    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public Ticker last(String last) {
        
        this.last = last;
        return this;
    }

     /**
     * Last trading price
     * @return last
    **/

    public String getLast() {
        return last;
    }


    public void setLast(String last) {
        this.last = last;
    }

    public Ticker lowestAsk(String lowestAsk) {
        
        this.lowestAsk = lowestAsk;
        return this;
    }

     /**
     * Lowest ask
     * @return lowestAsk
    **/

    public String getLowestAsk() {
        return lowestAsk;
    }


    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public Ticker highestBid(String highestBid) {
        
        this.highestBid = highestBid;
        return this;
    }

     /**
     * Highest bid
     * @return highestBid
    **/

    public String getHighestBid() {
        return highestBid;
    }


    public void setHighestBid(String highestBid) {
        this.highestBid = highestBid;
    }

    public Ticker changePercentage(String changePercentage) {
        
        this.changePercentage = changePercentage;
        return this;
    }

     /**
     * Change percentage.
     * @return changePercentage
    **/

    public String getChangePercentage() {
        return changePercentage;
    }


    public void setChangePercentage(String changePercentage) {
        this.changePercentage = changePercentage;
    }

    public Ticker baseVolume(String baseVolume) {
        
        this.baseVolume = baseVolume;
        return this;
    }

     /**
     * Base currency trade volume
     * @return baseVolume
    **/

    public String getBaseVolume() {
        return baseVolume;
    }


    public void setBaseVolume(String baseVolume) {
        this.baseVolume = baseVolume;
    }

    public Ticker quoteVolume(String quoteVolume) {
        
        this.quoteVolume = quoteVolume;
        return this;
    }

     /**
     * Quote currency trade volume
     * @return quoteVolume
    **/

    public String getQuoteVolume() {
        return quoteVolume;
    }


    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public Ticker high24h(String high24h) {
        
        this.high24h = high24h;
        return this;
    }

     /**
     * Highest price in 24h
     * @return high24h
    **/

    public String getHigh24h() {
        return high24h;
    }


    public void setHigh24h(String high24h) {
        this.high24h = high24h;
    }

    public Ticker low24h(String low24h) {
        
        this.low24h = low24h;
        return this;
    }

     /**
     * Lowest price in 24h
     * @return low24h
    **/

    public String getLow24h() {
        return low24h;
    }


    public void setLow24h(String low24h) {
        this.low24h = low24h;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticker ticker = (Ticker) o;
        return Objects.equals(this.currencyPair, ticker.currencyPair) &&
                Objects.equals(this.last, ticker.last) &&
                Objects.equals(this.lowestAsk, ticker.lowestAsk) &&
                Objects.equals(this.highestBid, ticker.highestBid) &&
                Objects.equals(this.changePercentage, ticker.changePercentage) &&
                Objects.equals(this.baseVolume, ticker.baseVolume) &&
                Objects.equals(this.quoteVolume, ticker.quoteVolume) &&
                Objects.equals(this.high24h, ticker.high24h) &&
                Objects.equals(this.low24h, ticker.low24h);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyPair, last, lowestAsk, highestBid, changePercentage, baseVolume, quoteVolume, high24h, low24h);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Ticker {\n");
        sb.append("      currencyPair: ").append(toIndentedString(currencyPair)).append("\n");
        sb.append("      last: ").append(toIndentedString(last)).append("\n");
        sb.append("      lowestAsk: ").append(toIndentedString(lowestAsk)).append("\n");
        sb.append("      highestBid: ").append(toIndentedString(highestBid)).append("\n");
        sb.append("      changePercentage: ").append(toIndentedString(changePercentage)).append("\n");
        sb.append("      baseVolume: ").append(toIndentedString(baseVolume)).append("\n");
        sb.append("      quoteVolume: ").append(toIndentedString(quoteVolume)).append("\n");
        sb.append("      high24h: ").append(toIndentedString(high24h)).append("\n");
        sb.append("      low24h: ").append(toIndentedString(low24h)).append("\n");
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

