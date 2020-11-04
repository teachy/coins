


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
 * FuturesInitialOrder
 */
public class FuturesInitialOrder {
    public static final String SERIALIZED_NAME_CONTRACT = "contract";
    @SerializedName(SERIALIZED_NAME_CONTRACT)
    private String contract;

    public static final String SERIALIZED_NAME_SIZE = "size";
    @SerializedName(SERIALIZED_NAME_SIZE)
    private Long size;

    public static final String SERIALIZED_NAME_PRICE = "price";
    @SerializedName(SERIALIZED_NAME_PRICE)
    private String price;

    public static final String SERIALIZED_NAME_CLOSE = "close";
    @SerializedName(SERIALIZED_NAME_CLOSE)
    private Boolean close = false;

    /**
     * Time in force. If using market price, only &#x60;ioc&#x60; is supported.  - gtc: GoodTillCancelled - ioc: ImmediateOrCancelled
     */
    @JsonAdapter(TifEnum.Adapter.class)
    public enum TifEnum {
        GTC("gtc"),
        
        IOC("ioc");

        private String value;

        TifEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TifEnum fromValue(String value) {
            for (TifEnum b : TifEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<TifEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TifEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TifEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return TifEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_TIF = "tif";
    @SerializedName(SERIALIZED_NAME_TIF)
    private TifEnum tif = TifEnum.GTC;

    public static final String SERIALIZED_NAME_TEXT = "text";
    @SerializedName(SERIALIZED_NAME_TEXT)
    private String text;

    public static final String SERIALIZED_NAME_REDUCE_ONLY = "reduce_only";
    @SerializedName(SERIALIZED_NAME_REDUCE_ONLY)
    private Boolean reduceOnly = false;

    public static final String SERIALIZED_NAME_IS_REDUCE_ONLY = "is_reduce_only";
    @SerializedName(SERIALIZED_NAME_IS_REDUCE_ONLY)
    private Boolean isReduceOnly;

    public static final String SERIALIZED_NAME_IS_CLOSE = "is_close";
    @SerializedName(SERIALIZED_NAME_IS_CLOSE)
    private Boolean isClose;


    public FuturesInitialOrder contract(String contract) {
        
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

    public FuturesInitialOrder size(Long size) {
        
        this.size = size;
        return this;
    }

     /**
     * Order size. Positive size means to buy, while negative one means to sell. Set to 0 to close the position
     * @return size
    **/

    public Long getSize() {
        return size;
    }


    public void setSize(Long size) {
        this.size = size;
    }

    public FuturesInitialOrder price(String price) {
        
        this.price = price;
        return this;
    }

     /**
     * Order price. Set to 0 to use market price
     * @return price
    **/
    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public FuturesInitialOrder close(Boolean close) {
        
        this.close = close;
        return this;
    }

     /**
     * Set to true if trying to close the position
     * @return close
    **/

    public Boolean getClose() {
        return close;
    }


    public void setClose(Boolean close) {
        this.close = close;
    }

    public FuturesInitialOrder tif(TifEnum tif) {
        
        this.tif = tif;
        return this;
    }

     /**
     * Time in force. If using market price, only &#x60;ioc&#x60; is supported.  - gtc: GoodTillCancelled - ioc: ImmediateOrCancelled
     * @return tif
    **/

    public TifEnum getTif() {
        return tif;
    }


    public void setTif(TifEnum tif) {
        this.tif = tif;
    }

    public FuturesInitialOrder text(String text) {
        
        this.text = text;
        return this;
    }

     /**
     * How the order is created. Possible values are: web, api and app
     * @return text
    **/

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public FuturesInitialOrder reduceOnly(Boolean reduceOnly) {
        
        this.reduceOnly = reduceOnly;
        return this;
    }

     /**
     * Set to true to create an reduce-only order
     * @return reduceOnly
    **/

    public Boolean getReduceOnly() {
        return reduceOnly;
    }


    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

     /**
     * Is the order reduce-only
     * @return isReduceOnly
    **/

    public Boolean getIsReduceOnly() {
        return isReduceOnly;
    }


     /**
     * Is the order to close position
     * @return isClose
    **/

    public Boolean getIsClose() {
        return isClose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FuturesInitialOrder futuresInitialOrder = (FuturesInitialOrder) o;
        return Objects.equals(this.contract, futuresInitialOrder.contract) &&
                Objects.equals(this.size, futuresInitialOrder.size) &&
                Objects.equals(this.price, futuresInitialOrder.price) &&
                Objects.equals(this.close, futuresInitialOrder.close) &&
                Objects.equals(this.tif, futuresInitialOrder.tif) &&
                Objects.equals(this.text, futuresInitialOrder.text) &&
                Objects.equals(this.reduceOnly, futuresInitialOrder.reduceOnly) &&
                Objects.equals(this.isReduceOnly, futuresInitialOrder.isReduceOnly) &&
                Objects.equals(this.isClose, futuresInitialOrder.isClose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contract, size, price, close, tif, text, reduceOnly, isReduceOnly, isClose);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FuturesInitialOrder {\n");
        sb.append("      contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("      size: ").append(toIndentedString(size)).append("\n");
        sb.append("      price: ").append(toIndentedString(price)).append("\n");
        sb.append("      close: ").append(toIndentedString(close)).append("\n");
        sb.append("      tif: ").append(toIndentedString(tif)).append("\n");
        sb.append("      text: ").append(toIndentedString(text)).append("\n");
        sb.append("      reduceOnly: ").append(toIndentedString(reduceOnly)).append("\n");
        sb.append("      isReduceOnly: ").append(toIndentedString(isReduceOnly)).append("\n");
        sb.append("      isClose: ").append(toIndentedString(isClose)).append("\n");
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

