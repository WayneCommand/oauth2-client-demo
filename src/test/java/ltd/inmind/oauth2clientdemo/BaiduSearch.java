package ltd.inmind.oauth2clientdemo;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface BaiduSearch {

    @RequestLine(value = "GET /s?wd={wd}&pm={pn}&rn={rn}&tn={tn}")
    @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: application/json"})
    String search(@Param("wd") String wd, @Param("pn") String pn, @Param("rn") String rn, @Param("tn") String tn);


}
