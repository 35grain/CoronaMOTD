package ee.richard.CoronaMOTD;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class GetData {
    public static void download() throws IOException {
        URL website = new URL("https://opendata.digilugu.ee/opendata_covid19_tests_total.json");
        try (InputStream in = website.openStream()) {
            Path target = Paths.get("corona_data.json");
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
