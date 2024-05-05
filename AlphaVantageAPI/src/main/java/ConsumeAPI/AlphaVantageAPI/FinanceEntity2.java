package ConsumeAPI.AlphaVantageAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinanceEntity2{

    @JsonProperty("symbol")
    public String Symbol;
    @JsonProperty("name")
    public String Name;
    @JsonProperty("price")
    public double Price;
    @JsonProperty("open")
    public double Open;
}
