


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
 * MarginAccountBook
 */
public class MarginAccountBook {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_TIME = "time";
    @SerializedName(SERIALIZED_NAME_TIME)
    private String time;

    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_CURRENCY_PAIR = "currency_pair";
    @SerializedName(SERIALIZED_NAME_CURRENCY_PAIR)
    private String currencyPair;

    public static final String SERIALIZED_NAME_CHANGE = "change";
    @SerializedName(SERIALIZED_NAME_CHANGE)
    private String change;

    public static final String SERIALIZED_NAME_BALANCE = "balance";
    @SerializedName(SERIALIZED_NAME_BALANCE)
    private String balance;


    public MarginAccountBook id(String id) {
        
        this.id = id;
        return this;
    }

     /**
     * Balance change record ID
     * @return id
    **/

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public MarginAccountBook time(String time) {
        
        this.time = time;
        return this;
    }

     /**
     * Balance changed timestamp
     * @return time
    **/

    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }

    public MarginAccountBook currency(String currency) {
        
        this.currency = currency;
        return this;
    }

     /**
     * Currency changed
     * @return currency
    **/

    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public MarginAccountBook currencyPair(String currencyPair) {
        
        this.currencyPair = currencyPair;
        return this;
    }

     /**
     * Account currency pair
     * @return currencyPair
    **/

    public String getCurrencyPair() {
        return currencyPair;
    }


    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public MarginAccountBook change(String change) {
        
        this.change = change;
        return this;
    }

     /**
     * Amount changed. Positive value means transferring in, while negative out
     * @return change
    **/

    public String getChange() {
        return change;
    }


    public void setChange(String change) {
        this.change = change;
    }

    public MarginAccountBook balance(String balance) {
        
        this.balance = balance;
        return this;
    }

     /**
     * Balance after change
     * @return balance
    **/

    public String getBalance() {
        return balance;
    }


    public void setBalance(String balance) {
        this.balance = balance;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarginAccountBook marginAccountBook = (MarginAccountBook) o;
        return Objects.equals(this.id, marginAccountBook.id) &&
                Objects.equals(this.time, marginAccountBook.time) &&
                Objects.equals(this.currency, marginAccountBook.currency) &&
                Objects.equals(this.currencyPair, marginAccountBook.currencyPair) &&
                Objects.equals(this.change, marginAccountBook.change) &&
                Objects.equals(this.balance, marginAccountBook.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, currency, currencyPair, change, balance);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MarginAccountBook {\n");
        sb.append("      id: ").append(toIndentedString(id)).append("\n");
        sb.append("      time: ").append(toIndentedString(time)).append("\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      currencyPair: ").append(toIndentedString(currencyPair)).append("\n");
        sb.append("      change: ").append(toIndentedString(change)).append("\n");
        sb.append("      balance: ").append(toIndentedString(balance)).append("\n");
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

