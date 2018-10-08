package com.ydong.newequip.model;

import java.io.Serializable;

/**
 * Created by Yanbin on 2018/9/20.
 * 描述:巡检工单
 */
public class InspectorCountBean implements Serializable {

    /**
     * data : {"yixunjianCount":2,"jieshouCount":0,"xunjianCount":7,"totalCount":9}
     * success : true
     */

    private DataBean data;
    private boolean success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * yixunjianCount : 2
         * jieshouCount : 0
         * xunjianCount : 7
         * totalCount : 9
         */

        private int yixunjianCount;
        private int jieshouCount;
        private int xunjianCount;
        private int totalCount;

        public int getYixunjianCount() {
            return yixunjianCount;
        }

        public void setYixunjianCount(int yixunjianCount) {
            this.yixunjianCount = yixunjianCount;
        }

        public int getJieshouCount() {
            return jieshouCount;
        }

        public void setJieshouCount(int jieshouCount) {
            this.jieshouCount = jieshouCount;
        }

        public int getXunjianCount() {
            return xunjianCount;
        }

        public void setXunjianCount(int xunjianCount) {
            this.xunjianCount = xunjianCount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
    }
}
