package org.young.chap6.http_request_response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Slf4j
public class RequestParseUtil {

    public static boolean isJson(HttpServletRequest request, HttpServletResponse response) {
        if (!StringUtils.isEmpty(request.getContentType())) {
            return request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)
                    || request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE);
        }

        return false;
    }

    public static String getBodyString(final ServletRequest request) {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException ioe) {
            log.info("IOException", ioe);
        }

        return sb.toString();
    }
}
