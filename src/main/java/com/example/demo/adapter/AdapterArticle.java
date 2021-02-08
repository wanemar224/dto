package com.example.demo.adapter;

import com.example.demo.dto.ArticleDto;
import com.example.demo.entity.Article;
import org.springframework.stereotype.Service;

@Service
public class AdapterArticle {

    public ArticleDto toArticleDto(Article article){
        return ArticleDto.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .userPseudo(article.getUser().getPseudo())
                .userId(article.getUser().getId())
                .addressUser(article.getUser().getAddress().getStreet() + " " +article.getUser().getAddress().getStreetName()+", "+article.getUser().getAddress().getCity())
                .build();
    }

    public Article toArticle(ArticleDto articleDto){
        return Article.builder()
                .content(articleDto.getContent())
                .title(articleDto.getTitle())
                .build();
    }
}
