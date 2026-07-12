//WID(12/07/2026(Sarthak Mittal(DegamieSign(JwtAuthFilter#1)).1
package com.kafka.Carofly;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc

public class JwtAuthFilter extends HttpHeaderSecurityFilter{
    public void setHeader(String header){this.header=header;}
    public String header;
    @Autowired
    public UserDetailsService userDetailsService;
}
