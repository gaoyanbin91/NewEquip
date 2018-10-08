package com.ydong.newequip.model;

import java.io.Serializable;

/**
 * Created by Yanbin on 2018/9/7.
 * 描述: 登录成功
 */
public class LoginBean implements Serializable {



    /**
     * msg : 登录成功
     * data : {"password":"e10adc3949ba59abbe56e057f20f883e","phone":"15536629885","roleId":"role1","nickname":"刘桂","roleName":"巡检员","id":"22a55ef3d91942f2aef0a7d6218e24a1","email":null,"username":"lk2","status":"0"}
     * success : true
     */

    private String msg;
    private DataBean data;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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
         * password : e10adc3949ba59abbe56e057f20f883e
         * phone : 15536629885
         * roleId : role1
         * nickname : 刘桂
         * roleName : 巡检员
         * id : 22a55ef3d91942f2aef0a7d6218e24a1
         * email : null
         * username : lk2
         * status : 0
         */

        private String password;
        private String phone;
        private String roleId;
        private String nickname;
        private String roleName;
        private String id;
        private Object email;
        private String username;
        private String status;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
