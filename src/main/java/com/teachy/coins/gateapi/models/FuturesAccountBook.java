


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
 * FuturesAccountBook
 */
public class FuturesAccountBook {
    public static final String SERIALIZED_NAME_TIME = "time";
    @SerializedName(SERIALIZED_NAME_TIME)
    private BigDecimal time;

    public static final String SERIALIZED_NAME_CHANGE = "change";
    @SerializedName(SERIALIZED_NAME_CHANGE)
    private String change;

    public static final String SERIALIZED_NAME_BALANCE = "balance";
    @SerializedName(SERIALIZED_NAME_BALANCE)
    private String balance;

    /**
     * Changing Type: - dnw: Deposit &amp; Withdraw - pnl: Profit &amp; Loss by reducing position - fee: Trading fee - refr: Referrer rebate - fund: Funding - point_dnw: POINT Deposit &amp; Withdraw - point_fee: POINT Trading fee - point_refr: POINT Referrer rebate
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        DNW("dnw"),
        
        PNL("pnl"),
        
        FEE("fee"),
        
        REFR("refr"),
        
        FUND("fund"),
        
        POINT_DNW("point_dnw"),
        
        POINT_FEE("point_fee"),
        
        POINT_REFR("point_refr");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return TypeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_TYPE = "type";
    @SerializedName(SERIALIZED_NAME_TYPE)
    private TypeEnum type;

    public static final String SERIALIZED_NAME_TEXT = "text";
    @SerializedName(SERIALIZED_NAME_TEXT)
    private String text;


    public FuturesAccountBook time(BigDecimal time) {
        
        this.time = time;
        return this;
    }

     /**
     * Change time
     * @return time
    **/

    public BigDecimal getTime() {
        return time;
    }


    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public FuturesAccountBook change(String change) {
        
        this.change = change;
        return this;
    }

     /**
     * Change amount
     * @return change
    **/

    public String getChange() {
        return change;
    }


    public void setChange(String change) {
        this.change = change;
    }

    public FuturesAccountBook balance(String balance) {
        
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

    public FuturesAccountBook type(TypeEnum type) {
        
        this.type = type;
        return this;
    }

     /**
     * Changing Type: - dnw: Deposit &amp; Withdraw - pnl: Profit &amp; Loss by reducing position - fee: Trading fee - refr: Referrer rebate - fund: Funding - point_dnw: POINT Deposit &amp; Withdraw - point_fee: POINT Trading fee - point_refr: POINT Referrer rebate
     * @return type
    **/

    public TypeEnum getType() {
        return type;
    }


    public void setType(TypeEnum type) {
        this.type = type;
    }

    public FuturesAccountBook text(String text) {
        
        this.text = text;
        return this;
    }

     /**
     * Comment
     * @return text
    **/

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FuturesAccountBook futuresAccountBook = (FuturesAccountBook) o;
        return Objects.equals(this.time, futuresAccountBook.time) &&
                Objects.equals(this.change, futuresAccountBook.change) &&
                Objects.equals(this.balance, futuresAccountBook.balance) &&
                Objects.equals(this.type, futuresAccountBook.type) &&
                Objects.equals(this.text, futuresAccountBook.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, change, balance, type, text);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FuturesAccountBook {\n");
        sb.append("      time: ").append(toIndentedString(time)).append("\n");
        sb.append("      change: ").append(toIndentedString(change)).append("\n");
        sb.append("      balance: ").append(toIndentedString(balance)).append("\n");
        sb.append("      type: ").append(toIndentedString(type)).append("\n");
        sb.append("      text: ").append(toIndentedString(text)).append("\n");
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

