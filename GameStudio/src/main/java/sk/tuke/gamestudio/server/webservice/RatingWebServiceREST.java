package sk.tuke.gamestudio.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.entity.Rating;
import sk.tuke.gamestudio.service.RatingService;

import java.util.Date;

@RestController
@RequestMapping("/api/rating")
public class RatingWebServiceREST {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    void setRating(@RequestBody Rating rating){
        ratingService.setRating(rating);
    }

    @GetMapping("/{game}")
    Rating getAverageRating(@PathVariable String game){
        Rating ratingWithAvg = new Rating(ratingService.getAverageRating(game));
        return ratingWithAvg;
    }

    @GetMapping("/{game}/{username}")
    Rating getRating(@PathVariable String game, @PathVariable String username){
        Rating rating = new Rating(game, username, ratingService.getAverageRating(game), new Date());
        return rating;
    }
}
