package com.example.demo.controller;

import com.example.demo.adapter.AdapterArticle;
import com.example.demo.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final AdapterArticle adapterArticle;
    private final ArticleService articleService;

    public ArticleController(AdapterArticle adapterArticle, ArticleService articleService) {
        this.adapterArticle = adapterArticle;
        this.articleService = articleService;
    }
}
