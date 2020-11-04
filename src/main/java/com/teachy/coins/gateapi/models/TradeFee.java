


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
 * TradeFee
 */
public class TradeFee {
    public static final String SERIALIZED_NAME_USER_ID = "user_id";
    @SerializedName(SERIALIZED_NAME_USER_ID)
    private Long userId;

    public static final String SERIALIZED_NAME_TAKER_FEE = "taker_fee";
    @SerializedName(SERIALIZED_NAME_TAKER_FEE)
    private String takerFee;

    public static final String SERIALIZED_NAME_MAKER_FEE = "maker_fee";
    @SerializedName(SERIALIZED_NAME_MAKER_FEE)
    private String makerFee;

    public static final String SERIALIZED_NAME_GT_DISCOUNT = "gt_discount";
    @SerializedName(SERIALIZED_NAME_GT_DISCOUNT)
    private Boolean gtDiscount;

    public static final String SERIALIZED_NAME_GT_TAKER_FEE = "gt_taker_fee";
    @SerializedName(SERIALIZED_NAME_GT_TAKER_FEE)
    private String gtTakerFee;

    public static final String SERIALIZED_NAME_GT_MAKER_FEE = "gt_maker_fee";
    @SerializedName(SERIALIZED_NAME_GT_MAKER_FEE)
    private String gtMakerFee;

    public static final String SERIALIZED_NAME_LOAN_FEE = "loan_fee";
    @SerializedName(SERIALIZED_NAME_LOAN_FEE)
    private String loanFee;

    public static final String SERIALIZED_NAME_POINT_TYPE = "point_type";
    @SerializedName(SERIALIZED_NAME_POINT_TYPE)
    private String pointType;


    public TradeFee userId(Long userId) {
        
        this.userId = userId;
        return this;
    }

     /**
     * User ID
     * @return userId
    **/

    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public TradeFee takerFee(String takerFee) {
        
        this.takerFee = takerFee;
        return this;
    }

     /**
     * taker fee rate
     * @return takerFee
    **/

    public String getTakerFee() {
        return takerFee;
    }


    public void setTakerFee(String takerFee) {
        this.takerFee = takerFee;
    }

    public TradeFee makerFee(String makerFee) {
        
        this.makerFee = makerFee;
        return this;
    }

     /**
     * maker fee rate
     * @return makerFee
    **/

    public String getMakerFee() {
        return makerFee;
    }


    public void setMakerFee(String makerFee) {
        this.makerFee = makerFee;
    }

    public TradeFee gtDiscount(Boolean gtDiscount) {
        
        this.gtDiscount = gtDiscount;
        return this;
    }

     /**
     * Is GT deduction is enabled
     * @return gtDiscount
    **/

    public Boolean getGtDiscount() {
        return gtDiscount;
    }


    public void setGtDiscount(Boolean gtDiscount) {
        this.gtDiscount = gtDiscount;
    }

    public TradeFee gtTakerFee(String gtTakerFee) {
        
        this.gtTakerFee = gtTakerFee;
        return this;
    }

     /**
     * Taker fee rate if using GT deduction. It will be 0 if GT deduction is disabled
     * @return gtTakerFee
    **/

    public String getGtTakerFee() {
        return gtTakerFee;
    }


    public void setGtTakerFee(String gtTakerFee) {
        this.gtTakerFee = gtTakerFee;
    }

    public TradeFee gtMakerFee(String gtMakerFee) {
        
        this.gtMakerFee = gtMakerFee;
        return this;
    }

     /**
     * Maker fee rate if using GT deduction. It will be 0 if GT deduction is disabled
     * @return gtMakerFee
    **/

    public String getGtMakerFee() {
        return gtMakerFee;
    }


    public void setGtMakerFee(String gtMakerFee) {
        this.gtMakerFee = gtMakerFee;
    }

    public TradeFee loanFee(String loanFee) {
        
        this.loanFee = loanFee;
        return this;
    }

     /**
     * Loan fee rate of margin lending
     * @return loanFee
    **/

    public String getLoanFee() {
        return loanFee;
    }


    public void setLoanFee(String loanFee) {
        this.loanFee = loanFee;
    }

    public TradeFee pointType(String pointType) {
        
        this.pointType = pointType;
        return this;
    }

     /**
     * Point type. 0 - Initial version. 1 - new version since 202009
     * @return pointType
    **/

    public String getPointType() {
        return pointType;
    }


    public void setPointType(String pointType) {
        this.pointType = pointType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TradeFee tradeFee = (TradeFee) o;
        return Objects.equals(this.userId, tradeFee.userId) &&
                Objects.equals(this.takerFee, tradeFee.takerFee) &&
                Objects.equals(this.makerFee, tradeFee.makerFee) &&
                Objects.equals(this.gtDiscount, tradeFee.gtDiscount) &&
                Objects.equals(this.gtTakerFee, tradeFee.gtTakerFee) &&
                Objects.equals(this.gtMakerFee, tradeFee.gtMakerFee) &&
                Objects.equals(this.loanFee, tradeFee.loanFee) &&
                Objects.equals(this.pointType, tradeFee.pointType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, takerFee, makerFee, gtDiscount, gtTakerFee, gtMakerFee, loanFee, pointType);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TradeFee {\n");
        sb.append("      userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("      takerFee: ").append(toIndentedString(takerFee)).append("\n");
        sb.append("      makerFee: ").append(toIndentedString(makerFee)).append("\n");
        sb.append("      gtDiscount: ").append(toIndentedString(gtDiscount)).append("\n");
        sb.append("      gtTakerFee: ").append(toIndentedString(gtTakerFee)).append("\n");
        sb.append("      gtMakerFee: ").append(toIndentedString(gtMakerFee)).append("\n");
        sb.append("      loanFee: ").append(toIndentedString(loanFee)).append("\n");
        sb.append("      pointType: ").append(toIndentedString(pointType)).append("\n");
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

