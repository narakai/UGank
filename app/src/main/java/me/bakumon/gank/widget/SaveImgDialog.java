package me.bakumon.gank.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import me.bakumon.gank.R;
import me.bakumon.gank.base.BaseDialog;

/**
 * 上传图片对话框
 * Created by bakumon on 2016/10/12.
 */

public class SaveImgDialog extends BaseDialog implements View.OnClickListener {

    @BindView(R.id.tv_save_img)
    TextView mTvSaveImg;

    private Activity mContext;

    private OnItemClick mOnItemClick;

    public SaveImgDialog(Context context, int layoutId) {
        super(context, layoutId, R.style.MyDialog);
    }

    public SaveImgDialog(Activity context) {
        super(context, R.layout.dialog_save_img, R.style.MyDialog);
        this.mContext = context;
        initView();
    }

    private void initView() {
        mTvSaveImg.setOnClickListener(this);
    }

    public interface OnItemClick {
        void onItemClick();
    }

    public void setItemClick(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    @Override
    public void onClick(View view) {
        dismiss();
        if (mOnItemClick != null) {
            mOnItemClick.onItemClick();
        }
    }
}
