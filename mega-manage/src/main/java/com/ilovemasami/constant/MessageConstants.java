package com.ilovemasami.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class MessageConstants {
  private static Map<String, String> errorMap = new HashMap<>();


  public interface ErrorFiledName {
    String usernameError = "usernameError";
  }

  interface ErrorTips {
    String usernameError = "用户名不能为空！";
  }

  static {
    errorMap.put(ErrorFiledName.usernameError, ErrorTips.usernameError);
  }


  public static String getErrorTip(String errorName) {
    if (errorMap.containsKey(errorName)) {
      return errorMap.get(errorName);
    }
    return "服务器异常";
  }
}
