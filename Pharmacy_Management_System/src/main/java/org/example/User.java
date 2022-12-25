package org.example;

public class User {
    private int ssn;
    private String bdate;
    private String email;
    private String user_password;
    private String phone;
    private String sex;

    private String userType;

    public User(int ssn, String bdate, String email, String user_password, String phone, String sex,String userType) {
        this.ssn = ssn;
        this.bdate = bdate;
        this.email = email;
        this.user_password = user_password;
        this.phone = phone;
        this.sex = sex;
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
