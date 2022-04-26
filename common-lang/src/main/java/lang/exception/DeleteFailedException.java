package lang.exception;

import lombok.NoArgsConstructor;

/**
 * 删除失败异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class DeleteFailedException extends BaseException {

    /**
     * @param message 异常消息
     */
    public DeleteFailedException(String message) {
        super(message);
    }
}