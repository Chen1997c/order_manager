package com.blank.shiro.realm;

import com.blank.entity.User;
import com.blank.service.UUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * <p>
 * 功能描述:自定义realm
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UUserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> positions = userService.getPositionsByUaccount(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(positions);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken customToken = (UsernamePasswordToken) authenticationToken;
        String account = customToken.getUsername();
        User user = userService.login(account);
        if (user == null) {
            throw new UnknownAccountException();
        }if("t".equals(user.getU_isLocked())) {
            throw new LockedAccountException();
        }
        //根据帐号来加盐
//        ByteSource salt = ByteSource.Util.bytes(account);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(account, user.getU_password(), getName());
        return info;
    }
}
