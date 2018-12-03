package piesat.cn.wanandroid.base.baseMvp;

/**
 * @packageName: piesat.cn.wanandroid.base.baseMvp
 * @fileName: BasePer
 * @date: 2018/8/6  13:25
 * @author: wangyi
 */

public interface BasePre<T extends BaseView> {

    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();

}
