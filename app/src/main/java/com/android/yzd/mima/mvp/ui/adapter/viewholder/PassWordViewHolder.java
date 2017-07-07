package com.android.yzd.mima.mvp.ui.adapter.viewholder;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.yzd.mima.R;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jakewharton.rxbinding.view.RxView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by yezhidong on 2016/1/15.
 */
public class PassWordViewHolder extends RecyclerView.ViewHolder {

    private final TextView mTitleTextView;
    private final TextView mNoteContentTextView;
    private final TextView mTimeTextView;
    private final TextView mMemoInfo;
    private final MaterialRippleLayout ripple;
    private final TextView mPassWordTextView;
    private final FrameLayout mMemoInfoContent;
    private final CircleImageView mImageType;
    private OnRippleClick onRippleClick;
    private final CardView mCardView;

    public PassWordViewHolder(View parent, Context context) {
        super(parent);
        ripple = (MaterialRippleLayout) parent.findViewById(R.id.ripple);
        mTitleTextView = (TextView) parent.findViewById(R.id.main_item_title);
        mNoteContentTextView = (TextView) parent.findViewById(R.id.main_item_name);
        mTimeTextView = (TextView) parent.findViewById(R.id.main_item_date);
        mPassWordTextView = (TextView) parent.findViewById(R.id.main_item_password);
        mMemoInfo = (TextView) parent.findViewById(R.id.memoInfo);
        mMemoInfoContent = (FrameLayout) parent.findViewById(R.id.main_item_note_container);
        mImageType = (CircleImageView) parent.findViewById(R.id.imageType);
        mCardView = (CardView) parent.findViewById(R.id.cardView);
        RxView.clicks(ripple).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe(aVoid -> onRippleClick.onRippleClick(ripple));
        int nextInt = new Random().nextInt(7);
//        int[] colorArray = context.getResources().getIntArray(R.array.item_background_color);
//        mCardView.setCardBackgroundColor(colorArray[nextInt]);
    }

    public void setMemoInfoContentVisibility(boolean visibility) {
        if (visibility) {
            mMemoInfoContent.setVisibility(View.VISIBLE);
        } else {
            mMemoInfoContent.setVisibility(View.GONE);
        }
    }

    public void setMoRen(Context context) {
        mImageType.setBackgroundDrawable(context.getResources().getDrawable(R.mipmap.cartoon_btn_lock_sel));
    }

    public void setYouXiang(Context context) {
        mImageType.setBackgroundDrawable(context.getResources().getDrawable(R.mipmap.cartoon_btn_lock_sel));
    }

    public void setCard(Context context) {
        mImageType.setBackgroundDrawable(context.getResources().getDrawable(R.mipmap.cartoon_btn_lock_sel));
    }

    public void setLabelText(CharSequence text){
        setTextView(mTitleTextView, text);
    }

    public void setLabelText(int text){
        setTextView(mTitleTextView, text);
    }

    public void setContentText(CharSequence text){
        setTextView(mNoteContentTextView, text);
    }

    public void setContentText(int text){
        setTextView(mNoteContentTextView, text);
    }

    public void setTimeText(CharSequence text){
        setTextView(mTimeTextView, text);
    }

    public void setTimeText(int text){
        setTextView(mTimeTextView, text);
    }

    public void setMemoInfo(CharSequence text) {
        setTextView(mMemoInfo, text);
    }

    public TextView getPassWordTextView() {
        return mPassWordTextView;
    }

    public void setPassWordTextView(String passWord) {
        setTextView(mPassWordTextView, passWord);
    }

    private void setTextView(TextView view, CharSequence text){
        if (view == null )
            return;
        if (TextUtils.isEmpty(text))
            view.setVisibility(View.GONE);
        view.setText(text);
    }

    private void setTextView(TextView view, @StringRes int text){
        if (view == null || text <= 0)
            return;
        view.setText(text);
    }

    public void setOnRippleClickListener(OnRippleClick onRippleClick){
        this.onRippleClick = onRippleClick;
    }

    public interface OnRippleClick{
        void onRippleClick(View view);
    }
}
