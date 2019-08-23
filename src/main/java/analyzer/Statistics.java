package analyzer;

import analyzer.exercises.Exercise;
import analyzer.exercises.twofer.Twofer;
import org.json.JSONArray;
   
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
            String status = (String)ex.getAnalysis().get("status");
            JSONArray comments = (JSONArray)ex.getAnalysis().get("comments");
            statuses.put(status, statuses.getOrDefault(status, 0)+1);
            //ex.writeAnalysisToFile();

            /*if (type.equals("approve_as_optimal")) {
                System.out.println(i);
            }*/

            for (Object comment : comments) {
                if (status.equals("disapprove")) {
                    failComments.put((String)comment, failComments.getOrDefault(comment, 0)+1);
                } else if (status.equals("approve")) {
                    passComments.put((String)comment, passComments.getOrDefault(comment, 0)+1);
                }
            }
        }

        System.out.println(statuses);
        System.out.println(failComments);
        System.out.println(passComments);
    }
}
