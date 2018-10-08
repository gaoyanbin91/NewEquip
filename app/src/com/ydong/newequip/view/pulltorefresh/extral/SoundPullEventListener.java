package com.ydong.newequip.view.pulltorefresh.extral;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;

import com.ydong.newequip.view.pulltorefresh.PullToRefreshBase;

import java.util.HashMap;

/**
 * Created by gaoyanbin on 2018/4/16.
 * 描述:
 */

public class SoundPullEventListener<V extends View> implements PullToRefreshBase.OnPullEventListener<V> {
    private final Context mContext;
    private final HashMap<PullToRefreshBase.State, Integer> mSoundMap;
    private MediaPlayer mCurrentMediaPlayer;

    public SoundPullEventListener(Context context) {
        this.mContext = context;
        this.mSoundMap = new HashMap();
    }

    public final void onPullEvent(PullToRefreshBase<V> refreshView, PullToRefreshBase.State event, PullToRefreshBase.Mode direction) {
        Integer soundResIdObj = (Integer)this.mSoundMap.get(event);
        if (null != soundResIdObj) {
            this.playSound(soundResIdObj);
        }

    }

    public void addSoundEvent(PullToRefreshBase.State event, int resId) {
        this.mSoundMap.put(event, resId);
    }

    public void clearSounds() {
        this.mSoundMap.clear();
    }

    public MediaPlayer getCurrentMediaPlayer() {
        return this.mCurrentMediaPlayer;
    }

    private void playSound(int resId) {
        if (null != this.mCurrentMediaPlayer) {
            this.mCurrentMediaPlayer.stop();
            this.mCurrentMediaPlayer.release();
        }

        this.mCurrentMediaPlayer = MediaPlayer.create(this.mContext, resId);
        if (null != this.mCurrentMediaPlayer) {
            this.mCurrentMediaPlayer.start();
        }

    }
}

