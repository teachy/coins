


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
 * Repayment
 */
public class Repayment {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_CREATE_TIME = "create_time";
    @SerializedName(SERIALIZED_NAME_CREATE_TIME)
    private String createTime;

    public static final String SERIALIZED_NAME_PRINCIPAL = "principal";
    @SerializedName(SERIALIZED_NAME_PRINCIPAL)
    private String principal;

    public static final String SERIALIZED_NAME_INTEREST = "interest";
    @SerializedName(SERIALIZED_NAME_INTEREST)
    private String interest;


    public Repayment id(String id) {
        
        this.id = id;
        return this;
    }

     /**
     * Loan record ID
     * @return id
    **/

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public Repayment createTime(String createTime) {
        
        this.createTime = createTime;
        return this;
    }

     /**
     * Repayment time
     * @return createTime
    **/

    public String getCreateTime() {
        return createTime;
    }


    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Repayment principal(String principal) {
        
        this.principal = principal;
        return this;
    }

     /**
     * Repaid principal
     * @return principal
    **/

    public String getPrincipal() {
        return principal;
    }


    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Repayment interest(String interest) {
        
        this.interest = interest;
        return this;
    }

     /**
     * Repaid interest
     * @return interest
    **/

    public String getInterest() {
        return interest;
    }


    public void setInterest(String interest) {
        this.interest = interest;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Repayment repayment = (Repayment) o;
        return Objects.equals(this.id, repayment.id) &&
                Objects.equals(this.createTime, repayment.createTime) &&
                Objects.equals(this.principal, repayment.principal) &&
                Objects.equals(this.interest, repayment.interest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, principal, interest);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Repayment {\n");
        sb.append("      id: ").append(toIndentedString(id)).append("\n");
        sb.append("      createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("      principal: ").append(toIndentedString(principal)).append("\n");
        sb.append("      interest: ").append(toIndentedString(interest)).append("\n");
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

