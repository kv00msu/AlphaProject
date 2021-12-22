package ru.test.Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class GifModel {
    private Map<String, Object> data;
    private Map<String, Object> meta;
}
