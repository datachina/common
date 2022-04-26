package lang.exception;

import lombok.NoArgsConstructor;

/**
 * 参数为空异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class ParamEmptyException extends BaseException {

    /**
     * @param message 异常消息
     */
    public ParamEmptyException(String message) {
        super(message);
    }
}