package us.ridiculousbakery.instagramviewer;

import org.json.JSONObject;

/**
 * Created by bkuo on 5/8/15.
 */
public class InstagramCaption {
    public InstagramCaption(String _text, Integer _created_at) {
        text =_text;
        created_at = _created_at;

    }

    public static InstagramCaption fromJSON(JSONObject captionJSON){
        return new InstagramCaption(null,null);
//        return new InstagramCaption(
//                captionJSON.optString("text"),
//                (Integer) captionJSON.optInt("created_time"));
    }

    public String getText() {
        return text == null ? "" : text;
    }
    public String getCreatedAt() {
        return created_at == null ? "" : text;
    }
    private String text;
    private Integer created_at;
}
