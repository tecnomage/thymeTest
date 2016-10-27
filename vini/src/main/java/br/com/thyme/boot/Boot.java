
package br.com.thyme.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = {"br.com.thyme.oldproject", "br.com.thyme.boot"})
public class Boot
{

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }

   @RequestMapping("/")
   public String home()
   {
      return "index";
   }
}
