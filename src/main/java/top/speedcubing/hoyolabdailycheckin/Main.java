package top.speedcubing.hoyolabdailycheckin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static String[] langs = {
            "de-de", "en-us", "es-es", "fr-fr", "id-id", "it-it", "ja-jp", "ko-kr",
            "pt-pt", "ru-ru", "th-th", "tr-tr", "vi-vn", "zh-cn", "zh-tw"
    };

    static String[] games = {"Genshin Impact", "Honkai: Star Rail", "Honkai Impact 3", "Tears of Themis", "Zenless Zone Zero"};
    static String[] urls = {
            "https://sg-hk4e-api.hoyolab.com/event/sol/sign?act_id=e202102251931481",
            "https://sg-public-api.hoyolab.com/event/luna/os/sign?act_id=e202303301540311",
            "https://sg-public-api.hoyolab.com/event/mani/sign?act_id=e202110291205111",
            "https://sg-public-api.hoyolab.com/event/luna/os/sign?act_id=e202202281857121",
            "https://sg-act-nap-api.hoyolab.com/event/luna/zzz/os/sign?act_id=e202406031448091"
    };


    public static void main(String[] args) {
        String cookie = "ltoken_v2=...; ltuid_v2=...;";
        int langIndex = 1;

        for (int i = 0; i < games.length; i++) {
            System.out.println(games[i]);
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(urls[i] + "&lang=" + langs[langIndex]).openConnection();
                connection.setRequestMethod("POST");

                Map<String, String> m = new HashMap<>();
                m.put("Cookie", cookie);

                for (Map.Entry<String, String> s : m.entrySet()) {
                    connection.setRequestProperty(s.getKey(), s.getValue());
                }
                System.out.println(connection.getResponseCode());
                System.out.println(new String(connection.getInputStream().readAllBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}