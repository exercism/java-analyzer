package analyzer;

import analyzer.exercises.Exercise;
import analyzer.exercises.Twofer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class Statistics {
    public static void main(String... args) {
        String archive = "archive";

        HashMap<String, Integer> statuses = new HashMap<>();
        HashMap<String, Integer> failComments = new HashMap<>();
        HashMap<String, Integer> passComments = new HashMap<>();

        for (int i = 0; i < 500; i++) {
            Exercise ex = new Twofer(archive + "/" + i);
            ex.parse();
            String type = (String)ex.getAnalysis().get("status");
            JSONArray comments = (JSONArray)ex.getAnalysis().get("comments");
            statuses.put(type, statuses.getOrDefault(type, 0)+1);

            for (Object comment : comments) {
                if (type.equals("disapprove_with_comment")) {
                    failComments.put((String)comment, failComments.getOrDefault(comment, 0)+1);
                } else if (type.equals("approve_with_comment")) {
                    passComments.put((String)comment, passComments.getOrDefault(comment, 0)+1);
                }
            }
        }

        System.out.println(statuses);
        System.out.println(failComments);
        System.out.println(passComments);
    }
}
