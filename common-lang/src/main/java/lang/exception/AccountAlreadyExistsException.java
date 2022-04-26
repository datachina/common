package lang.exception;

import lombok.NoArgsConstructor;

/**
 * 账号已存在异常，一般用于注册
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class AccountAlreadyExistsException extends BaseException {

    /**
     * @param message 异常消息
     */
    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}