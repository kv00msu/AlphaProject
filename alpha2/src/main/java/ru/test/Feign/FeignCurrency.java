package ru.test.Feign;

import ru.test.Model.CurrencyModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@FeignClient(name = "currencyService", url = "https://openexchangerates.org/api/")
public interface FeignCurrency {
    @GetMapping("/historical/{date}.json")
    CurrencyModel curHistorical(@PathVariable("date") Date date, @RequestParam("app_id")String app_id);

    @GetMapping("/latest.json")
    CurrencyModel curLatest(@RequestParam("app_id")String app_id) ;

}
