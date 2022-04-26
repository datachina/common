package lang.exception;

import lombok.NoArgsConstructor;

/**
 * 未登录异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class NotLoginException extends BaseException {

    /**
     * @param message 异常消息
     */
    public NotLoginException(String message) {
        super(message);
    }
}