package cn.hykd.base.controller;

import org.apache.log4j.Logger;

public class BaseController {
    public static Logger logger = Logger.getLogger(BaseController.class);

    public static final String SYS_ERROR = "{status:500, msg:\"系统错误\", version:1}";

    public static final String NOT_FUND = "not fund";

}
