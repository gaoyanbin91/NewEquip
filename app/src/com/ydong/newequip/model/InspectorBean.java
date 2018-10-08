package com.ydong.newequip.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yanbin on 2018/9/20.
 * 描述:巡检工单
 */
public class InspectorBean implements Serializable {

    /**
     * data : {"page":"1","records":7,"rows":[{"createTime":"2018-9-17 09:10","creater":"system","id":"adabb757698747db88d4323f8b538414","image":[],"recordCode":"ORDER-201809170910154","recordName":"(系统)测试功能201809170910","recordTime":"2018-9-17 10:57","recorder":"22a55ef3d91942f2aef0a7d6218e24a1","recorderName":"刘桂","result":1,"username":"王超"},{"createTime":"2018-9-17 09:10","creater":"system","id":"e75599aea2be4b229f4b7080b95e449e","image":[],"recordCode":"ORDER-201809170910180","recordName":"(系统)测试功能201809170910","recordTime":"2018-9-18 10:56","recorder":"1ba7983ed86f497587f56e4bec263150","recorderName":"张爱婷","result":1},{"createTime":"2018-9-17 01:10","creater":"system","id":"3f970bd6a99d41bd871f1cd3a20508a1","image":[],"recordCode":"ORDER-201809170110760","recordName":"(系统)测试功能201809170110","recordTime":"2018-9-17 10:57","recorder":"22a55ef3d91942f2aef0a7d6218e24a1","recorderName":"刘桂","result":1},{"createTime":"2018-9-10 01:10","creater":"system","id":"9b4cb8cfe0d74f529170401ca50aecaa","image":[],"recordCode":"ORDER-201809100110839","recordName":"(系统)测试功能201809100110","recordTime":"2018-9-11 11:04","recorder":"1ba7983ed86f497587f56e4bec263150","recorderName":"张爱婷","result":1},{"createTime":"2018-9-09 11:16","creater":"039c994128b64c43bfc47c3fb8a52294","id":"5534ac62c5ea4e2ebe905932d205c3e2","image":[],"recordCode":"ORDER-201809092316706","recordName":"测试临时巡检","recordTime":"2018-9-09 23:17","recorder":"22a55ef3d91942f2aef0a7d6218e24a1","recorderName":"刘桂","result":1,"username":"王超"}],"success":true,"total":2}
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
         * page : 1
         * records : 7
         * rows : [{"createTime":"2018-9-17 09:10","creater":"system","id":"adabb757698747db88d4323f8b538414","image":[],"recordCode":"ORDER-201809170910154","recordName":"(系统)测试功能201809170910","recordTime":"2018-9-17 10:57","recorder":"22a55ef3d91942f2aef0a7d6218e24a1","recorderName":"刘桂","result":1},{"createTime":"2018-9-17 09:10","creater":"system","id":"e75599aea2be4b229f4b7080b95e449e","image":[],"recordCode":"ORDER-201809170910180","recordName":"(系统)测试功能201809170910","recordTime":"2018-9-18 10:56","recorder":"1ba7983ed86f497587f56e4bec263150","recorderName":"张爱婷","result":1},{"createTime":"2018-9-17 01:10","creater":"system","id":"3f970bd6a99d41bd871f1cd3a20508a1","image":[],"recordCode":"ORDER-201809170110760","recordName":"(系统)测试功能201809170110","recordTime":"2018-9-17 10:57","recorder":"22a55ef3d91942f2aef0a7d6218e24a1","recorderName":"刘桂","result":1},{"createTime":"2018-9-10 01:10","creater":"system","id":"9b4cb8cfe0d74f529170401ca50aecaa","image":[],"recordCode":"ORDER-201809100110839","recordName":"(系统)测试功能201809100110","recordTime":"2018-9-11 11:04","recorder":"1ba7983ed86f497587f56e4bec263150","recorderName":"张爱婷","result":1},{"createTime":"2018-9-09 11:16","creater":"039c994128b64c43bfc47c3fb8a52294","id":"5534ac62c5ea4e2ebe905932d205c3e2","image":[],"recordCode":"ORDER-201809092316706","recordName":"测试临时巡检","recordTime":"2018-9-09 23:17","recorder":"22a55ef3d91942f2aef0a7d6218e24a1","recorderName":"刘桂","result":1,"username":"王超"}]
         * success : true
         * total : 2
         */

        private String page;
        private int records;
        private boolean success;
        private int total;
        private List<RowsBean> rows;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * createTime : 2018-9-17 09:10
             * creater : system
             * id : adabb757698747db88d4323f8b538414
             * image : []
             * recordCode : ORDER-201809170910154
             * recordName : (系统)测试功能201809170910
             * recordTime : 2018-9-17 10:57
             * recorder : 22a55ef3d91942f2aef0a7d6218e24a1
             * recorderName : 刘桂
             * result : 1
             * username : 王超
             */

            private String createTime;
            private String creater;
            private String id;
            private String recordCode;
            private String recordName;
            private String recordTime;
            private String recorder;
            private String recorderName;
            private int result;
            private String username;
            private List<?> image;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreater() {
                return creater;
            }

            public void setCreater(String creater) {
                this.creater = creater;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRecordCode() {
                return recordCode;
            }

            public void setRecordCode(String recordCode) {
                this.recordCode = recordCode;
            }

            public String getRecordName() {
                return recordName;
            }

            public void setRecordName(String recordName) {
                this.recordName = recordName;
            }

            public String getRecordTime() {
                return recordTime;
            }

            public void setRecordTime(String recordTime) {
                this.recordTime = recordTime;
            }

            public String getRecorder() {
                return recorder;
            }

            public void setRecorder(String recorder) {
                this.recorder = recorder;
            }

            public String getRecorderName() {
                return recorderName;
            }

            public void setRecorderName(String recorderName) {
                this.recorderName = recorderName;
            }

            public int getResult() {
                return result;
            }

            public void setResult(int result) {
                this.result = result;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public List<?> getImage() {
                return image;
            }

            public void setImage(List<?> image) {
                this.image = image;
            }
        }
    }
}
