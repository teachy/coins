


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
 * FundingBookItem
 */
public class FundingBookItem {
    public static final String SERIALIZED_NAME_RATE = "rate";
    @SerializedName(SERIALIZED_NAME_RATE)
    private String rate;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private String amount;

    public static final String SERIALIZED_NAME_DAYS = "days";
    @SerializedName(SERIALIZED_NAME_DAYS)
    private Integer days;


    public FundingBookItem rate(String rate) {
        
        this.rate = rate;
        return this;
    }

     /**
     * Loan rate
     * @return rate
    **/

    public String getRate() {
        return rate;
    }


    public void setRate(String rate) {
        this.rate = rate;
    }

    public FundingBookItem amount(String amount) {
        
        this.amount = amount;
        return this;
    }

     /**
     * Borrowable amount
     * @return amount
    **/

    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

    public FundingBookItem days(Integer days) {
        
        this.days = days;
        return this;
    }

     /**
     * How long the loan should be repaid
     * @return days
    **/

    public Integer getDays() {
        return days;
    }


    public void setDays(Integer days) {
        this.days = days;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FundingBookItem fundingBookItem = (FundingBookItem) o;
        return Objects.equals(this.rate, fundingBookItem.rate) &&
                Objects.equals(this.amount, fundingBookItem.amount) &&
                Objects.equals(this.days, fundingBookItem.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, amount, days);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FundingBookItem {\n");
        sb.append("      rate: ").append(toIndentedString(rate)).append("\n");
        sb.append("      amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("      days: ").append(toIndentedString(days)).append("\n");
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

