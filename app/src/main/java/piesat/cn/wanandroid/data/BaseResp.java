package piesat.cn.wanandroid.data;

/**
 * 作者：wangyi
 * <p>  返回值外层数据的基类
 * 邮箱：wangyi@piesat.cn
 */
public class BaseResp<T>{
    private T data;
    private int errorCode;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private String errorMsg;
}
