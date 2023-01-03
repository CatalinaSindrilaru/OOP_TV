import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.Input;

import java.io.File;
import java.io.IOException;

public final class Main {

    private Main() { }

    public static void main(final String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Input input = mapper.readValue(new File(args[0]), Input.class);

        ArrayNode output = mapper.createArrayNode();

        StartProgram program = StartProgram.getInstance();
        program.run(input, output);

        ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), output);
    }
}
