package team.next.judgesystem.receiver;

/**
 * Created by YsKun on 2017/6/20.
 * NEXT TEAM copyright
 * 黄日晟
 */
public class UserReceiver {
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Email;
    private String Tel;
    private String Password;
}
