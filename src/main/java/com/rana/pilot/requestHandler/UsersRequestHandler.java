package com.rana.pilot.requestHandler;

import com.rana.pilot.api.UsersApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Component
public class UsersRequestHandler implements UsersApiDelegate {

    @Autowired
    NativeWebRequest nativeWebRequest;


    @Override
    public ResponseEntity<String> usersGet() {
        System.out.println("my own implementation...");
        //HttpServletRequest servletRequest=nativeWebRequest;
        //String ipAddress =  nativeWebRequest. getRemoteAddr();
        return new ResponseEntity<String>("kirandeep Rana ji",HttpStatus.CREATED);

    }
}
