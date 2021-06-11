package web.userDetails;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();

        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        for (GrantedAuthority role : roles) {
            if (role.getAuthority().equals("ADMIN")) {

                httpServletResponse.sendRedirect("/admin/list");
                return;
            } else {
                httpServletResponse.sendRedirect("/hello?id=" + authUser.getId());
            }
        }
    }
}