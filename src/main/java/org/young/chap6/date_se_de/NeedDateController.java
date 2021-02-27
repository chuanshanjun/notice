package org.young.chap6.date_se_de;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@RestController
@RequestMapping("/need/date")
public class NeedDateController {

    @GetMapping("/param")
    public Map<String, Long> date(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        Map<String, Long> result = new HashMap<>();
        result.put("date", date.getTime());
        return result;
    }

    @PostMapping("/param")
    public Map<String, Long> postDate(@RequestBody User user) {
        Map<String, Long> result = new HashMap<>();
        result.put("date", user.getBirthday().getTime());
        return result;
    }
}

