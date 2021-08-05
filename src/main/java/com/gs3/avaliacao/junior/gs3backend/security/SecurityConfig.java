//package com.gs3.avaliacao.junior.gs3backend.security;

//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth.inMemoryAuthentication()
//
//                .withUser("admin").password(encoder.encode("123456"))
//                .roles("ADMIN")
//
//                .and().withUser("comun").password(encoder.encode("123456"))
//                .roles("USER");
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests().antMatchers(HttpMethod.GET, "/**")
//                .permitAll().anyRequest().authenticated()
//                .and().httpBasic();
//    }
//}
