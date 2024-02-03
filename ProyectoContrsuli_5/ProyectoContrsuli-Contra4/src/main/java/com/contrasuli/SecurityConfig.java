package com.contrasuli;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("administrador")
                .password("{noop}123")
                .roles("ADMIN", "USER")
                .and()
                .withUser("usuario")
                .password("{noop}456")
                .roles("USER")
                .and();
                
                
    }
    
    //El siguiente metodo realiza la autorizacion a recursos del sitio web
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/tabBus/nuevo", "tabBus/guardar",
                        "/tabBus/modificar/**", "tabBus/eliminar/**",
                        "/tabHorario/nuevo", "tabHorario/guardar",
                        "/tabHorario/modificar/**", "tabHorario/eliminar/**",
                        "/tabTarifa/nuevo", "tabTarifa/guardar",
                        "/tabTarifa/modificar/**", "tabTarifa/eliminar/**",
                        "/tabTikets/nuevo", "tabTikets/guardar",
                        "/tabTikets/modificar/**", "tabTikets/eliminar/**",
                        "/tabRuta/nuevo", "tabRuta/guardar",
                        "/tabRuta/modificar/**", "tabRuta/eliminar/**",
                         "/empresa")
                .hasRole("ADMIN")
                .antMatchers("/tabBus/listado",
                        "/tabHorario/listado",
                        "/tabTarifa/listado",
                        "/tabParada/listado",
                        "/tabRuta/listado")
                .hasAnyRole("ADMIN", "USER")
                .and().formLogin().loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/errores/403");
                
    }
    
}
