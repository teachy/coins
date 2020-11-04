


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
 * MyFuturesTrade
 */
public class MyFuturesTrade {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private Long id;

    public static final String SERIALIZED_NAME_CREATE_TIME = "create_time";
    @SerializedName(SERIALIZED_NAME_CREATE_TIME)
    private BigDecimal createTime;

    public static final String SERIALIZED_NAME_CONTRACT = "contract";
    @SerializedName(SERIALIZED_NAME_CONTRACT)
    private String contract;

    public static final String SERIALIZED_NAME_ORDER_ID = "order_id";
    @SerializedName(SERIALIZED_NAME_ORDER_ID)
    private String orderId;

    public static final String SERIALIZED_NAME_SIZE = "size";
    @SerializedName(SERIALIZED_NAME_SIZE)
    private Long size;

    public static final String SERIALIZED_NAME_PRICE = "price";
    @SerializedName(SERIALIZED_NAME_PRICE)
    private String price;

    /**
     * Trade role. Available values are &#x60;taker&#x60; and &#x60;maker&#x60;
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


    public MyFuturesTrade id(Long id) {
        
        this.id = id;
        return this;
    }

     /**
     * Trade ID
     * @return id
    **/

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public MyFuturesTrade createTime(BigDecimal createTime) {
        
        this.createTime = createTime;
        return this;
    }

     /**
     * Trading time
     * @return createTime
    **/

    public BigDecimal getCreateTime() {
        return createTime;
    }


    public void setCreateTime(BigDecimal createTime) {
        this.createTime = createTime;
    }

    public MyFuturesTrade contract(String contract) {
        
        this.contract = contract;
        return this;
    }

     /**
     * Futures contract
     * @return contract
    **/

    public String getContract() {
        return contract;
    }


    public void setContract(String contract) {
        this.contract = contract;
    }

    public MyFuturesTrade orderId(String orderId) {
        
        this.orderId = orderId;
        return this;
    }

     /**
     * Order ID related
     * @return orderId
    **/

    public String getOrderId() {
        return orderId;
    }


    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public MyFuturesTrade size(Long size) {
        
        this.size = size;
        return this;
    }

     /**
     * Trading size
     * @return size
    **/

    public Long getSize() {
        return size;
    }


    public void setSize(Long size) {
        this.size = size;
    }

    public MyFuturesTrade price(String price) {
        
        this.price = price;
        return this;
    }

     /**
     * Trading price
     * @return price
    **/

    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public MyFuturesTrade role(RoleEnum role) {
        
        this.role = role;
        return this;
    }

     /**
     * Trade role. Available values are &#x60;taker&#x60; and &#x60;maker&#x60;
     * @return role
    **/

    public RoleEnum getRole() {
        return role;
    }


    public void setRole(RoleEnum role) {
        this.role = role;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyFuturesTrade myFuturesTrade = (MyFuturesTrade) o;
        return Objects.equals(this.id, myFuturesTrade.id) &&
                Objects.equals(this.createTime, myFuturesTrade.createTime) &&
                Objects.equals(this.contract, myFuturesTrade.contract) &&
                Objects.equals(this.orderId, myFuturesTrade.orderId) &&
                Objects.equals(this.size, myFuturesTrade.size) &&
                Objects.equals(this.price, myFuturesTrade.price) &&
                Objects.equals(this.role, myFuturesTrade.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, contract, orderId, size, price, role);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MyFuturesTrade {\n");
        sb.append("      id: ").append(toIndentedString(id)).append("\n");
        sb.append("      createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("      contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("      orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("      size: ").append(toIndentedString(size)).append("\n");
        sb.append("      price: ").append(toIndentedString(price)).append("\n");
        sb.append("      role: ").append(toIndentedString(role)).append("\n");
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

