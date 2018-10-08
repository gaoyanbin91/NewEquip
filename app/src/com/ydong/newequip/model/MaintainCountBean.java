package com.ydong.newequip.model;

import java.io.Serializable;

/**
 * Created by Yanbin on 2018/9/11.
 * 描述:工单种类个数
 */
public class MaintainCountBean implements Serializable {

    /**
     * data : {"daijieshouCount":2,"daichuliCount":1,"yichuliCount":1,"daidaochangCount":0,"totalCount":4}
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
         * daijieshouCount : 2
         * daichuliCount : 1
         * yichuliCount : 1
         * daidaochangCount : 0
         * totalCount : 4
         */

        private int daijieshouCount;
        private int daichuliCount;
        private int yichuliCount;
        private int daidaochangCount;
        private int totalCount;

        public int getDaijieshouCount() {
            return daijieshouCount;
        }

        public void setDaijieshouCount(int daijieshouCount) {
            this.daijieshouCount = daijieshouCount;
        }

        public int getDaichuliCount() {
            return daichuliCount;
        }

        public void setDaichuliCount(int daichuliCount) {
            this.daichuliCount = daichuliCount;
        }

        public int getYichuliCount() {
            return yichuliCount;
        }

        public void setYichuliCount(int yichuliCount) {
            this.yichuliCount = yichuliCount;
        }

        public int getDaidaochangCount() {
            return daidaochangCount;
        }

        public void setDaidaochangCount(int daidaochangCount) {
            this.daidaochangCount = daidaochangCount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
    }
}
