


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
 * SubAccountTransfer
 */
public class SubAccountTransfer {
    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_SUB_ACCOUNT = "sub_account";
    @SerializedName(SERIALIZED_NAME_SUB_ACCOUNT)
    private String subAccount;

    /**
     * Transfer direction. to - transfer into sub account; from - transfer out from sub account
     */
    @JsonAdapter(DirectionEnum.Adapter.class)
    public enum DirectionEnum {
        TO("to"),
        
        FROM("from");

        private String value;

        DirectionEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static DirectionEnum fromValue(String value) {
            for (DirectionEnum b : DirectionEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<DirectionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final DirectionEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public DirectionEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return DirectionEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_DIRECTION = "direction";
    @SerializedName(SERIALIZED_NAME_DIRECTION)
    private DirectionEnum direction;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private String amount;

    public static final String SERIALIZED_NAME_UID = "uid";
    @SerializedName(SERIALIZED_NAME_UID)
    private String uid;

    public static final String SERIALIZED_NAME_TIMEST = "timest";
    @SerializedName(SERIALIZED_NAME_TIMEST)
    private String timest;

    public static final String SERIALIZED_NAME_SOURCE = "source";
    @SerializedName(SERIALIZED_NAME_SOURCE)
    private String source;


    public SubAccountTransfer currency(String currency) {
        
        this.currency = currency;
        return this;
    }

     /**
     * Transfer currency name
     * @return currency
    **/
    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public SubAccountTransfer subAccount(String subAccount) {
        
        this.subAccount = subAccount;
        return this;
    }

     /**
     * Sub account user ID
     * @return subAccount
    **/
    public String getSubAccount() {
        return subAccount;
    }


    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
    }

    public SubAccountTransfer direction(DirectionEnum direction) {
        
        this.direction = direction;
        return this;
    }

     /**
     * Transfer direction. to - transfer into sub account; from - transfer out from sub account
     * @return direction
    **/
    public DirectionEnum getDirection() {
        return direction;
    }


    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public SubAccountTransfer amount(String amount) {
        
        this.amount = amount;
        return this;
    }

     /**
     * Transfer amount
     * @return amount
    **/
    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

     /**
     * Main account user ID
     * @return uid
    **/

    public String getUid() {
        return uid;
    }


     /**
     * Transfer timestamp
     * @return timest
    **/

    public String getTimest() {
        return timest;
    }


     /**
     * Where the operation is initiated from
     * @return source
    **/

    public String getSource() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubAccountTransfer subAccountTransfer = (SubAccountTransfer) o;
        return Objects.equals(this.currency, subAccountTransfer.currency) &&
                Objects.equals(this.subAccount, subAccountTransfer.subAccount) &&
                Objects.equals(this.direction, subAccountTransfer.direction) &&
                Objects.equals(this.amount, subAccountTransfer.amount) &&
                Objects.equals(this.uid, subAccountTransfer.uid) &&
                Objects.equals(this.timest, subAccountTransfer.timest) &&
                Objects.equals(this.source, subAccountTransfer.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, subAccount, direction, amount, uid, timest, source);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubAccountTransfer {\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      subAccount: ").append(toIndentedString(subAccount)).append("\n");
        sb.append("      direction: ").append(toIndentedString(direction)).append("\n");
        sb.append("      amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("      uid: ").append(toIndentedString(uid)).append("\n");
        sb.append("      timest: ").append(toIndentedString(timest)).append("\n");
        sb.append("      source: ").append(toIndentedString(source)).append("\n");
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

