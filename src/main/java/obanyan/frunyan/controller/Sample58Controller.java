package obanyan.frunyan.controller;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

// import obanyan.frunyan.service.AsyncCount58;

@RestController
@RequestMapping("/sample58")
public class Sample58Controller {
  private final Logger logger = LoggerFactory.getLogger(Sample58Controller.class);

  @GetMapping("step1")
  public void pushCount58(@AuthenticationPrincipal UserDetails user) {
    // infoレベルでログを出力する
    logger.info("pushCount");
    logger.info(user.getUsername());
    // ロールをStringでまとめて取得する
    logger.info(user.getAuthorities().toString() + ":toString");

    // ロールを1つずつ取得する場合はこちら
    for (GrantedAuthority g : user.getAuthorities()) {
      logger.info(g.getAuthority());
    }
  }
}
