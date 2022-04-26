package lang.exception;

import lombok.NoArgsConstructor;

/**
 * 新增失败异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class AddFailedException extends BaseException {

    /**
     * @param message 异常消息
     */
    public AddFailedException(String message) {
        super(message);
    }
}