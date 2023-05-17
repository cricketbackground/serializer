import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

public class Child extends Base implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // ---------------------------------------------------
    // Getter exists in base class, no annotation on field
    // ---------------------------------------------------

    public String field1 = "field1";

    @Override
    @JsonIgnore
    public String getField1() {
        return field1 + "Getter";
    }

    // -----------------------------------------------
    // Getter exists in base class, field is annotated
    // -----------------------------------------------

    @JsonProperty
    public String field2 = "field2";

    @Override
    @JsonIgnore
    public String getField2() {
        return field2 + "Getter";
    }

    // ----------------------------------------------------------------------
    // Getter exists in base class, field is ignored, no annotation on getter
    // ----------------------------------------------------------------------

    @JsonIgnore
    public String field3 = "field3";

    @Override
    public String getField3() {
        return field3 + "Getter";
    }

    // ----------------------------------
    // Getter doesn't exist in base class
    // ----------------------------------

    public String field4 = "field4";

    @JsonIgnore
    public String getField4() {
        return field4 + "Getter";
    }
}
