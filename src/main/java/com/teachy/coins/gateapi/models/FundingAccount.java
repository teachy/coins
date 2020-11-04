


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
 * FundingAccount
 */
public class FundingAccount {
    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_AVAILABLE = "available";
    @SerializedName(SERIALIZED_NAME_AVAILABLE)
    private String available;

    public static final String SERIALIZED_NAME_LOCKED = "locked";
    @SerializedName(SERIALIZED_NAME_LOCKED)
    private String locked;

    public static final String SERIALIZED_NAME_LENT = "lent";
    @SerializedName(SERIALIZED_NAME_LENT)
    private String lent;

    public static final String SERIALIZED_NAME_TOTAL_LENT = "total_lent";
    @SerializedName(SERIALIZED_NAME_TOTAL_LENT)
    private String totalLent;


    public FundingAccount currency(String currency) {
        
        this.currency = currency;
        return this;
    }

     /**
     * Currency name
     * @return currency
    **/

    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public FundingAccount available(String available) {
        
        this.available = available;
        return this;
    }

     /**
     * Available assets to lend, which is identical to spot account &#x60;available&#x60;
     * @return available
    **/

    public String getAvailable() {
        return available;
    }


    public void setAvailable(String available) {
        this.available = available;
    }

    public FundingAccount locked(String locked) {
        
        this.locked = locked;
        return this;
    }

     /**
     * Locked amount. i.e. amount in &#x60;open&#x60; loans
     * @return locked
    **/

    public String getLocked() {
        return locked;
    }


    public void setLocked(String locked) {
        this.locked = locked;
    }

    public FundingAccount lent(String lent) {
        
        this.lent = lent;
        return this;
    }

     /**
     * Amount that is loaned but not repaid
     * @return lent
    **/

    public String getLent() {
        return lent;
    }


    public void setLent(String lent) {
        this.lent = lent;
    }

    public FundingAccount totalLent(String totalLent) {
        
        this.totalLent = totalLent;
        return this;
    }

     /**
     * Amount used for lending. total_lent &#x3D; lent + locked
     * @return totalLent
    **/

    public String getTotalLent() {
        return totalLent;
    }


    public void setTotalLent(String totalLent) {
        this.totalLent = totalLent;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FundingAccount fundingAccount = (FundingAccount) o;
        return Objects.equals(this.currency, fundingAccount.currency) &&
                Objects.equals(this.available, fundingAccount.available) &&
                Objects.equals(this.locked, fundingAccount.locked) &&
                Objects.equals(this.lent, fundingAccount.lent) &&
                Objects.equals(this.totalLent, fundingAccount.totalLent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, available, locked, lent, totalLent);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FundingAccount {\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      available: ").append(toIndentedString(available)).append("\n");
        sb.append("      locked: ").append(toIndentedString(locked)).append("\n");
        sb.append("      lent: ").append(toIndentedString(lent)).append("\n");
        sb.append("      totalLent: ").append(toIndentedString(totalLent)).append("\n");
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

