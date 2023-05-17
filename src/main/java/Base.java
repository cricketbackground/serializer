import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Base implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty
    abstract String getField1();
    @JsonProperty
    abstract String getField2();
    @JsonProperty
    abstract String getField3();

    @JsonIgnore
    private String numbers;

    private List<String> tokens;

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    @JsonProperty
    public List<String> getTokens() {
        if (CollectionUtils.isNotEmpty(this.tokens)) return this.tokens;
        if (StringUtils.isBlank(this.numbers)) return new ArrayList<>();
        return new ArrayList<>(List.of(this.numbers.split(";\\s*")));
    }

  }