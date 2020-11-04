


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
 * LedgerRecord
 */
public class LedgerRecord {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_TXID = "txid";
    @SerializedName(SERIALIZED_NAME_TXID)
    private String txid;

    public static final String SERIALIZED_NAME_TIMESTAMP = "timestamp";
    @SerializedName(SERIALIZED_NAME_TIMESTAMP)
    private String timestamp;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private String amount;

    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_ADDRESS = "address";
    @SerializedName(SERIALIZED_NAME_ADDRESS)
    private String address;

    public static final String SERIALIZED_NAME_MEMO = "memo";
    @SerializedName(SERIALIZED_NAME_MEMO)
    private String memo;

    /**
     * Record status.  - DONE: done - CANCEL: cancelled - REQUEST: requesting - MANUAL: waiting for manual approval - BCODE: GateCode operation
     */
    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        DONE("DONE"),
        
        CANCEL("CANCEL"),
        
        REQUEST("REQUEST"),
        
        MANUAL("MANUAL"),
        
        BCODE("BCODE");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return StatusEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_STATUS = "status";
    @SerializedName(SERIALIZED_NAME_STATUS)
    private StatusEnum status;


     /**
     * Record ID
     * @return id
    **/

    public String getId() {
        return id;
    }


     /**
     * Hash record of the withdrawal
     * @return txid
    **/

    public String getTxid() {
        return txid;
    }


     /**
     * Record time
     * @return timestamp
    **/

    public String getTimestamp() {
        return timestamp;
    }


    public LedgerRecord amount(String amount) {
        
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

    public LedgerRecord currency(String currency) {
        
        this.currency = currency;
        return this;
    }

     /**
     * Record currency
     * @return currency
    **/
    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LedgerRecord address(String address) {
        
        this.address = address;
        return this;
    }

     /**
     * Withdrawal address. Required for withdrawals
     * @return address
    **/

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public LedgerRecord memo(String memo) {
        
        this.memo = memo;
        return this;
    }

     /**
     * Extra withdrawal memo
     * @return memo
    **/

    public String getMemo() {
        return memo;
    }


    public void setMemo(String memo) {
        this.memo = memo;
    }

     /**
     * Record status.  - DONE: done - CANCEL: cancelled - REQUEST: requesting - MANUAL: waiting for manual approval - BCODE: GateCode operation
     * @return status
    **/

    public StatusEnum getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LedgerRecord ledgerRecord = (LedgerRecord) o;
        return Objects.equals(this.id, ledgerRecord.id) &&
                Objects.equals(this.txid, ledgerRecord.txid) &&
                Objects.equals(this.timestamp, ledgerRecord.timestamp) &&
                Objects.equals(this.amount, ledgerRecord.amount) &&
                Objects.equals(this.currency, ledgerRecord.currency) &&
                Objects.equals(this.address, ledgerRecord.address) &&
                Objects.equals(this.memo, ledgerRecord.memo) &&
                Objects.equals(this.status, ledgerRecord.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, txid, timestamp, amount, currency, address, memo, status);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LedgerRecord {\n");
        sb.append("      id: ").append(toIndentedString(id)).append("\n");
        sb.append("      txid: ").append(toIndentedString(txid)).append("\n");
        sb.append("      timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("      amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      address: ").append(toIndentedString(address)).append("\n");
        sb.append("      memo: ").append(toIndentedString(memo)).append("\n");
        sb.append("      status: ").append(toIndentedString(status)).append("\n");
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

