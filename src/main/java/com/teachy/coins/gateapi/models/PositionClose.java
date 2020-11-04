


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
 * PositionClose
 */
public class PositionClose {
    public static final String SERIALIZED_NAME_TIME = "time";
    @SerializedName(SERIALIZED_NAME_TIME)
    private BigDecimal time;

    public static final String SERIALIZED_NAME_CONTRACT = "contract";
    @SerializedName(SERIALIZED_NAME_CONTRACT)
    private String contract;

    /**
     * Position side, long or short
     */
    @JsonAdapter(SideEnum.Adapter.class)
    public enum SideEnum {
        LONG("long"),
        
        SHORT("short");

        private String value;

        SideEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SideEnum fromValue(String value) {
            for (SideEnum b : SideEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<SideEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SideEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SideEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return SideEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_SIDE = "side";
    @SerializedName(SERIALIZED_NAME_SIDE)
    private SideEnum side;

    public static final String SERIALIZED_NAME_PNL = "pnl";
    @SerializedName(SERIALIZED_NAME_PNL)
    private String pnl;

    public static final String SERIALIZED_NAME_TEXT = "text";
    @SerializedName(SERIALIZED_NAME_TEXT)
    private String text;


     /**
     * Position close time
     * @return time
    **/

    public BigDecimal getTime() {
        return time;
    }


     /**
     * Futures contract
     * @return contract
    **/

    public String getContract() {
        return contract;
    }


     /**
     * Position side, long or short
     * @return side
    **/

    public SideEnum getSide() {
        return side;
    }


     /**
     * PNL
     * @return pnl
    **/

    public String getPnl() {
        return pnl;
    }


     /**
     * Text of close order
     * @return text
    **/

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositionClose positionClose = (PositionClose) o;
        return Objects.equals(this.time, positionClose.time) &&
                Objects.equals(this.contract, positionClose.contract) &&
                Objects.equals(this.side, positionClose.side) &&
                Objects.equals(this.pnl, positionClose.pnl) &&
                Objects.equals(this.text, positionClose.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, contract, side, pnl, text);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PositionClose {\n");
        sb.append("      time: ").append(toIndentedString(time)).append("\n");
        sb.append("      contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("      side: ").append(toIndentedString(side)).append("\n");
        sb.append("      pnl: ").append(toIndentedString(pnl)).append("\n");
        sb.append("      text: ").append(toIndentedString(text)).append("\n");
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

