package com.recipe.recipeRestApi.controllers;

import com.recipe.recipeRestApi.models.ProcessedData;
import com.recipe.recipeRestApi.models.RecipeModel;
import com.recipe.recipeRestApi.repos.RecipeRepo;
import com.recipe.recipeRestApi.service.GetData;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@ResponseBody
@Transactional
@Slf4j
@RequestMapping(value = "/recipe", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class RecipeController {

    @Autowired
    GetData getData;

    @Autowired
    RecipeRepo recipeRepo;

    @GetMapping("/recipe")
    public ResponseEntity<List<ProcessedData>> getManipulatedData() {

        return getData.manipulateData();
    }

    @GetMapping("/certainrecipes/{id}")
    public ResponseEntity<List<ProcessedData>> getCertainManipulatedData(@PathVariable(value="id") String id) {

        return getData.certainManipulateData(id);
    }

    @DeleteMapping("/deleterecipe/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable(value = "id") String itemId) {
        log.info("Deleted safely");
        RecipeModel item = recipeRepo.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("ShoppingListModel"));

        recipeRepo.delete(item);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/addrecipe")
    public RecipeModel addItem(@RequestBody RecipeModel recipemodel) {
        log.info("Added post to MYSQL database");
        return recipeRepo.save(recipemodel);
    }
}


