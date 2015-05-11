package us.ridiculousbakery.instagramviewer;

import android.content.Context;
import android.text.format.DateUtils;
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
        ViewHolder viewHolder;
        InstagramPhoto photo = getItem(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
            viewHolder.tvCaption = (CommentView) convertView.findViewById(R.id.tvCaption);
            viewHolder.tvUsername = (CommentView) convertView.findViewById(R.id.tvUsername);
            viewHolder.tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
            viewHolder.ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
            viewHolder.ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
            viewHolder.tvCreatedAt = (TextView) convertView.findViewById(R.id.tvCreatedAt);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvCaption.setUsernameComment(photo.username, photo.caption);
        viewHolder.tvCreatedAt.setText(
                ((String) DateUtils.getRelativeTimeSpanString(photo.created_at * 1000,
                        System.currentTimeMillis(),
                        DateUtils.MINUTE_IN_MILLIS,
                        DateUtils.FORMAT_ABBREV_RELATIVE
                )).replaceFirst("(\\d+) (\\S).*", "$1$2")
        );
        viewHolder.tvUsername.setUsernameComment(photo.username, "");
        viewHolder.tvLikes.setText(((Integer) photo.likesCount).toString() + " likes");
        viewHolder.ivPhoto.setImageResource(0);
        viewHolder.ivAvatar.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).into(viewHolder.ivPhoto);
        Picasso.with(getContext()).load(photo.avatarUrl).into(viewHolder.ivAvatar);
        return convertView;
    }

    private class ViewHolder {
        public InstagramPhoto item;
        public CommentView tvCaption;
        public CommentView tvUsername;
        public TextView tvLikes;
        public ImageView ivPhoto;
        public ImageView ivAvatar;
        public TextView tvCreatedAt;
    }
}
