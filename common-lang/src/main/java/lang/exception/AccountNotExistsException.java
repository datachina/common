package lang.exception;

import lombok.NoArgsConstructor;

/**
 * 账号不存在异常，一般用于登陆
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class AccountNotExistsException extends BaseException {

    /**
     * @param message 异常消息
     */
    public AccountNotExistsException(String message) {
        super(message);
    }
}