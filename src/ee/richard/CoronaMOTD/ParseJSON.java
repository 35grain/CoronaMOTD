package ee.richard.CoronaMOTD;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.bukkit.ChatColor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class ParseJSON {
    private static JsonObject dailyCorona() throws IOException {
        File raw_data = new File("corona_data.json");
        if (milliToHours(Calendar.getInstance().getTimeInMillis() - raw_data.lastModified()) >= 1) {
            GetData.download();
        }
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(raw_data));
        JsonArray data = gson.fromJson(reader, JsonArray.class);

        return (JsonObject) data.get(data.size() - 1);
    }

    public static String dailyCases() throws IOException {
        return ChatColor.RED + "+" + dailyCorona().get("DailyCases");
    }

    public static String dateOfData() throws IOException {
        return dailyCorona().get("StatisticsDate").getAsString();
    }

    private static double milliToHours(long milli) {
        return ((double) milli / (1000 * 60 * 60));
    }
}