package analyzer.exercises;

import org.json.JSONObject;

import java.util.Map;

public class Type {

    //Types regarding comments given once exercise is submitted.
    String ESSENTIAL = "essential";

    String ACTIONABLE = "actionable";

    String INFORMATIVE = "informative";

    String CELEBRATORY = "celebratory";


    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        // TODO: How to integrate it with the
        //  addComment method within the Exercise class
        return json;
    }

}
