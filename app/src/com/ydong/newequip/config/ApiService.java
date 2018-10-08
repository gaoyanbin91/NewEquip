package com.ydong.newequip.config;

/**
 * Created by Yanbin on 2018/9/7.
 * 描述:接口管理
 */
public class ApiService {

    public static final String BASE_URL = "http://39.106.100.243/";//外网

    public static final String LOGIN_UP = BASE_URL + "login/doLoginForApp";// 登陆
    public static final String QUERY_DRVICE_MANAGES = BASE_URL+"app/equip/queryListAjax";//获取设备管理列表
    public static final String QUERY_MAINTAIN_COUNT = BASE_URL + "app/case/queryCountAjax";//获取维修工单状态个数
    public static final String QUERY_TASK_LIST = BASE_URL + "app/case/queryTaskList";//获取维修工单列表数据
    public static final String UODATE_EVEN = BASE_URL + "app/case/doRegCase";//维修工单上报
    public static final String QUERY_METER_COUNT = BASE_URL + "app/order/queryCountAjax";//巡检工单状态个数
    public static final String QUERY_INSPECTOR_LISTS = BASE_URL + "app/order/queryListAjax";//巡检工单列表
    public static final String MOD_PASSWORD = BASE_URL + "login/modPassword";//修改密码
}
