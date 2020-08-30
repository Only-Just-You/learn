package org.example.xmlDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config_01 {
    @Bean
    public Art_01 art_01(){
        return new Art_01("浪客之道","斩钢闪","风之障壁","踏前斩","狂风绝息斩");
    }
    @Bean
    public Role_01 role_01(){
        return new Role_01("疾风剑豪",450,0, art_01());
    }
}
