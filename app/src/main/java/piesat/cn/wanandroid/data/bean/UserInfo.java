package piesat.cn.wanandroid.data.bean;

import java.util.List;

/**
 * 作者：wangyi
 * <p>  登陆注册
 * 邮箱：wangyi@piesat.cn
 */
public class UserInfo {

    private String email;
    private String icon;
    private int id;
    private String password;
    private int type;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<?> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<?> collectIds) {
        this.collectIds = collectIds;
    }

    private String username;
    private List<?> collectIds;

}
