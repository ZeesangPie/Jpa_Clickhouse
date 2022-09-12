package com.example.jpatest.Controller;

import com.example.jpatest.Entity.Clickhouse.Article;
import com.example.jpatest.Entity.MySQL.Actor;
import com.example.jpatest.Repository.Clickhouse.ArticleRepository;
import com.example.jpatest.Repository.MySQL.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ActorRepository actorDao;

    @Autowired
    private ArticleRepository articleDao;

    @GetMapping("/test1")
    public List<Actor> test() {
        return actorDao.findAll();
    }

//    @Transactional(transactionManager = "clickhouseTransactionManager", propagation = Propagation.REQUIRED)
    @GetMapping("/test2")
    public void test2() {
        Article article = new Article().setTitle("是标题啦").setContent("是文章内容啦").setId(1L);
        articleDao.save(article);
    }

    @GetMapping("/test3")
    public List<Article> test3() {
        return articleDao.findAll();
    }
}
