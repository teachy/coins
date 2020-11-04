


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
 * FuturesTrade
 */
public class FuturesTrade {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private Long id;

    public static final String SERIALIZED_NAME_CREATE_TIME = "create_time";
    @SerializedName(SERIALIZED_NAME_CREATE_TIME)
    private BigDecimal createTime;

    public static final String SERIALIZED_NAME_CONTRACT = "contract";
    @SerializedName(SERIALIZED_NAME_CONTRACT)
    private String contract;

    public static final String SERIALIZED_NAME_SIZE = "size";
    @SerializedName(SERIALIZED_NAME_SIZE)
    private Long size;

    public static final String SERIALIZED_NAME_PRICE = "price";
    @SerializedName(SERIALIZED_NAME_PRICE)
    private String price;


    public FuturesTrade id(Long id) {
        
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

    public FuturesTrade createTime(BigDecimal createTime) {
        
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

    public FuturesTrade contract(String contract) {
        
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

    public FuturesTrade size(Long size) {
        
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

    public FuturesTrade price(String price) {
        
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
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FuturesTrade futuresTrade = (FuturesTrade) o;
        return Objects.equals(this.id, futuresTrade.id) &&
                Objects.equals(this.createTime, futuresTrade.createTime) &&
                Objects.equals(this.contract, futuresTrade.contract) &&
                Objects.equals(this.size, futuresTrade.size) &&
                Objects.equals(this.price, futuresTrade.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, contract, size, price);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FuturesTrade {\n");
        sb.append("      id: ").append(toIndentedString(id)).append("\n");
        sb.append("      createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("      contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("      size: ").append(toIndentedString(size)).append("\n");
        sb.append("      price: ").append(toIndentedString(price)).append("\n");
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

