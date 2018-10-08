package com.ydong.newequip.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yanbin on 2018/9/13.
 * 描述:维修工单实体
 */
public class MainTainTaskBean implements Serializable {


    /**
     * data : {"page":"1","records":3,"rows":[{"acceptLog":{"caseId":"e376a5441ea1436bb04a53de5a9bbb12","createTime":"2018-9-10 23:16","id":"1f7d7ed3bdc545299c9261aee4f6bf71","image":[],"operateTime":"2018-9-11 23:35","operateType":"接收","operater":"22a55ef3d91942f2aef0a7d6218e24a1","operaterName":"刘桂","result":1},"caseInfo":{"createTime":"2018-9-10 23:16","creater":"039c994128b64c43bfc47c3fb8a52294","createrName":"王超","equipId":"0009b0ebe405450e84d8bc4e8652949b","equipName":"约克冷冻机","equipType":"YK12K4H95CWG/RP22","id":"e376a5441ea1436bb04a53de5a9bbb12","image":[],"isCheckScope":1,"isRepairScope":1,"level":"B","major":"4","majorName":"电气","note":"是是是","position":"油漆西制冷站","region":"综合站房","reportPer":"刘坤","reportPhone":"15036625653","result":2},"handleLog":{"caseId":"e376a5441ea1436bb04a53de5a9bbb12","createTime":"2018-9-11 23:36","id":"5be4ea562f6240d48df42252ba209694","image":[],"operateType":"处理","result":0},"presentLog":{"caseId":"e376a5441ea1436bb04a53de5a9bbb12","createTime":"2018-9-11 23:35","id":"cbdc5563089a493ab9fc9ea40963bccd","image":[],"operateTime":"2018-9-11 23:36","operateType":"到场","operater":"22a55ef3d91942f2aef0a7d6218e24a1","operaterName":"刘桂","result":1}},{"acceptLog":{"caseId":"04f62053e30a49cd88c482457c8892c1","createTime":"2018-9-10 23:16","id":"01f48c5d4919473dac67f7cb876d2360","image":[],"operateTime":"2018-9-11 21:48","operateType":"接收","operater":"1ba7983ed86f497587f56e4bec263150","operaterName":"张爱婷","result":1},"caseInfo":{"createTime":"2018-9-10 23:16","creater":"039c994128b64c43bfc47c3fb8a52294","createrName":"王超","equipId":"5","equipName":"约克冷冻机","equipType":"YRTDTBT1550C/22","id":"04f62053e30a49cd88c482457c8892c1","image":[],"isCheckScope":1,"isRepairScope":1,"level":"A","major":"7","majorName":"动力","note":"测试数据","position":"油漆东制冷站","region":"综合站房","reportPer":"刘坤","reportPhone":"15036625653","result":2},"handleLog":{"caseId":"04f62053e30a49cd88c482457c8892c1","createTime":"2018-9-11 21:54","id":"fc65c00a2fc6459f82142de0c7f7ad15","image":[],"operateType":"处理","result":0},"presentLog":{"caseId":"04f62053e30a49cd88c482457c8892c1","createTime":"2018-9-11 21:48","id":"62bd0d9d41f041cabd268050b4df7000","image":[],"operateTime":"2018-9-11 21:54","operateType":"到场","operater":"1ba7983ed86f497587f56e4bec263150","operaterName":"张爱婷","result":2}}],"success":true,"total":1}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * page : 1
         * records : 3
         * rows : [{"acceptLog":{"caseId":"e376a5441ea1436bb04a53de5a9bbb12","createTime":"2018-9-10 23:16","id":"1f7d7ed3bdc545299c9261aee4f6bf71","image":[],"operateTime":"2018-9-11 23:35","operateType":"接收","operater":"22a55ef3d91942f2aef0a7d6218e24a1","operaterName":"刘桂","result":1},"caseInfo":{"createTime":"2018-9-10 23:16","creater":"039c994128b64c43bfc47c3fb8a52294","createrName":"王超","equipId":"0009b0ebe405450e84d8bc4e8652949b","equipName":"约克冷冻机","equipType":"YK12K4H95CWG/RP22","id":"e376a5441ea1436bb04a53de5a9bbb12","image":[],"isCheckScope":1,"isRepairScope":1,"level":"B","major":"4","majorName":"电气","note":"是是是","position":"油漆西制冷站","region":"综合站房","reportPer":"刘坤","reportPhone":"15036625653","result":2},"handleLog":{"caseId":"e376a5441ea1436bb04a53de5a9bbb12","createTime":"2018-9-11 23:36","id":"5be4ea562f6240d48df42252ba209694","image":[],"operateType":"处理","result":0},"presentLog":{"caseId":"e376a5441ea1436bb04a53de5a9bbb12","createTime":"2018-9-11 23:35","id":"cbdc5563089a493ab9fc9ea40963bccd","image":[],"operateTime":"2018-9-11 23:36","operateType":"到场","operater":"22a55ef3d91942f2aef0a7d6218e24a1","operaterName":"刘桂","result":1}},{"acceptLog":{"caseId":"04f62053e30a49cd88c482457c8892c1","createTime":"2018-9-10 23:16","id":"01f48c5d4919473dac67f7cb876d2360","image":[],"operateTime":"2018-9-11 21:48","operateType":"接收","operater":"1ba7983ed86f497587f56e4bec263150","operaterName":"张爱婷","result":1},"caseInfo":{"createTime":"2018-9-10 23:16","creater":"039c994128b64c43bfc47c3fb8a52294","createrName":"王超","equipId":"5","equipName":"约克冷冻机","equipType":"YRTDTBT1550C/22","id":"04f62053e30a49cd88c482457c8892c1","image":[],"isCheckScope":1,"isRepairScope":1,"level":"A","major":"7","majorName":"动力","note":"测试数据","position":"油漆东制冷站","region":"综合站房","reportPer":"刘坤","reportPhone":"15036625653","result":2},"handleLog":{"caseId":"04f62053e30a49cd88c482457c8892c1","createTime":"2018-9-11 21:54","id":"fc65c00a2fc6459f82142de0c7f7ad15","image":[],"operateType":"处理","result":0},"presentLog":{"caseId":"04f62053e30a49cd88c482457c8892c1","createTime":"2018-9-11 21:48","id":"62bd0d9d41f041cabd268050b4df7000","image":[],"operateTime":"2018-9-11 21:54","operateType":"到场","operater":"1ba7983ed86f497587f56e4bec263150","operaterName":"张爱婷","result":2}}]
         * success : true
         * total : 1
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
             * acceptLog : {"caseId":"e376a5441ea1436bb04a53de5a9bbb12","createTime":"2018-9-10 23:16","id":"1f7d7ed3bdc545299c9261aee4f6bf71","image":[],"operateTime":"2018-9-11 23:35","operateType":"接收","operater":"22a55ef3d91942f2aef0a7d6218e24a1","operaterName":"刘桂","result":1}
             * caseInfo : {"createTime":"2018-9-10 23:16","creater":"039c994128b64c43bfc47c3fb8a52294","createrName":"王超","equipId":"0009b0ebe405450e84d8bc4e8652949b","equipName":"约克冷冻机","equipType":"YK12K4H95CWG/RP22","id":"e376a5441ea1436bb04a53de5a9bbb12","image":[],"isCheckScope":1,"isRepairScope":1,"level":"B","major":"4","majorName":"电气","note":"是是是","position":"油漆西制冷站","region":"综合站房","reportPer":"刘坤","reportPhone":"15036625653","result":2}
             * handleLog : {"caseId":"e376a5441ea1436bb04a53de5a9bbb12","createTime":"2018-9-11 23:36","id":"5be4ea562f6240d48df42252ba209694","image":[],"operateType":"处理","result":0}
             * presentLog : {"caseId":"e376a5441ea1436bb04a53de5a9bbb12","createTime":"2018-9-11 23:35","id":"cbdc5563089a493ab9fc9ea40963bccd","image":[],"operateTime":"2018-9-11 23:36","operateType":"到场","operater":"22a55ef3d91942f2aef0a7d6218e24a1","operaterName":"刘桂","result":1}
             */

