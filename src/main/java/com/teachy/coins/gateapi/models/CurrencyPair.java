


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
 * Spot currency pair
 */
public class CurrencyPair {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_BASE = "base";
    @SerializedName(SERIALIZED_NAME_BASE)
    private String base;

    public static final String SERIALIZED_NAME_QUOTE = "quote";
    @SerializedName(SERIALIZED_NAME_QUOTE)
    private String quote;

    public static final String SERIALIZED_NAME_FEE = "fee";
    @SerializedName(SERIALIZED_NAME_FEE)
    private String fee;

    public static final String SERIALIZED_NAME_MIN_BASE_AMOUNT = "min_base_amount";
    @SerializedName(SERIALIZED_NAME_MIN_BASE_AMOUNT)
    private String minBaseAmount;

    public static final String SERIALIZED_NAME_MIN_QUOTE_AMOUNT = "min_quote_amount";
    @SerializedName(SERIALIZED_NAME_MIN_QUOTE_AMOUNT)
    private String minQuoteAmount;

    public static final String SERIALIZED_NAME_AMOUNT_PRECISION = "amount_precision";
    @SerializedName(SERIALIZED_NAME_AMOUNT_PRECISION)
    private Integer amountPrecision;

    public static final String SERIALIZED_NAME_PRECISION = "precision";
    @SerializedName(SERIALIZED_NAME_PRECISION)
    private Integer precision;

    /**
     * How currency pair can be traded  - untradable: cannot be bought or sold - buyable: can be bought - sellable: can be sold - tradable: can be bought or sold
     */
    @JsonAdapter(TradeStatusEnum.Adapter.class)
    public enum TradeStatusEnum {
        UNTRADABLE("untradable"),
        
        BUYABLE("buyable"),
        
        SELLABLE("sellable"),
        
        TRADABLE("tradable");

        private String value;

        TradeStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TradeStatusEnum fromValue(String value) {
            for (TradeStatusEnum b : TradeStatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<TradeStatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TradeStatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TradeStatusEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return TradeStatusEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_TRADE_STATUS = "trade_status";
    @SerializedName(SERIALIZED_NAME_TRADE_STATUS)
    private TradeStatusEnum tradeStatus;


    public CurrencyPair id(String id) {
        
        this.id = id;
        return this;
    }

     /**
     * Currency pair
     * @return id
    **/

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public CurrencyPair base(String base) {
        
        this.base = base;
        return this;
    }

     /**
     * Base currency
     * @return base
    **/

    public String getBase() {
        return base;
    }


    public void setBase(String base) {
        this.base = base;
    }

    public CurrencyPair quote(String quote) {
        
        this.quote = quote;
        return this;
    }

     /**
     * Quote currency
     * @return quote
    **/

    public String getQuote() {
        return quote;
    }


    public void setQuote(String quote) {
        this.quote = quote;
    }

    public CurrencyPair fee(String fee) {
        
        this.fee = fee;
        return this;
    }

     /**
     * Trading fee
     * @return fee
    **/

    public String getFee() {
        return fee;
    }


    public void setFee(String fee) {
        this.fee = fee;
    }

    public CurrencyPair minBaseAmount(String minBaseAmount) {
        
        this.minBaseAmount = minBaseAmount;
        return this;
    }

     /**
     * Minimum amount of base currency to trade, &#x60;null&#x60; means no limit
     * @return minBaseAmount
    **/

    public String getMinBaseAmount() {
        return minBaseAmount;
    }


    public void setMinBaseAmount(String minBaseAmount) {
        this.minBaseAmount = minBaseAmount;
    }

    public CurrencyPair minQuoteAmount(String minQuoteAmount) {
        
        this.minQuoteAmount = minQuoteAmount;
        return this;
    }

     /**
     * Minimum amount of quote currency to trade, &#x60;null&#x60; means no limit
     * @return minQuoteAmount
    **/

    public String getMinQuoteAmount() {
        return minQuoteAmount;
    }


    public void setMinQuoteAmount(String minQuoteAmount) {
        this.minQuoteAmount = minQuoteAmount;
    }

    public CurrencyPair amountPrecision(Integer amountPrecision) {
        
        this.amountPrecision = amountPrecision;
        return this;
    }

     /**
     * Amount scale
     * @return amountPrecision
    **/

    public Integer getAmountPrecision() {
        return amountPrecision;
    }


    public void setAmountPrecision(Integer amountPrecision) {
        this.amountPrecision = amountPrecision;
    }

    public CurrencyPair precision(Integer precision) {
        
        this.precision = precision;
        return this;
    }

     /**
     * Price scale
     * @return precision
    **/

    public Integer getPrecision() {
        return precision;
    }


    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public CurrencyPair tradeStatus(TradeStatusEnum tradeStatus) {
        
        this.tradeStatus = tradeStatus;
        return this;
    }

     /**
     * How currency pair can be traded  - untradable: cannot be bought or sold - buyable: can be bought - sellable: can be sold - tradable: can be bought or sold
     * @return tradeStatus
    **/

    public TradeStatusEnum getTradeStatus() {
        return tradeStatus;
    }


    public void setTradeStatus(TradeStatusEnum tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CurrencyPair currencyPair = (CurrencyPair) o;
        return Objects.equals(this.id, currencyPair.id) &&
                Objects.equals(this.base, currencyPair.base) &&
                Objects.equals(this.quote, currencyPair.quote) &&
                Objects.equals(this.fee, currencyPair.fee) &&
                Objects.equals(this.minBaseAmount, currencyPair.minBaseAmount) &&
                Objects.equals(this.minQuoteAmount, currencyPair.minQuoteAmount) &&
                Objects.equals(this.amountPrecision, currencyPair.amountPrecision) &&
                Objects.equals(this.precision, currencyPair.precision) &&
                Objects.equals(this.tradeStatus, currencyPair.tradeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, base, quote, fee, minBaseAmount, minQuoteAmount, amountPrecision, precision, tradeStatus);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CurrencyPair {\n");
        sb.append("      id: ").append(toIndentedString(id)).append("\n");
        sb.append("      base: ").append(toIndentedString(base)).append("\n");
        sb.append("      quote: ").append(toIndentedString(quote)).append("\n");
        sb.append("      fee: ").append(toIndentedString(fee)).append("\n");
        sb.append("      minBaseAmount: ").append(toIndentedString(minBaseAmount)).append("\n");
        sb.append("      minQuoteAmount: ").append(toIndentedString(minQuoteAmount)).append("\n");
        sb.append("      amountPrecision: ").append(toIndentedString(amountPrecision)).append("\n");
        sb.append("      precision: ").append(toIndentedString(precision)).append("\n");
        sb.append("      tradeStatus: ").append(toIndentedString(tradeStatus)).append("\n");
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

