package analyzer;

import analyzer.exercises.Exercise;
import analyzer.exercises.Twofer;
import org.json.JSONObject;

import java.util.HashMap;

public class Statistics {
    public static void main(String... args) {
        String archive = "archive";

        HashMap<String, Integer> statuses = new HashMap<>();

        for (int i = 0; i < 500; i++) {
            System.out.println(i);
            Exercise ex = new Twofer(archive + "/" + i);
            ex.parse();
            String type = (String)ex.getAnalysis().get("status");
            statuses.put(type, statuses.getOrDefault(type, 0)+1);
            System.out.println(type);
            System.out.println("");
        }

        System.out.println(statuses);
    }
}
