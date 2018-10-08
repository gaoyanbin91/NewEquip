package com.ydong.newequip.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yanbin on 2018/9/10.
 * 描述:
 */
public class DeviceManageBean implements Serializable {


    /**
     * page : 1
     * records : 24
     * rows : [{"amount":1,"code":"3#","createTime":"2018-9-02 21:41","creater":"sys","id":"5","image":[],"installPosition":"油漆东制冷站","isKey":1,"leavFactoryCode":"50611H54041962","mainTechParam":"Ql=240RT，制冷量843kW,380V 3PH 50HZ,164KW,R134a,272kg,","major":"7","majorName":"动力","measureUnit":"台","name":"约克冷冻机","position":"油漆东制冷站","prodEnter":"约克（无锡）空调冷冻设备有限公司","prodEnterTel":"400-820-6607","qrCode":"50611H54041962","region":"综合站房","type":"YRTDTBT1550C/22"},{"amount":1,"code":"3#","createTime":"2018-9-02 21:41","creater":"sys","id":"0009b0ebe405450e84d8bc4e8652949b","image":[],"installPosition":"油漆西制冷站","isKey":1,"leavFactoryCode":"50611H54041945","mainTechParam":"Ql=1000RT，制冷量3516kW,380V 3PH 50HZ,650KW,R134a,814kg,","major":"4","majorName":"电气","measureUnit":"台","name":"约克冷冻机","position":"油漆西制冷站","prodEnter":"约克（无锡）空调冷冻设备有限公司","prodEnterTel":"400-820-6607","qrCode":"50611H54041945","region":"综合站房","type":"YK12K4H95CWG/RP22"},{"amount":1,"code":"3#","createTime":"2018-9-02 21:41","creater":"sys","id":"0b92b399d7654d74abf5bbd852f5eeff","image":[],"installPosition":"油漆东制冷站","isKey":1,"leavFactoryCode":"50611H54041962","mainTechParam":"Ql=240RT，制冷量843kW,380V 3PH 50HZ,164KW,R134a,272kg,","major":"7","majorName":"动力","measureUnit":"台","name":"约克冷冻机","position":"油漆东制冷站","prodEnter":"约克（无锡）空调冷冻设备有限公司","prodEnterTel":"400-820-6607","qrCode":"50611H54041962","region":"综合站房","type":"YRTDTBT1550C/22"}]
     * success : true
     * total : 8
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

    public static class RowsBean implements Serializable{
        /**
         * amount : 1
         * code : 3#
         * createTime : 2018-9-02 21:41
         * creater : sys
         * id : 5
         * image : []
         * installPosition : 油漆东制冷站
         * isKey : 1
         * leavFactoryCode : 50611H54041962
         * mainTechParam : Ql=240RT，制冷量843kW,380V 3PH 50HZ,164KW,R134a,272kg,
         * major : 7
         * majorName : 动力
         * measureUnit : 台
         * name : 约克冷冻机
         * position : 油漆东制冷站
         * prodEnter : 约克（无锡）空调冷冻设备有限公司
         * prodEnterTel : 400-820-6607
         * qrCode : 50611H54041962
         * region : 综合站房
         * type : YRTDTBT1550C/22
         */

        private int amount;
        private String code;
        private String createTime;
        private String creater;
        private String id;
        private String installPosition;
        private int isKey;
        private String leavFactoryCode;
        private String mainTechParam;
        private String major;
        private String majorName;
        private String measureUnit;
        private String name;
        private String position;
        private String prodEnter;
        private String prodEnterTel;
        private String qrCode;
        private String region;
        private String type;
        private List<?> image;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

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

        public String getInstallPosition() {
            return installPosition;
        }

        public void setInstallPosition(String installPosition) {
            this.installPosition = installPosition;
        }

        public int getIsKey() {
            return isKey;
        }

        public void setIsKey(int isKey) {
            this.isKey = isKey;
        }

        public String getLeavFactoryCode() {
            return leavFactoryCode;
        }

        public void setLeavFactoryCode(String leavFactoryCode) {
            this.leavFactoryCode = leavFactoryCode;
        }

        public String getMainTechParam() {
            return mainTechParam;
        }

        public void setMainTechParam(String mainTechParam) {
            this.mainTechParam = mainTechParam;
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

        public String getMeasureUnit() {
            return measureUnit;
        }

        public void setMeasureUnit(String measureUnit) {
            this.measureUnit = measureUnit;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getProdEnter() {
            return prodEnter;
        }

        public void setProdEnter(String prodEnter) {
            this.prodEnter = prodEnter;
        }

        public String getProdEnterTel() {
            return prodEnterTel;
        }

        public void setProdEnterTel(String prodEnterTel) {
            this.prodEnterTel = prodEnterTel;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<?> getImage() {
            return image;
        }

        public void setImage(List<?> image) {
            this.image = image;
        }
    }
}
