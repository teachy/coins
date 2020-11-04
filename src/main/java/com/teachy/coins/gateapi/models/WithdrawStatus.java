


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
 * WithdrawStatus
 */
public class WithdrawStatus {
    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;

    public static final String SERIALIZED_NAME_NAME_CN = "name_cn";
    @SerializedName(SERIALIZED_NAME_NAME_CN)
    private String nameCn;

    public static final String SERIALIZED_NAME_DEPOSIT = "deposit";
    @SerializedName(SERIALIZED_NAME_DEPOSIT)
    private String deposit;

    public static final String SERIALIZED_NAME_WITHDRAW_PERCENT = "withdraw_percent";
    @SerializedName(SERIALIZED_NAME_WITHDRAW_PERCENT)
    private String withdrawPercent;

    public static final String SERIALIZED_NAME_WITHDRAW_FIX = "withdraw_fix";
    @SerializedName(SERIALIZED_NAME_WITHDRAW_FIX)
    private String withdrawFix;

    public static final String SERIALIZED_NAME_WITHDRAW_DAY_LIMIT = "withdraw_day_limit";
    @SerializedName(SERIALIZED_NAME_WITHDRAW_DAY_LIMIT)
    private String withdrawDayLimit;

    public static final String SERIALIZED_NAME_WITHDRAW_AMOUNT_MINI = "withdraw_amount_mini";
    @SerializedName(SERIALIZED_NAME_WITHDRAW_AMOUNT_MINI)
    private String withdrawAmountMini;

    public static final String SERIALIZED_NAME_WITHDRAW_DAY_LIMIT_REMAIN = "withdraw_day_limit_remain";
    @SerializedName(SERIALIZED_NAME_WITHDRAW_DAY_LIMIT_REMAIN)
    private String withdrawDayLimitRemain;

    public static final String SERIALIZED_NAME_WITHDRAW_EACHTIME_LIMIT = "withdraw_eachtime_limit";
    @SerializedName(SERIALIZED_NAME_WITHDRAW_EACHTIME_LIMIT)
    private String withdrawEachtimeLimit;


    public WithdrawStatus currency(String currency) {
        
        this.currency = currency;
        return this;
    }

     /**
     * Currency
     * @return currency
    **/

    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public WithdrawStatus name(String name) {
        
        this.name = name;
        return this;
    }

     /**
     * Currency name
     * @return name
    **/

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public WithdrawStatus nameCn(String nameCn) {
        
        this.nameCn = nameCn;
        return this;
    }

     /**
     * Currency Chinese name
     * @return nameCn
    **/

    public String getNameCn() {
        return nameCn;
    }


    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public WithdrawStatus deposit(String deposit) {
        
        this.deposit = deposit;
        return this;
    }

     /**
     * Deposits fee
     * @return deposit
    **/

    public String getDeposit() {
        return deposit;
    }


    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public WithdrawStatus withdrawPercent(String withdrawPercent) {
        
        this.withdrawPercent = withdrawPercent;
        return this;
    }

     /**
     * Withdrawal fee rate percentage
     * @return withdrawPercent
    **/

    public String getWithdrawPercent() {
        return withdrawPercent;
    }


    public void setWithdrawPercent(String withdrawPercent) {
        this.withdrawPercent = withdrawPercent;
    }

    public WithdrawStatus withdrawFix(String withdrawFix) {
        
        this.withdrawFix = withdrawFix;
        return this;
    }

     /**
     * Fixed withdrawal fee
     * @return withdrawFix
    **/

    public String getWithdrawFix() {
        return withdrawFix;
    }


    public void setWithdrawFix(String withdrawFix) {
        this.withdrawFix = withdrawFix;
    }

    public WithdrawStatus withdrawDayLimit(String withdrawDayLimit) {
        
        this.withdrawDayLimit = withdrawDayLimit;
        return this;
    }

     /**
     * Daily allowed withdrawal amount
     * @return withdrawDayLimit
    **/

