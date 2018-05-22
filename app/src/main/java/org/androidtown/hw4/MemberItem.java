package org.androidtown.hw4;

public class MemberItem {
    String name;
    String mobile;
    String birth;
    int resId;

    public MemberItem(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public MemberItem(String name, String mobile, String birth) {
        this.name = name;
        this.birth = birth;
        this.mobile = mobile;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return birth;
    }

    public void setDate(String date) {
        this.birth = date;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}