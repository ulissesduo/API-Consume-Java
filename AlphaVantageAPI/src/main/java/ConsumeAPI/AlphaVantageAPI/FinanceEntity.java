package ConsumeAPI.AlphaVantageAPI;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FinanceEntity {
    @JsonProperty("symbol")
    public String Symbol;
    @JsonProperty("price")
    public double Price;
    @JsonProperty("range")
    public String Range;

}

