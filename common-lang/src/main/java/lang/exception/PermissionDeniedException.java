package lang.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 没有权限异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@Getter
@Setter
@SuppressWarnings("unused")
public class PermissionDeniedException extends BaseException {

    /**
     * 需要的权限
     */
    private List<String> permissionList;

    /**
     * @param message 异常消息
     */
    public PermissionDeniedException(String message) {
        super(message);
    }

    /**
     * @param permissionList 未授权或未签约的权限列表
     */
    public PermissionDeniedException(List<String> permissionList) {
        this.permissionList = permissionList;
    }

    /**
     * @param message        异常消息
     * @param permissionList 未授权或未签约的权限列表
     */
    public PermissionDeniedException(String message, List<String> permissionList) {
        super(message);
        this.permissionList = permissionList;
    }
}