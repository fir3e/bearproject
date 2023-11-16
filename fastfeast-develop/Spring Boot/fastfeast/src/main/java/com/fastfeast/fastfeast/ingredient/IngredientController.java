package com.fastfeast.fastfeast.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/ingredient")
public class IngredientController {
    
    @Autowired
    private IngredientDAO ingredientDAO;

    @PostMapping(path = "/add")
    public @ResponseBody String addIngredient(@RequestParam String name){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredientDAO.save(ingredient);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Ingredient> getAllIngredients(){
        return ingredientDAO.findAll();
    }

    @GetMapping(path = "/get-by-id")
    public @ResponseBody Ingredient getIngredientById(@RequestParam Integer id){
        return ingredientDAO.findById(id).get();
    }
}
