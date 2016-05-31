//package com.yjs.server.secure;
//
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.UUID;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.CredentialsContainer;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;
//
//import com.yjs.server.constant.ServerConstants.Role;
//import com.yjs.server.domain.User;
//
///**
// * A Spring Security {@link Authentication} implementation that stores
// * authentication and authorization information for a person.
// */
//public final class APIAuthenticationToken implements Authentication, CredentialsContainer {
//    
//    /**	
//     * Member Description
//     */
//    
//    private static final long serialVersionUID = 1L;
//    
//    private Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//    private String name;
//    private User user;
//    private String token;
//    private boolean isAuthenticated = true;
//    
//    public APIAuthenticationToken(User user){
//        authorities.add(new SimpleGrantedAuthority(Role.USER.getName()));
//        
//        this.user = user;
//        name = user.getMobile();
////        role = user.getMobile();
//        
//        token = UUID.randomUUID().toString();
//    }
//
//    @Override
//    public String getName() {
//        // TODO Auto-generated method stub
//        return name;
//    }
//
//    @Override
//    public void eraseCredentials() {
////        authorities.clear();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // TODO Auto-generated method stub
//        return authorities;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return Role.USER.getName();
//    }
//
//    @Override
//    public Object getDetails() {
//        return Role.USER.getName();
//    }
//
//    @Override
//    public Object getPrincipal() {
//        // TODO Auto-generated method stub
//        return user;
//    }
//
//    @Override
//    public boolean isAuthenticated() {
//        return isAuthenticated;
//    }
//
//    @Override
//    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
//        this.isAuthenticated = isAuthenticated;
//    }
//    
//    
//}
