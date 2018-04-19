package com.wangpu;

/**
 * Created by Kenvin on 2018/4/19.
 */
public class Demo {
    @CheckCase(value = CaseMode.LOWER,message = "userName必须是小写")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
