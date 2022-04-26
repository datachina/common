package lang.exception;

import lombok.NoArgsConstructor;

/**
 * 认证码失效异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class AuthCodeInvalidException extends BaseException {

    /**
     * @param message 异常消息
     */
    public AuthCodeInvalidException(String message) {
        super(message);
    }
}