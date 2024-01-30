package com.boost.example1.Restaurant;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class RestaurantController {
    public List<Restaurant> restaurantList = new ArrayList<>();

    public RestaurantController() {
        // 초기 데이터를 restaurantList에 추가
        restaurantList.add(new Restaurant("1", "한식집1", "한식"));
        restaurantList.add(new Restaurant("2", "양식집1", "양식"));
        restaurantList.add(new Restaurant("3", "중식집1", "중식"));
    }
    @PostMapping("/restaurants.post")
    public void addRestaurant(
            @RequestParam String name,
            @RequestParam String category) {
        Restaurant restaurant = new Restaurant(generateUniqueId(), name, category);
        restaurantList.add(restaurant);
    }

    @PostMapping("/restaurants.delete")
    public void deleteRestaurant(
            @RequestParam String name,
            @RequestParam String category){
        for(int i = 0; i < restaurantList.size(); i++){
            Restaurant restaurant = restaurantList.get(i);
            if((category.equals(restaurant.getCategory())) && (name.equals(restaurant.getName()))){
                restaurantList.remove(restaurant);
                break;
            }
        }
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantList;
    }

    @GetMapping("/restaurants/category")
    public List<Restaurant> fetchRestaurant(
            @RequestParam(value = "category") String category
    ) {
        List<Restaurant> filteredList = new ArrayList<>();
        for (int i = 0; i < restaurantList.size(); i++) {
            Restaurant restaurant = restaurantList.get(i); // i번째 객체 restaurant에 담기
            if(category.equals(restaurant.getCategory())){
                filteredList.add(restaurant);
            }
        }
        return filteredList;
    }

    @PostMapping("/resetData")
    public void resetData() {
        restaurantList.clear();
    }
    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