            private AcceptLogBean acceptLog;
            private CaseInfoBean caseInfo;
            private HandleLogBean handleLog;
            private PresentLogBean presentLog;

            public AcceptLogBean getAcceptLog() {
                return acceptLog;
            }

            public void setAcceptLog(AcceptLogBean acceptLog) {
                this.acceptLog = acceptLog;
            }

            public CaseInfoBean getCaseInfo() {
                return caseInfo;
            }

            public void setCaseInfo(CaseInfoBean caseInfo) {
                this.caseInfo = caseInfo;
            }

            public HandleLogBean getHandleLog() {
                return handleLog;
            }

            public void setHandleLog(HandleLogBean handleLog) {
                this.handleLog = handleLog;
            }

            public PresentLogBean getPresentLog() {
                return presentLog;
            }

            public void setPresentLog(PresentLogBean presentLog) {
                this.presentLog = presentLog;
            }

            public static class AcceptLogBean {
                /**
                 * caseId : e376a5441ea1436bb04a53de5a9bbb12
                 * createTime : 2018-9-10 23:16
                 * id : 1f7d7ed3bdc545299c9261aee4f6bf71
                 * image : []
                 * operateTime : 2018-9-11 23:35
                 * operateType : 接收
                 * operater : 22a55ef3d91942f2aef0a7d6218e24a1
                 * operaterName : 刘桂
                 * result : 1
                 */

