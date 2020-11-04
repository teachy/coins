


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
 * RepayRequest
 */
public class RepayRequest {
    public static final String SERIALIZED_NAME_CURRENCY_PAIR = "currency_pair";
    @SerializedName(SERIALIZED_NAME_CURRENCY_PAIR)
    private String currencyPair;

    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    /**
     * Repay mode. all - repay all; partial - repay only some portion
     */
    @JsonAdapter(ModeEnum.Adapter.class)
    public enum ModeEnum {
        ALL("all"),
        
        PARTIAL("partial");

        private String value;

        ModeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ModeEnum fromValue(String value) {
            for (ModeEnum b : ModeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<ModeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ModeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ModeEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return ModeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_MODE = "mode";
    @SerializedName(SERIALIZED_NAME_MODE)
    private ModeEnum mode;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private String amount;


    public RepayRequest currencyPair(String currencyPair) {
        
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

    public RepayRequest currency(String currency) {
        
        this.currency = currency;
        return this;
    }

     /**
     * Loan currency
     * @return currency
    **/
    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public RepayRequest mode(ModeEnum mode) {
        
        this.mode = mode;
        return this;
    }

     /**
     * Repay mode. all - repay all; partial - repay only some portion
     * @return mode
    **/
    public ModeEnum getMode() {
        return mode;
    }


    public void setMode(ModeEnum mode) {
        this.mode = mode;
    }

    public RepayRequest amount(String amount) {
        
        this.amount = amount;
        return this;
    }

     /**
     * Repay amount. Required in &#x60;partial&#x60; mode
     * @return amount
    **/

    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RepayRequest repayRequest = (RepayRequest) o;
        return Objects.equals(this.currencyPair, repayRequest.currencyPair) &&
                Objects.equals(this.currency, repayRequest.currency) &&
                Objects.equals(this.mode, repayRequest.mode) &&
                Objects.equals(this.amount, repayRequest.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyPair, currency, mode, amount);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RepayRequest {\n");
        sb.append("      currencyPair: ").append(toIndentedString(currencyPair)).append("\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("      amount: ").append(toIndentedString(amount)).append("\n");
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

