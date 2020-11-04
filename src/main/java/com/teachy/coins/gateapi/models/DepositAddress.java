


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
 * DepositAddress
 */
public class DepositAddress {
    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_ADDRESS = "address";
    @SerializedName(SERIALIZED_NAME_ADDRESS)
    private String address;


    public DepositAddress currency(String currency) {
        
        this.currency = currency;
        return this;
    }

     /**
     * Currency detail
     * @return currency
    **/
    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public DepositAddress address(String address) {
        
        this.address = address;
        return this;
    }

     /**
     * Deposit address
     * @return address
    **/
    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DepositAddress depositAddress = (DepositAddress) o;
        return Objects.equals(this.currency, depositAddress.currency) &&
                Objects.equals(this.address, depositAddress.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, address);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DepositAddress {\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      address: ").append(toIndentedString(address)).append("\n");
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

