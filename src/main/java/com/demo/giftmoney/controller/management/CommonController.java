package com.demo.giftmoney.controller.management;

import com.demo.giftmoney.context.SessionContext;
import com.demo.giftmoney.domain.User;
import com.demo.giftmoney.interceptor.LoginRequired;
import com.demo.giftmoney.request.LoginForm;
import com.demo.giftmoney.response.UserView;
import com.demo.giftmoney.service.UserService;
import com.sug.core.platform.crypto.MD5;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.SuccessView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

import static com.demo.giftmoney.constants.CommonConstants.*;


@RestController
@RequestMapping(value = "/management")
public class CommonController {
    @Autowired
    private UserService userService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LOGIN, method = RequestMethod.POST)
    public SuccessView login(@Valid @RequestBody LoginForm form) {
        User user = userService.getByName(form.getName());
        if(Objects.isNull(user) ||
                !MD5.encrypt(form.getPassword() + MD5_SALT).equalsIgnoreCase(user.getPassword())){
            throw new ResourceNotFoundException("用户名或密码错误");
        }
        sessionContext.setUser(user);
        return new SuccessView();
    }

    @RequestMapping(value = CURRENT, method = RequestMethod.GET)
    @LoginRequired
    public UserView current() {
        UserView view = new UserView();
        BeanUtils.copyProperties(sessionContext.getUser(),view);
        return view;
    }

    @RequestMapping(value = LOGOUT, method = RequestMethod.GET)
    public SuccessView logout() {
        sessionContext.logout();
        return new SuccessView();
    }
}
