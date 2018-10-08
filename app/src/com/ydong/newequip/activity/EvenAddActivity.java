package com.ydong.newequip.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ydong.newequip.R;
import com.ydong.newequip.activity.base.BaseActivity;
import com.ydong.newequip.adapter.ImageViewVpAdapter;
import com.ydong.newequip.comm.Comm;
import com.ydong.newequip.comm.Global;
import com.ydong.newequip.uitls.AppConfig;
import com.ydong.newequip.uitls.FileUtil;
import com.ydong.newequip.uitls.GlideUtils;
import com.ydong.newequip.uitls.LogUtils;
import com.ydong.newequip.uitls.ToastUtils;
import com.ydong.newequip.view.photo.PhotoPickerActivity;
import com.ydong.newequip.view.photo.PhotoPickerIntent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;

/**
 * Created by Yanbin on 2018/9/18.
 * 描述:报修上传
 */
public class EvenAddActivity extends BaseActivity implements ImageViewVpAdapter.OnImageClick {

    @BindView(R.id.ll_imgv)
    LinearLayout mLinearLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ll_major)
    View llMajor;
    @BindView(R.id.tex_major)
    TextView textMajor;//专业
    @BindView(R.id.text_level)
    TextView textLevel;//级别
    @BindView(R.id.rg_type)
    RadioGroup rgType;//类型
    @BindView(R.id.iv_qrcode)
    ImageView ivQrCode;//扫码
    @BindView(R.id.ll_model)
    View llModel;//型号
    @BindView(R.id.ll_add_person)
    View llAddPerson;//报修人行
    @BindView(R.id.text_person_name)
    TextView textPerosnName;//报修人
    @BindView(R.id.ll_add_phone)
    View llAddPhone;//电话布局
    @BindView(R.id.text_person_phone)
    TextView textPersonPhone;//电话
    @BindView(R.id.text_model_name)
    TextView textModelName;//设备名称


    private RadioButton selectButton;//选中的类型
    private String typeText = "";//类型

    private List<String> imgvUrlList = new ArrayList<>();
    private List<File> imgFiles = new ArrayList<>();
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    private PopupWindow imagePopupWindow;
    private ViewPager vp_photos;
    private TextView txv_page;
    private int vpNum = 0;
    private TextView mTittle;
    private ImageViewVpAdapter imageViewVpAdapter;
    private final static int IMAGE_CHOSE_REQUEST = 1000;
    private final static int IMAGE_CUT_REQUEST = 1001;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_even_add;
    }

    @Override
    public void initView() {

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTittle = findViewById(R.id.mTitle);
        imageViewVpAdapter = new ImageViewVpAdapter(this, new ArrayList<String>());
        imageViewVpAdapter.setOnImageClick(this);
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectButton = (RadioButton) findViewById(rgType.getCheckedRadioButtonId());
                typeText = selectButton.getText().toString();
                if (typeText.equals("正常")) {
                    llAddPerson.setVisibility(View.GONE);
                    llAddPhone.setVisibility(View.GONE);
                    ivQrCode.setVisibility(View.VISIBLE);
                    llModel.setVisibility(View.VISIBLE);
                    textModelName.setText("");

                } else {
                    llAddPhone.setVisibility(View.VISIBLE);
                    llModel.setVisibility(View.GONE);
                    llAddPerson.setVisibility(View.VISIBLE);
                    ivQrCode.setVisibility(View.GONE);
                    textModelName.setText("外报设备");
                }

            }
        });
        ivQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(baseContext, CaptureActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        showSelectImgv();

    }

    @Override
    public void initData() {

        textPerosnName.setText(AppConfig.getInstance().getString("nikeName", ""));
        textPersonPhone.setText(AppConfig.getInstance().getString("phone", ""));
    }

    /**
     * 显示图片
     */
    private void showSelectImgv() {
        mLinearLayout.removeAllViews();
        for (final String url : imgvUrlList) {

            View view = LayoutInflater.from(this).inflate(R.layout.layout_imgv_faceback, null);
            ImageView imgv_face = (ImageView) view.findViewById(R.id.imgv_face);
            View rl_pic = view.findViewById(R.id.rl_pic);

            ImageView imgv_del = (ImageView) view.findViewById(R.id.imgv_del);
            imgv_del.setVisibility(View.VISIBLE);
            imgv_del.setTag(url);
            rl_pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (imagePopupWindow == null) {
                        initImagePop();
                    }
                    vpNum = imgvUrlList.size();
                    ToastUtils.showShort(imgvUrlList.size() + "个数");
                    imageViewVpAdapter.setData(imgvUrlList);
                    //   vp_photos.setCurrentItem(clickPositon);
                    //   txv_page.setText((clickPositon + 1) + "/" + vpNum);
                    imagePopupWindow.showAtLocation(mTittle, Gravity.BOTTOM, 0, 0);

                }
            });
            imgv_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = (String) v.getTag();
                    //   imgvNetUrlList.remove(imgvUrlList.indexOf(url));
                    imgvUrlList.remove(url);
                    imgFiles.remove(new File(url));
                    /// ToastUtils.showShort(imgFiles.size()+"");
                    showSelectImgv();
                }
            });

            GlideUtils.load(url, imgv_face);
            mLinearLayout.addView(view);
        }

        if (imgvUrlList.size() < 9) {
            View defaultView = LayoutInflater.from(this).inflate(R.layout.layout_imgv_faceback, null);
            ImageView imgv_default = (ImageView) defaultView.findViewById(R.id.imgv_face);
            imgv_default.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PhotoPickerIntent intent = new PhotoPickerIntent(EvenAddActivity.this);
                    intent.setPhotoCount(1);
                    intent.setShowCamera(true);
                    startActivityForResult(intent, IMAGE_CHOSE_REQUEST);
                }
            });
            mLinearLayout.addView(defaultView);
        }
    }

    /**
     * 点击查看大图片
     */
    private void initImagePop() {
        try {
            View view = LayoutInflater.from(this).inflate(R.layout.layout_showpic_pop, null);
            vp_photos = (ViewPager) view.findViewById(R.id.vp_photos);
            vp_photos.setAdapter(imageViewVpAdapter);
            txv_page = (TextView) view.findViewById(R.id.txv_page);
            vp_photos.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    txv_page.setText((vp_photos.getCurrentItem() + 1) + "/" + vpNum);
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });

            imagePopupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imagePopupWindow.setAnimationStyle(R.style.Animation_AppCompat_Dialog);
            //获取popwindow焦点
            imagePopupWindow.setFocusable(true);
            imagePopupWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
            //设置popwindow如果点击外面区域，便关闭。

            imagePopupWindow.setTouchInterceptor(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                        imagePopupWindow.dismiss();
                        return true;
                    }
                    return false;
                }
            });
        } catch (Throwable e) {
            LogUtils.e("", e);
        }
    }

    @OnClick({R.id.ll_major, R.id.text_level})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_major:
                    String[] majors = {"电气", "动力", "给排水", "电气低压"};
                    ShowChoise(majors, textMajor, "--请选择专业--");
                break;
            case R.id.text_level:
                String[] levels = {"A", "B", "C"};
                ShowChoise(levels, textLevel, "--请选择问题级别--");
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case 0:
                if (data.getStringExtra("return") != null) {
                    ToastUtils.showShort(data.getStringExtra("return"));
                }

                break;

            case IMAGE_CHOSE_REQUEST:
                if (data != null) {
                    List<String> photos = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
                    if (photos != null && photos.size() > 0) {
                        imgvUrlList.addAll(photos);
                        showSelectImgv();
                        Uri uri = Uri.fromFile(new File(photos.get(0)));
                        //  AppTools.startPhotoZoom(this, uri, IMAGE_CUT_REQUEST);
                    }
                }
                break;
            case IMAGE_CUT_REQUEST:
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                    options.inJustDecodeBounds = false;
                    final Bitmap photo = BitmapFactory.decodeFile(Global.uritempFile.getPath(), options);

                    final String imgName = String.valueOf(System.currentTimeMillis());
                    FileUtil.saveSDcardImage(photo, Comm.SDCARD_IMG_ROOT, imgName);
                    String filepath = Comm.SDCARD_IMG_ROOT + "/" + imgName + ".png";
                    imgvUrlList.add(filepath);
                    imgFiles.add(new File(filepath));
                    showSelectImgv();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }


    }

    private void ShowChoise(final String[] items, final TextView textView, String title) {

        AlertDialog.Builder builder = new AlertDialog.Builder(baseContext, R.style.AlertDialog);
        //builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle(title);
        //    指定下拉列表的显示数据
        //  final String[] majors = {"电气", "动力", "给排水", "电气低压"};
        //    设置一个下拉的列表选择项
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText(items[which]);
            }
        });
        builder.show();
    }

    @Override
    public void click() {
        if (imagePopupWindow != null && imagePopupWindow.isShowing()) {
            imagePopupWindow.dismiss();
        }
    }
}
