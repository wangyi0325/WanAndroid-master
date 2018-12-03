package piesat.cn.wanandroid.base.baseMvp;

/**
 * view 基础接口
 *
 * @packageName: piesat.cn.wanandroid.base.baseMvp
 * @fileName: BaseView
 * @date: 2018/7/23  14:14
 * @author: wangyi
 */

public interface BaseView {

    /**
     * 显示正常
     */
    void showNormal();

    /**
     * 显示失败
     */
    void showError(String err);

    /**
     * 正在加载
     */
    void showLoading();

    /**
     * 显示为空
     */
    void showEmpty();

    /**
     * Reload
     */
    void reload();
}
