package us.ridiculousbakery.instagramviewer;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bkuo on 5/8/15.
 */
public class InstagramPhoto {
    public InstagramPhoto(
            String _username,
            String _caption,
            String _imageUrl,
            int _imageHeight,
            int _likesCount,
            String _avatarUrl,
            int _created_at
    ) {
        username = _username;
        caption = _caption;
        imageUrl = _imageUrl;
        imageHeight = _imageHeight;
        likesCount = _likesCount;
        avatarUrl = _avatarUrl;
        created_at = _created_at;
    }


    public String username;
    public String caption;
    public String imageUrl;
    public int imageHeight;
    public int likesCount;
    public String avatarUrl;
    public int created_at;

    public static InstagramPhoto fromJSON(JSONObject photoJSON) {
        try {
            return new InstagramPhoto(
                    photoJSON.getJSONObject("user").getString("username"),
                    photoJSON.getJSONObject("caption").getString("text"),
                    photoJSON.getJSONObject("images").getJSONObject("standard_resolution").getString("url"),
                    photoJSON.getJSONObject("images").getJSONObject("standard_resolution").getInt("height"),
                    photoJSON.getJSONObject("likes").getInt("count"),
                    photoJSON.getJSONObject("user").getString("profile_picture"),
                    photoJSON.getJSONObject("caption").getInt("created_time")
            );
        }catch(JSONException e){
            return null;
        }
    }
    public static InstagramPhoto fake(){
        return new InstagramPhoto(
                "username",
                "caption http://placekitten.com/460/460",
                "http://placekitten.com/1080/1080",
                1080,
                5,
                "http://placekitten.com/160/160",
                10000);
    }
}
