package ru.test.Feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.test.Model.GifModel;

import java.util.Map;

@FeignClient(name = "gifService", url= "https://api.giphy.com/v1/gifs/random")
public interface FeignGif {
    @GetMapping()
    GifModel getGif(@RequestParam("api_key")String api_key, @RequestParam("tag") String tag);

}
