package cn.proflu.profluweb.common.exception;

import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;

public class ThisAssert {


    public static void getThisExcepton(final ErrorCodeEnum errorCode) throws ThisExcepton {
        throw new ThisExcepton(errorCode);
    }

    public static void getIsNotNull(String str, final ErrorCodeEnum errorCode) throws ThisExcepton {
        if (str == null || str.equals("")) {
            getThisExcepton(errorCode);
        }
    }


}
