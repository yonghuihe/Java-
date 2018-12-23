package com.company.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 继承：AuthenticatingRealm（认证）
 * 继承：AuthorizingRealm(认证+授权）
 * @author yonghui
 *
 */
public class MyRealm extends AuthorizingRealm{

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//使用token获取用户名，判断数据库中有没有这个用户名，如果没有代表数据库没有这个账号，返回null
		String name = (String) token.getPrincipal();
		//从数据库中获取用户名，密码
		String username = "root";
		String password = "75fb1934bca2c72a040166fd7bfea931";
		if(!name.equals(username)){
			throw new UnknownAccountException();
		}
		/*密码
        String password = new String((char[])token.getCredentials());
		if(!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }*/
		//交由认证器去做相关认证，加盐:使用用户名作为盐，需要在配置文件中告诉shiro
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes("root"),this.getName());
		return info;
	}


	/**
	 * 授权
	 * 1、查询出主体信息(获取用户对象)
	 * 2、从数据库中查询用户拥有的角色和权限
	 * 3、把角色和权限与subject关联在一起
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//String principal = (String) principals.getPrimaryPrincipal();
		//----------------------------------
		List<String> roles = new ArrayList<String>();
		roles.add("role1");
		roles.add("role2");
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:create");
		permissions.add("user:update");
		//----------------------------------
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roles);
		info.addStringPermissions(permissions);

		return info;
	}


}
