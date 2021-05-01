package com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.controllers;


import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models.ProcessedData;
import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models.RecipeModel;
import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.repos.RecipeRepo;
import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.services.GetData;
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

    @GetMapping("/allrecipes")
    public ResponseEntity<List<ProcessedData>> getManipulatedData() {

        return getData.manipulateData();
    }

    @GetMapping("/certainrecipes/{id}")
    public ResponseEntity<List<ProcessedData>> getCertainManipulatedData(@PathVariable(value="id") String id) {
//    public void getCertainManipulatedData(@PathVariable(value="id") String id) {

//        getData.certainManipulateData(id);

//        List<ProcessedData>data = (List<ProcessedData>) getData.manipulateData();

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
