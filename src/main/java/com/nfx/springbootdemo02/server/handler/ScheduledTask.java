package com.nfx.springbootdemo02.server.handler;

import com.nfx.springbootdemo02.dao.model.Comment;
import com.nfx.springbootdemo02.dao.model.Product;
import com.nfx.springbootdemo02.dao.model.User;
import com.nfx.springbootdemo02.dao.repo.CommentDao;
import com.nfx.springbootdemo02.dao.repo.ProductDao;
import com.nfx.springbootdemo02.dao.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.tokens.BlockEndToken;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ScheduledTask {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ProductDao productDao;

    @Scheduled(fixedRate = 10000)
    public void calculateFavorableRating() {
        System.out.println("执行一次");
        List<User> users = userDao.getAllData();
        DecimalFormat df = new DecimalFormat("#.00");

        // 遍历每个用户
        for (User user : users) {
            List<Product> products = productDao.getProductByPublisherName(user.getName());
            if (products.toArray().length == 0) {
                continue;
            }

            double goodRating = 0;
            double badRating = 0;

            // 遍历用户的每个商品,获取改用户商品的好评数和差评数
            for (Product product : products) {
                List<Comment> goodComments = commentDao.getCommentByProductAndType(product.getId(), 1);
                List<Comment> badComments = commentDao.getCommentByProductAndType(product.getId(), 0);

                goodRating += goodComments.toArray().length;
                badRating += badComments.toArray().length;
            }
            if (goodRating + badRating == 0) {
                continue;
            }

            double rating = goodRating / (goodRating + badRating);
            String ratingString = df.format(rating);
            rating = Double.parseDouble(ratingString);

            // 将好评率更新到用户表中
            userDao.updateFavorableRate(user.getId(), rating);
        }
    }
}
