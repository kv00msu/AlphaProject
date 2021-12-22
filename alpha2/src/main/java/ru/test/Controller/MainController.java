package ru.test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.test.Feign.FeignCurrency;
import ru.test.Feign.FeignGif;
import ru.test.Model.CurrencyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ru.test.Model.GifModel;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.eclipse.jetty.util.LazyList.size;

@RequestMapping("/result")
@Controller
public class MainController{
    @Value("${app_id}")
    private String app_id;

    @Value("${api_key}")
    private String api_key;

    @Autowired
    private FeignGif feignGif;

    @Autowired
    private FeignCurrency feignCurrency;



    @GetMapping()
    public String getGif(@RequestParam(name = "currency")String currency,Map<String, Object> model) {
        CurrencyModel response1 = feignCurrency.curLatest(app_id);
        LocalDateTime ldt = LocalDateTime.now().minusDays(1);
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        Date date = Date.valueOf(formmat1.format(ldt));
        CurrencyModel response2 = feignCurrency.curHistorical(date, app_id);
        Map<String,Object> result = new HashMap<>();

        if (response1.getRates().get(currency) - response2.getRates().get(currency) > 0) {
            GifModel responseGif = feignGif.getGif(api_key, "rich");
            result.put("url", ((Map<String, Object>)(((Map<String, Object>) (responseGif.getData().get("images"))).get("original"))).get("url"));
            model.put("url", result.get("url"));
        }
        else {
            GifModel responseGif = feignGif.getGif(api_key, "broke");
            result.put("url", ((Map<String, Object>)(((Map<String, Object>) (responseGif.getData().get("images"))).get("original"))).get("url"));
            model.put("url", result.get("url"));
        }
        return "gif";
    }

}
