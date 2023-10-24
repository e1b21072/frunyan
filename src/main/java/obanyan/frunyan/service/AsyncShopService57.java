package obanyan.frunyan.service;

import java.util.ArrayList;
// import java.util.concurrent.TimeUnit;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import obanyan.frunyan.model.Fruit;
import obanyan.frunyan.model.FruitMapper;

@Service
public class AsyncShopService57 {
  boolean dbUpdated = false;

  // private final Logger logger =
  // LoggerFactory.getLogger(AsyncShopService57.class);

  @Autowired
  FruitMapper fMapper;

  /**
   * 購入対象の果物IDの果物をDBから削除し，購入対象の果物オブジェクトを返す
   *
   * @param id 購入対象の果物のID
   * @return 購入対象の果物のオブジェクトを返す
   */
  @Transactional
  public Fruit syncBuyFruits(int id) {
    // 削除対象のフルーツを取得
    Fruit fruit = fMapper.selectById(id);

    // 削除
    fMapper.deleteById(id);

    // 非同期でDB更新したことを共有する際に利用する
    this.dbUpdated = true;

    return fruit;
  }

  public ArrayList<Fruit> syncShowFruitsList() {
    return fMapper.selectAllFruit();
  }
}
