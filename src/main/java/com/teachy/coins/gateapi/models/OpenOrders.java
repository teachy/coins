


package com.teachy.coins.gateapi.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.teachy.coins.gateapi.models.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * OpenOrders
 */
public class OpenOrders {
    public static final String SERIALIZED_NAME_CURRENCY_PAIR = "currency_pair";
    @SerializedName(SERIALIZED_NAME_CURRENCY_PAIR)
    private String currencyPair;

    public static final String SERIALIZED_NAME_TOTAL = "total";
    @SerializedName(SERIALIZED_NAME_TOTAL)
    private Integer total;

    public static final String SERIALIZED_NAME_ORDERS = "orders";
    @SerializedName(SERIALIZED_NAME_ORDERS)
    private List<Order> orders = null;


    public OpenOrders currencyPair(String currencyPair) {
        
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

    public OpenOrders total(Integer total) {
        
        this.total = total;
        return this;
    }

     /**
     * Total open orders in this currency pair
     * @return total
    **/

    public Integer getTotal() {
        return total;
    }


    public void setTotal(Integer total) {
        this.total = total;
    }

    public OpenOrders orders(List<Order> orders) {
        
        this.orders = orders;
        return this;
    }

    public OpenOrders addOrdersItem(Order ordersItem) {
        if (this.orders == null) {
            this.orders = new ArrayList<>();
        }
        this.orders.add(ordersItem);
        return this;
    }

     /**
     * Get orders
     * @return orders
    **/

    public List<Order> getOrders() {
        return orders;
    }


    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OpenOrders openOrders = (OpenOrders) o;
        return Objects.equals(this.currencyPair, openOrders.currencyPair) &&
                Objects.equals(this.total, openOrders.total) &&
                Objects.equals(this.orders, openOrders.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyPair, total, orders);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OpenOrders {\n");
        sb.append("      currencyPair: ").append(toIndentedString(currencyPair)).append("\n");
        sb.append("      total: ").append(toIndentedString(total)).append("\n");
        sb.append("      orders: ").append(toIndentedString(orders)).append("\n");
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

