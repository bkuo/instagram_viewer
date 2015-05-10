package us.ridiculousbakery.instagramviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by bkuo on 5/8/15.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, R.layout.item_photo, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstagramPhoto photo = getItem(position);
        if (convertView==null){
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        CommentView tvCaption = (CommentView)convertView.findViewById(R.id.tvCaption);
        CommentView tvUsername = (CommentView)convertView.findViewById(R.id.tvUsername);
        TextView tvLikes = (TextView)convertView.findViewById(R.id.tvLikes);
        ImageView ivPhoto = (ImageView)convertView.findViewById(R.id.ivPhoto);
        ImageView ivAvatar  = (ImageView)convertView.findViewById(R.id.ivAvatar);
        tvCaption.setUsernameComment(photo.username, photo.caption);
//        Spannable username = new SpannableString(photo.username);
//        username.setSpan(new ForegroundColorSpan(Color.BLUE),0,photo.username.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        if(photo.caption!=null){
//            tvCaption.setText(username);
//            tvCaption.append(" "+photo.caption);
//        }else{
//            tvCaption.setText("");
//        }
//        tvCaption.setText( (photo.caption==null) ? "": photo.username + " "+ photo.caption);
        tvUsername.setUsernameComment(photo.username, "");
        tvLikes.setText(((Integer)photo.likesCount).toString()+" likes");
        ivPhoto.setImageResource(0);
        ivAvatar.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);
        Picasso.with(getContext()).load(photo.avatarUrl).into(ivAvatar);

        return convertView;
    }
}
