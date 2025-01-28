package com.example.demo.Services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.Models.UserData;

public class UserInfoDetails implements UserDetails {

	private String email;
	private String password;
	private UserData udata;
	private List<GrantedAuthority> grantedauthorities;
	public UserInfoDetails(UserData userdata) {
		udata=userdata;
		email= userdata.getEmail();
		password=userdata.getPassword();
		grantedauthorities=Arrays.stream(userdata.getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedauthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	
	public UserData getUserData() {
		// TODO Auto-generated method stub
		return udata;
	}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


//
//package com.example.demo.Services;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.demo.Models.UserData;
//
//public class UserInfoDetails implements UserDetails {
//
//    private String id;
//    private String email;
//    private String password;
//    private String name;
//    private String phone;
//    private List<GrantedAuthority> grantedAuthorities;
//
//    public UserInfoDetails(UserData userdata) {
//        this.id = userdata.getId();
//        this.email = userdata.getEmail();
//        this.password = userdata.getPassword();
//        this.name = userdata.getName();
//        this.phone = userdata.getPhone();
//        this.grantedAuthorities = Arrays.stream(userdata.getRole().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return grantedAuthorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
//
