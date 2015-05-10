package us.ridiculousbakery.instagramviewer;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by bkuo on 5/10/15.
 */
public class CommentView extends TextView {
    public CommentView(Context context) {
        this(context, null);
    }

    public CommentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    public CommentView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr, 0);
//    }
//    public CommentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    public void setUsernameComment(String userstr, String comment) {
        if (comment == null) {
            setText("");
            return;
        }
        Spannable username = new SpannableString(userstr);
        username.setSpan(new ForegroundColorSpan(Color.BLUE), 0, userstr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(username);
        append(" " + comment);
    }

}
