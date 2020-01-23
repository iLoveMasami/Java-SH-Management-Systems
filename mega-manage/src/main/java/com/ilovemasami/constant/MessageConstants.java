package com.ilovemasami.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class MessageConstants {
  private static Map<String, String> errorMap = new HashMap<>();

  public interface Constants {
    int passwordMinLength = 4;
  }


  public interface ErrorFiledName {
    String usernameError = "usernameError";
    String passwordLengthError = "passwordLengthError";
  }

  interface ErrorTips {
    String usernameError = "用户名不能为空！";
    String passwordLengthError = "密码长度不能少于4位！";
  }

  static {
    errorMap.put(ErrorFiledName.usernameError, ErrorTips.usernameError);
    errorMap.put(ErrorFiledName.passwordLengthError, ErrorTips.passwordLengthError);
  }


  public static String getErrorTip(String errorName) {
    if (errorMap.containsKey(errorName)) {
      return errorMap.get(errorName);
    }
    return "服务器异常";
  }
}
