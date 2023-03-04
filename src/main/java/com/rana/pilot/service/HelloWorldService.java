package com.rana.pilot.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class HelloWorldService {

    public String test()  {
        String add="no address";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            add=inetAddress.getHostAddress();
            add =add +"--"+inetAddress.getHostName();
        }catch (Exception e){

        }


        return "Hello pratiksha pundir\n call is handled by "+add;
    }
}