    public String getWithdrawDayLimit() {
        return withdrawDayLimit;
    }


    public void setWithdrawDayLimit(String withdrawDayLimit) {
        this.withdrawDayLimit = withdrawDayLimit;
    }

    public WithdrawStatus withdrawAmountMini(String withdrawAmountMini) {
        
        this.withdrawAmountMini = withdrawAmountMini;
        return this;
    }

     /**
     * Minimum withdrawal amount
     * @return withdrawAmountMini
    **/

    public String getWithdrawAmountMini() {
        return withdrawAmountMini;
    }


    public void setWithdrawAmountMini(String withdrawAmountMini) {
        this.withdrawAmountMini = withdrawAmountMini;
    }

    public WithdrawStatus withdrawDayLimitRemain(String withdrawDayLimitRemain) {
        
        this.withdrawDayLimitRemain = withdrawDayLimitRemain;
        return this;
    }

     /**
     * Daily withdrawal amount left
     * @return withdrawDayLimitRemain
    **/

    public String getWithdrawDayLimitRemain() {
        return withdrawDayLimitRemain;
    }


    public void setWithdrawDayLimitRemain(String withdrawDayLimitRemain) {
        this.withdrawDayLimitRemain = withdrawDayLimitRemain;
    }

    public WithdrawStatus withdrawEachtimeLimit(String withdrawEachtimeLimit) {
        
        this.withdrawEachtimeLimit = withdrawEachtimeLimit;
        return this;
    }

     /**
     * Maximum amount for each withdrawal
     * @return withdrawEachtimeLimit
    **/

    public String getWithdrawEachtimeLimit() {
        return withdrawEachtimeLimit;
    }


    public void setWithdrawEachtimeLimit(String withdrawEachtimeLimit) {
        this.withdrawEachtimeLimit = withdrawEachtimeLimit;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WithdrawStatus withdrawStatus = (WithdrawStatus) o;
        return Objects.equals(this.currency, withdrawStatus.currency) &&
                Objects.equals(this.name, withdrawStatus.name) &&
                Objects.equals(this.nameCn, withdrawStatus.nameCn) &&
                Objects.equals(this.deposit, withdrawStatus.deposit) &&
                Objects.equals(this.withdrawPercent, withdrawStatus.withdrawPercent) &&
                Objects.equals(this.withdrawFix, withdrawStatus.withdrawFix) &&
                Objects.equals(this.withdrawDayLimit, withdrawStatus.withdrawDayLimit) &&
                Objects.equals(this.withdrawAmountMini, withdrawStatus.withdrawAmountMini) &&
                Objects.equals(this.withdrawDayLimitRemain, withdrawStatus.withdrawDayLimitRemain) &&
                Objects.equals(this.withdrawEachtimeLimit, withdrawStatus.withdrawEachtimeLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, name, nameCn, deposit, withdrawPercent, withdrawFix, withdrawDayLimit, withdrawAmountMini, withdrawDayLimitRemain, withdrawEachtimeLimit);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WithdrawStatus {\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      name: ").append(toIndentedString(name)).append("\n");
        sb.append("      nameCn: ").append(toIndentedString(nameCn)).append("\n");
        sb.append("      deposit: ").append(toIndentedString(deposit)).append("\n");
        sb.append("      withdrawPercent: ").append(toIndentedString(withdrawPercent)).append("\n");
        sb.append("      withdrawFix: ").append(toIndentedString(withdrawFix)).append("\n");
        sb.append("      withdrawDayLimit: ").append(toIndentedString(withdrawDayLimit)).append("\n");
        sb.append("      withdrawAmountMini: ").append(toIndentedString(withdrawAmountMini)).append("\n");
        sb.append("      withdrawDayLimitRemain: ").append(toIndentedString(withdrawDayLimitRemain)).append("\n");
        sb.append("      withdrawEachtimeLimit: ").append(toIndentedString(withdrawEachtimeLimit)).append("\n");
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

