package hello.springmvc.basic.requestmapping.response;

import hello.springmvc.basic.HelloData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
//@RestController
public class ResponseBodyController {

    @RequestMapping("response-body-string-v1")
    public void responseBody1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @RequestMapping("/response-body-string-v2")
    public HttpEntity<String> responseBody2(){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping("/response-body-string-v3")
    public String responseBody3(){
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public HttpEntity<HelloData> responseBodyJsonV1(){
        HelloData helloData = new HelloData();
        helloData.setUsername("maxxyoung");
        helloData.setAge("30");

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("maxxyoung");
        helloData.setAge("30");

        return helloData;
    }



}
