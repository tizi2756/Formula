package com.liu.controller;

import com.liu.serviceI.OperationServiceI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class cController {
    private static final Log logger = LogFactory.getLog(cController.class);
    @Autowired
    private OperationServiceI operationServiceI;

    @RequestMapping(value = "/operationAll")
    public String All(HttpRequest request){

    }
}