                private String caseId;
                private String createTime;
                private String id;
                private String operateTime;
                private String operateType;
                private String operater;
                private String operaterName;
                private int result;
                private List<?> image;

                public String getCaseId() {
                    return caseId;
                }

                public void setCaseId(String caseId) {
                    this.caseId = caseId;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getOperateTime() {
                    return operateTime;
                }

                public void setOperateTime(String operateTime) {
                    this.operateTime = operateTime;
                }

                public String getOperateType() {
                    return operateType;
                }

                public void setOperateType(String operateType) {
                    this.operateType = operateType;
                }

                public String getOperater() {
                    return operater;
                }

                public void setOperater(String operater) {
                    this.operater = operater;
                }

                public String getOperaterName() {
                    return operaterName;
                }

                public void setOperaterName(String operaterName) {
                    this.operaterName = operaterName;
                }

                public int getResult() {
                    return result;
                }

                public void setResult(int result) {
                    this.result = result;
                }

                public List<?> getImage() {
                    return image;
                }

                public void setImage(List<?> image) {
                    this.image = image;
                }
            }

            public static class CaseInfoBean {
                /**
                 * createTime : 2018-9-10 23:16
                 * creater : 039c994128b64c43bfc47c3fb8a52294
                 * createrName : 王超
                 * equipId : 0009b0ebe405450e84d8bc4e8652949b
                 * equipName : 约克冷冻机
                 * equipType : YK12K4H95CWG/RP22
                 * id : e376a5441ea1436bb04a53de5a9bbb12
                 * image : []
                 * isCheckScope : 1
                 * isRepairScope : 1
                 * level : B
                 * major : 4
                 * majorName : 电气
                 * note : 是是是
                 * position : 油漆西制冷站
                 * region : 综合站房
                 * reportPer : 刘坤
                 * reportPhone : 15036625653
                 * result : 2
                 */

                private String createTime;
                private String creater;
                private String createrName;
                private String equipId;
                private String equipName;
                private String equipType;
                private String id;
                private int isCheckScope;
                private int isRepairScope;
                private String level;
                private String major;
                private String majorName;
                private String note;
                private String position;
                private String region;
                private String reportPer;
                private String reportPhone;
                private int result;
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

                public String getCreaterName() {
                    return createrName;
                }

                public void setCreaterName(String createrName) {
                    this.createrName = createrName;
                }

                public String getEquipId() {
                    return equipId;
                }

