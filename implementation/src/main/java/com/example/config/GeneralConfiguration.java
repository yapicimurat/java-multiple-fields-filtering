package com.example.config;

import com.example.filter.FilterFlow;
import com.example.filter.FilterMap;
import com.example.filter.FilterRule;
import com.example.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class GeneralConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public FilterFlow filterFlow() {
        final Map<String, FilterMap> filterMaps = new HashMap<>();

        //ADD ALL MAP RULES FOR ENTITIES

        //<----- START PRODUCT RULES -------->

        //Product name field rule
        filterMaps.put(
                "product_name",
                new FilterMap("product_name", "name", Product.class, FilterRule.STRING_SINGLE_EQUALS)
        );
        //Product color field rule
        filterMaps.put(
                "product_color",
                new FilterMap("product_color", "color", Product.class, FilterRule.STRING_MULTIPLE_EQUALS)
        );

        //Product gender field rule
        filterMaps.put(
                "product_gender",
                new FilterMap("product_gender", "gender", Product.class, FilterRule.STRING_SINGLE_EQUALS)
        );

        //<----- END PRODUCT RULES -------->


        return new FilterFlow(filterMaps);
    }
}
