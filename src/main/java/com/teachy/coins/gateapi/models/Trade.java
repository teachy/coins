


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
 * Trade
 */
public class Trade {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_CREATE_TIME = "create_time";
    @SerializedName(SERIALIZED_NAME_CREATE_TIME)
    private String createTime;

    /**
     * Order side
     */
    @JsonAdapter(SideEnum.Adapter.class)
    public enum SideEnum {
        BUY("buy"),
        
        SELL("sell");

        private String value;

        SideEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SideEnum fromValue(String value) {
            for (SideEnum b : SideEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<SideEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SideEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SideEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return SideEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_SIDE = "side";
    @SerializedName(SERIALIZED_NAME_SIDE)
    private SideEnum side;

    /**
     * Trade role
     */
    @JsonAdapter(RoleEnum.Adapter.class)
    public enum RoleEnum {
        TAKER("taker"),
        
        MAKER("maker");

        private String value;

        RoleEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static RoleEnum fromValue(String value) {
            for (RoleEnum b : RoleEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<RoleEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RoleEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RoleEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return RoleEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_ROLE = "role";
    @SerializedName(SERIALIZED_NAME_ROLE)
    private RoleEnum role;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private String amount;

    public static final String SERIALIZED_NAME_PRICE = "price";
    @SerializedName(SERIALIZED_NAME_PRICE)
    private String price;

    public static final String SERIALIZED_NAME_ORDER_ID = "order_id";
    @SerializedName(SERIALIZED_NAME_ORDER_ID)
    private String orderId;

    public static final String SERIALIZED_NAME_FEE = "fee";
    @SerializedName(SERIALIZED_NAME_FEE)
    private String fee;

    public static final String SERIALIZED_NAME_FEE_CURRENCY = "fee_currency";
    @SerializedName(SERIALIZED_NAME_FEE_CURRENCY)
    private String feeCurrency;

    public static final String SERIALIZED_NAME_POINT_FEE = "point_fee";
    @SerializedName(SERIALIZED_NAME_POINT_FEE)
    private String pointFee;

    public static final String SERIALIZED_NAME_GT_FEE = "gt_fee";
    @SerializedName(SERIALIZED_NAME_GT_FEE)
    private String gtFee;


    public Trade id(String id) {
        
        this.id = id;
        return this;
    }

     /**
     * Trade ID
     * @return id
    **/

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public Trade createTime(String createTime) {
        
        this.createTime = createTime;
        return this;
    }

     /**
     * Trading time
     * @return createTime
    **/

    public String getCreateTime() {
        return createTime;
    }


    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Trade side(SideEnum side) {
        
        this.side = side;
        return this;
    }

     /**
     * Order side
     * @return side
    **/

    public SideEnum getSide() {
        return side;
    }


    public void setSide(SideEnum side) {
        this.side = side;
    }

    public Trade role(RoleEnum role) {
        
        this.role = role;
        return this;
    }

     /**
     * Trade role
     * @return role
    **/

    public RoleEnum getRole() {
        return role;
    }


    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Trade amount(String amount) {
        
        this.amount = amount;
        return this;
    }

     /**
     * Trade amount
     * @return amount
    **/

    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Trade price(String price) {
        
        this.price = price;
        return this;
    }

     /**
     * Order price
     * @return price
    **/

    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public Trade orderId(String orderId) {
        
        this.orderId = orderId;
        return this;
    }

     /**
     * Related order ID. No value in public endpoints
     * @return orderId
    **/

    public String getOrderId() {
        return orderId;
    }


    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Trade fee(String fee) {
        
        this.fee = fee;
        return this;
    }

     /**
     * Fee deducted. No value in public endpoints
     * @return fee
    **/

    public String getFee() {
        return fee;
    }


    public void setFee(String fee) {
        this.fee = fee;
    }

    public Trade feeCurrency(String feeCurrency) {
        
        this.feeCurrency = feeCurrency;
        return this;
    }

     /**
     * Fee currency unit. No value in public endpoints
     * @return feeCurrency
    **/

    public String getFeeCurrency() {
        return feeCurrency;
    }


    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }

    public Trade pointFee(String pointFee) {
        
        this.pointFee = pointFee;
        return this;
    }

     /**
     * Point used to deduct fee
     * @return pointFee
    **/

    public String getPointFee() {
        return pointFee;
    }


    public void setPointFee(String pointFee) {
        this.pointFee = pointFee;
    }

    public Trade gtFee(String gtFee) {
        
        this.gtFee = gtFee;
        return this;
    }

     /**
     * GT used to deduct fee
     * @return gtFee
    **/

    public String getGtFee() {
        return gtFee;
    }


    public void setGtFee(String gtFee) {
        this.gtFee = gtFee;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Trade trade = (Trade) o;
        return Objects.equals(this.id, trade.id) &&
                Objects.equals(this.createTime, trade.createTime) &&
                Objects.equals(this.side, trade.side) &&
                Objects.equals(this.role, trade.role) &&
                Objects.equals(this.amount, trade.amount) &&
                Objects.equals(this.price, trade.price) &&
                Objects.equals(this.orderId, trade.orderId) &&
                Objects.equals(this.fee, trade.fee) &&
                Objects.equals(this.feeCurrency, trade.feeCurrency) &&
                Objects.equals(this.pointFee, trade.pointFee) &&
                Objects.equals(this.gtFee, trade.gtFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, side, role, amount, price, orderId, fee, feeCurrency, pointFee, gtFee);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Trade {\n");
        sb.append("      id: ").append(toIndentedString(id)).append("\n");
        sb.append("      createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("      side: ").append(toIndentedString(side)).append("\n");
        sb.append("      role: ").append(toIndentedString(role)).append("\n");
        sb.append("      amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("      price: ").append(toIndentedString(price)).append("\n");
        sb.append("      orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("      fee: ").append(toIndentedString(fee)).append("\n");
        sb.append("      feeCurrency: ").append(toIndentedString(feeCurrency)).append("\n");
        sb.append("      pointFee: ").append(toIndentedString(pointFee)).append("\n");
        sb.append("      gtFee: ").append(toIndentedString(gtFee)).append("\n");
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

