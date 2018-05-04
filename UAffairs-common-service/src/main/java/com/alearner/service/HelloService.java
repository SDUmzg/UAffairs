package com.alearner.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.alearner.modle.hbase.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(String name){
        return restTemplate.getForObject("http://hbase-client/hello?name="+name,String.class);
    }

    public UserDto queryHbase(String row){
        UserDto userDto=restTemplate.getForObject("http://hbase-client/queryHbase?row="+row,UserDto.class);
        return userDto;
    }


    public List<UserDto> query(String startRow,
                               String stopRow){
        String url = "http://hbase-client/query?startRow="+startRow+"&stopRow="+stopRow;
        return restTemplate.getForObject(url,List.class);
    }


    public String helloError(String name){
        return "hi , "+name+"  orror request ,service name : ribbon";
    }



/*    public OBaProductCategoryModel getBusinessCategory(int category_id){
        String url = "http://postgresql-client/businessTarget/getBusinessCategory?category_id=" + category_id;
        logger.info("request the url :"+url );
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<OBaProductCategoryModel>() {
        }).getBody();
    }
    public String putCacheList(String table, String row,String val){
        String url="http://hbase-client/businessTarget/putCacheList";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("table", table);
        params.add("row", row);
        params.add("val", val);
        logger.info("request the url :"+url +"params"+params.toString());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class).getBody();
    }
    public List<TopBusinessDayDTo> getTopBusinessDay(String table, String startRow,String stopRow) {
        String url = "http://hbase-client/businessTarget/getTopBusinessDay?table=" + table + "&startRow=" + startRow+"&stopRow="+stopRow;
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<TopBusinessDayDTo>>() {
        }).getBody();
    }
    */


}
