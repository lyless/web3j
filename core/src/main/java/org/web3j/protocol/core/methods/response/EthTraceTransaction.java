package org.web3j.protocol.core.methods.response;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.web3j.protocol.ObjectMapperFactory;
import org.web3j.protocol.core.Response;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class EthTraceTransaction extends Response<EthTraceTransaction.TraceTransaction> {

    @Override
    @JsonDeserialize(using = EthTraceTransaction.ResponseDeserialiser.class)
    public void setResult(TraceTransaction result) {
        super.setResult(result);
    }

    public TraceTransaction getTraceTransaction() {
        return getResult();
    }

    public static class Call{
        private String from;
        private String to;
        private String input;
        private String type;
        private String value;

        public Call() {
        }

        public Call(String from, String to, String input, String type, String value) {
            this.from = from;
            this.to = to;
            this.input = input;
            this.type = type;
            this.value = value;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public BigInteger getValue() {
            return Numeric.decodeQuantity(value);
        }
        public String getValueRaw() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Call{");
            sb.append("from='").append(from).append('\'');
            sb.append(", to='").append(to).append('\'');
            sb.append(", input='").append(input).append('\'');
            sb.append(", type='").append(type).append('\'');
            sb.append(", value='").append(value).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
    public static class TraceTransaction {
        private List<Call> calls;
        private String from;
        private String to;
        private String gas;
        private String gasUsed;
        private String input;
        private String output;
        private String time;
        private String type;
        private String value;

        public TraceTransaction() {
        }

        public TraceTransaction(List<Call> calls, String from, String to, String gas, String gasUsed, String input, String output, String time, String type, String value) {
            this.calls = calls;
            this.from = from;
            this.to = to;
            this.gas = gas;
            this.gasUsed = gasUsed;
            this.input = input;
            this.output = output;
            this.time = time;
            this.type = type;
            this.value = value;
        }

        public List<Call> getCalls() {
            return calls;
        }

        public void setCalls(List<Call> calls) {
            this.calls = calls;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public BigInteger getGas() {
            return Numeric.decodeQuantity(gas);
        }

        public String getGasRaw() {
            return gas;
        }
        public void setGas(String gas) {
            this.gas = gas;
        }

        public BigInteger getGasUsed() {
            return Numeric.decodeQuantity(gasUsed);
        }

        public String getGasUsedRaw() {
            return gasUsed;
        }

        public void setGasUsed(String gasUsed) {
            this.gasUsed = gasUsed;
        }

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public BigInteger getValue() {
            return Numeric.decodeQuantity(value);
        }

        public String getValueRaw() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TraceTransaction)) return false;

            TraceTransaction that = (TraceTransaction) o;

            if (getCalls() != null ? !getCalls().equals(that.getCalls()) : that.getCalls() != null) return false;
            if (getFrom() != null ? !getFrom().equals(that.getFrom()) : that.getFrom() != null) return false;
            if (getTo() != null ? !getTo().equals(that.getTo()) : that.getTo() != null) return false;
            if (getGas() != null ? !getGas().equals(that.getGas()) : that.getGas() != null) return false;
            if (getGasUsed() != null ? !getGasUsed().equals(that.getGasUsed()) : that.getGasUsed() != null)
                return false;
            if (getInput() != null ? !getInput().equals(that.getInput()) : that.getInput() != null) return false;
            if (getOutput() != null ? !getOutput().equals(that.getOutput()) : that.getOutput() != null) return false;
            if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) return false;
            if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
            return getValue() != null ? getValue().equals(that.getValue()) : that.getValue() == null;
        }

        @Override
        public int hashCode() {
            int result = getCalls() != null ? getCalls().hashCode() : 0;
            result = 31 * result + (getFrom() != null ? getFrom().hashCode() : 0);
            result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
            result = 31 * result + (getGas() != null ? getGas().hashCode() : 0);
            result = 31 * result + (getGasUsed() != null ? getGasUsed().hashCode() : 0);
            result = 31 * result + (getInput() != null ? getInput().hashCode() : 0);
            result = 31 * result + (getOutput() != null ? getOutput().hashCode() : 0);
            result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
            result = 31 * result + (getType() != null ? getType().hashCode() : 0);
            result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TraceTransaction{");
            sb.append("calls=").append(calls);
            sb.append(", from='").append(from).append('\'');
            sb.append(", to='").append(to).append('\'');
            sb.append(", gas='").append(gas).append('\'');
            sb.append(", gasUsed='").append(gasUsed).append('\'');
            sb.append(", input='").append(input).append('\'');
            sb.append(", output='").append(output).append('\'');
            sb.append(", time='").append(time).append('\'');
            sb.append(", type='").append(type).append('\'');
            sb.append(", value='").append(value).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class ResponseDeserialiser extends JsonDeserializer<TraceTransaction> {

        private ObjectReader objectReader = ObjectMapperFactory.getObjectReader();

        @Override
        public TraceTransaction deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.getCurrentToken() != JsonToken.VALUE_NULL) {
                return objectReader.readValue(jsonParser, TraceTransaction.class);
            } else {
                return null;  // null is wrapped by Optional in above getter
            }
        }
    }
}
