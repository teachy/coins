


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
 * Order cancellation result
 */
public class CancelOrderResult {
    public static final String SERIALIZED_NAME_CURRENCY_PAIR = "currency_pair";
    @SerializedName(SERIALIZED_NAME_CURRENCY_PAIR)
    private String currencyPair;

    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_SUCCEEDED = "succeeded";
    @SerializedName(SERIALIZED_NAME_SUCCEEDED)
    private Boolean succeeded;

    public static final String SERIALIZED_NAME_LABEL = "label";
    @SerializedName(SERIALIZED_NAME_LABEL)
    private String label;

    public static final String SERIALIZED_NAME_MESSAGE = "message";
    @SerializedName(SERIALIZED_NAME_MESSAGE)
    private String message;


    public CancelOrderResult currencyPair(String currencyPair) {
        
        this.currencyPair = currencyPair;
        return this;
    }

     /**
     * Order currency pair
     * @return currencyPair
    **/

    public String getCurrencyPair() {
        return currencyPair;
    }


    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public CancelOrderResult id(String id) {
        
        this.id = id;
        return this;
    }

     /**
     * Order ID
     * @return id
    **/

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public CancelOrderResult succeeded(Boolean succeeded) {
        
        this.succeeded = succeeded;
        return this;
    }

     /**
     * Whether cancellation succeeded
     * @return succeeded
    **/

    public Boolean getSucceeded() {
        return succeeded;
    }


    public void setSucceeded(Boolean succeeded) {
        this.succeeded = succeeded;
    }

    public CancelOrderResult label(String label) {
        
        this.label = label;
        return this;
    }

     /**
     * Error label when failed to cancel the order; emtpy if succeeded
     * @return label
    **/

    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }

    public CancelOrderResult message(String message) {
        
        this.message = message;
        return this;
    }

     /**
     * Error message when failed to cancel the order; empty if succeeded
     * @return message
    **/

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CancelOrderResult cancelOrderResult = (CancelOrderResult) o;
        return Objects.equals(this.currencyPair, cancelOrderResult.currencyPair) &&
                Objects.equals(this.id, cancelOrderResult.id) &&
                Objects.equals(this.succeeded, cancelOrderResult.succeeded) &&
                Objects.equals(this.label, cancelOrderResult.label) &&
                Objects.equals(this.message, cancelOrderResult.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyPair, id, succeeded, label, message);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CancelOrderResult {\n");
        sb.append("      currencyPair: ").append(toIndentedString(currencyPair)).append("\n");
        sb.append("      id: ").append(toIndentedString(id)).append("\n");
        sb.append("      succeeded: ").append(toIndentedString(succeeded)).append("\n");
        sb.append("      label: ").append(toIndentedString(label)).append("\n");
        sb.append("      message: ").append(toIndentedString(message)).append("\n");
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

