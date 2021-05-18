package io.qdriven.qaopsdaily.core.conf.constant;

public interface TopsConstant {

    /**
     * 注册用户角色ID
     */
    Long REGISTER_DEFAULT_ROLE_ID = 2L;

    /**
     * 排序规则：降序
     */
    String DESC_ORDER = "desc";

    /**
     * 排序规则：升序
     */
    String ASC_ORDER = "asc";

    /**
     * 前端页面路径前缀
     */
    String VIEW_PREFIX = "tops/views/";

    /**
     * 允许下载的文件类型，根据需求自己添加（小写）
     */
    String[] VALID_FILE_TYPE = {"xlsx", "zip","pdf","img"};

    /**
     * shiro线程池名称
     */
    String SHIRO_THREAD_POOL = "topsShiroThreadPool";

    /**
     * shiro线程名称前缀
     */
    String TOPS_SHIRO_THREAD_NAME_PREFIX = "tops-shiro-thread-";

    /**
     * 开发环境
     */
    String DEVELOP = "dev";

    /**
     * Windows 操作系统
     */
    String SYSTEM_WINDOWS = "windows";

    String REQUEST_ALL = "/**";

    String DAY_START_PATTERN_SUFFIX = " 00:00:00";
    String DAY_END_PATTERN_SUFFIX = " 23:59:59";

    /**
     * 验证码ey前缀
     */
    String VALIDATION_CODE_PREFIX = "tops_captcha_";

    /**
     * 验证码有效期Key前缀
     */
    String VALIDATION_CODE_TIME_PREFIX = "tops_captcha_time_";
    String PROPERTIES_PREFIX = "tops";
}