                public void setEquipId(String equipId) {
                    this.equipId = equipId;
                }

                public String getEquipName() {
                    return equipName;
                }

                public void setEquipName(String equipName) {
                    this.equipName = equipName;
                }

                public String getEquipType() {
                    return equipType;
                }

                public void setEquipType(String equipType) {
                    this.equipType = equipType;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getIsCheckScope() {
                    return isCheckScope;
                }

                public void setIsCheckScope(int isCheckScope) {
                    this.isCheckScope = isCheckScope;
                }

                public int getIsRepairScope() {
                    return isRepairScope;
                }

                public void setIsRepairScope(int isRepairScope) {
                    this.isRepairScope = isRepairScope;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getMajor() {
                    return major;
                }

                public void setMajor(String major) {
                    this.major = major;
                }

                public String getMajorName() {
                    return majorName;
                }

                public void setMajorName(String majorName) {
                    this.majorName = majorName;
                }

                public String getNote() {
                    return note;
                }

                public void setNote(String note) {
                    this.note = note;
                }

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getRegion() {
                    return region;
                }

                public void setRegion(String region) {
                    this.region = region;
                }

                public String getReportPer() {
                    return reportPer;
                }

                public void setReportPer(String reportPer) {
                    this.reportPer = reportPer;
                }

                public String getReportPhone() {
                    return reportPhone;
                }

                public void setReportPhone(String reportPhone) {
                    this.reportPhone = reportPhone;
                }

                public int getResult() {
                    return result;
                }

                public void setResult(int result) {
                    this.result = result;
                }

                public List<?> getImage() {
                    return image;
                }

                public void setImage(List<?> image) {
                    this.image = image;
                }
            }

            public static class HandleLogBean {
                /**
                 * caseId : e376a5441ea1436bb04a53de5a9bbb12
                 * createTime : 2018-9-11 23:36
                 * id : 5be4ea562f6240d48df42252ba209694
                 * image : []
                 * operateType : 处理
                 * result : 0
                 */

                private String caseId;
                private String createTime;
                private String id;
                private String operateType;
                private int result;
                private List<?> image;

                public String getCaseId() {
                    return caseId;
                }

                public void setCaseId(String caseId) {
                    this.caseId = caseId;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getOperateType() {
                    return operateType;
                }

                public void setOperateType(String operateType) {
                    this.operateType = operateType;
                }

                public int getResult() {
                    return result;
                }

                public void setResult(int result) {
                    this.result = result;
                }

                public List<?> getImage() {
                    return image;
                }

                public void setImage(List<?> image) {
                    this.image = image;
                }
            }

            public static class PresentLogBean {
                /**
                 * caseId : e376a5441ea1436bb04a53de5a9bbb12
                 * createTime : 2018-9-11 23:35
                 * id : cbdc5563089a493ab9fc9ea40963bccd
                 * image : []
                 * operateTime : 2018-9-11 23:36
                 * operateType : 到场
                 * operater : 22a55ef3d91942f2aef0a7d6218e24a1
                 * operaterName : 刘桂
                 * result : 1
                 */

                private String caseId;
                private String createTime;
                private String id;
                private String operateTime;
                private String operateType;
                private String operater;
                private String operaterName;
                private int result;
                private List<?> image;

                public String getCaseId() {
                    return caseId;
                }

                public void setCaseId(String caseId) {
                    this.caseId = caseId;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getOperateTime() {
                    return operateTime;
                }

                public void setOperateTime(String operateTime) {
                    this.operateTime = operateTime;
                }

                public String getOperateType() {
                    return operateType;
                }

                public void setOperateType(String operateType) {
                    this.operateType = operateType;
                }

                public String getOperater() {
                    return operater;
                }

                public void setOperater(String operater) {
                    this.operater = operater;
                }

                public String getOperaterName() {
                    return operaterName;
                }

                public void setOperaterName(String operaterName) {
                    this.operaterName = operaterName;
                }

                public int getResult() {
                    return result;
                }

                public void setResult(int result) {
                    this.result = result;
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
}
