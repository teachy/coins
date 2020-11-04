


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
 * Account currency detail
 */
public class MarginAccountCurrency {
    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_AVAILABLE = "available";
    @SerializedName(SERIALIZED_NAME_AVAILABLE)
    private String available;

    public static final String SERIALIZED_NAME_LOCKED = "locked";
    @SerializedName(SERIALIZED_NAME_LOCKED)
    private String locked;

    public static final String SERIALIZED_NAME_BORROWED = "borrowed";
    @SerializedName(SERIALIZED_NAME_BORROWED)
    private String borrowed;


    public MarginAccountCurrency currency(String currency) {
        
        this.currency = currency;
        return this;
    }

     /**
     * Currency name
     * @return currency
    **/

    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public MarginAccountCurrency available(String available) {
        
        this.available = available;
        return this;
    }

     /**
     * Amount suitable for margin trading.
     * @return available
    **/

    public String getAvailable() {
        return available;
    }


    public void setAvailable(String available) {
        this.available = available;
    }

    public MarginAccountCurrency locked(String locked) {
        
        this.locked = locked;
        return this;
    }

     /**
     * Locked amount, used in margin trading
     * @return locked
    **/

    public String getLocked() {
        return locked;
    }


    public void setLocked(String locked) {
        this.locked = locked;
    }

    public MarginAccountCurrency borrowed(String borrowed) {
        
        this.borrowed = borrowed;
        return this;
    }

     /**
     * Borrowed amount
     * @return borrowed
    **/

    public String getBorrowed() {
        return borrowed;
    }


    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarginAccountCurrency marginAccountCurrency = (MarginAccountCurrency) o;
        return Objects.equals(this.currency, marginAccountCurrency.currency) &&
                Objects.equals(this.available, marginAccountCurrency.available) &&
                Objects.equals(this.locked, marginAccountCurrency.locked) &&
                Objects.equals(this.borrowed, marginAccountCurrency.borrowed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, available, locked, borrowed);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MarginAccountCurrency {\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      available: ").append(toIndentedString(available)).append("\n");
        sb.append("      locked: ").append(toIndentedString(locked)).append("\n");
        sb.append("      borrowed: ").append(toIndentedString(borrowed)).append("\n");
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

