import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //ObjectMapper mapper = new ObjectMapper();
        JsonMapper jsonMapper = new JsonMapper();
        Child child = new Child();
        child.setNumbers("1234; 5678");
        child.setFlag("true");
        String valueAsString = mapper.writeValueAsString(child);
        System.out.println(valueAsString);
        Child reconstruct1 = mapper.readValue(valueAsString, Child.class);
        System.out.println(mapper.writeValueAsString(reconstruct1));

        String valueAsString2 = mapper.writeValueAsString(child);
        System.out.println(valueAsString2);
        Child reconstruct2 = mapper.readValue(valueAsString2, Child.class);
        System.out.println(mapper.writeValueAsString(reconstruct2));

    }

}
