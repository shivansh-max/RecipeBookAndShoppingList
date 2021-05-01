package com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.services;



import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models.Ingrident;
import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models.ProcessedData;
import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models.RecipeModel;
import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.repos.RecipeRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class GetData {

    @Autowired
    RecipeRepo recipeRepo;


    public ResponseEntity<List<ProcessedData>> manipulateData() {
        ResponseEntity r = null;
        log.info("Successfully imported the item from MYSQL server");

        List<RecipeModel> allRecipes = recipeRepo.findAll();
        List<ProcessedData> processedData = new ArrayList<ProcessedData>();
        ListIterator<RecipeModel> iterator = allRecipes.listIterator();
        while (iterator.hasNext()) {
            RecipeModel r1 = iterator.next();
            ProcessedData p = new ProcessedData();
            p.setRecipeModel(r1);
            String[] name = r1.getName_of_ingredient().split(",");
            String[] qty = r1.getAmount_of_ing().split(",");
            List<Ingrident> in = new ArrayList<>();
            for (int i = 0; i < qty.length; i++) {
                Ingrident t = new Ingrident();
                t.setRecipeName(name[i]);
                t.setQty(qty[i]);
                in.add(t);

            }
            p.setIngrident(in);
            processedData.add(p);

        }
        //processedData = allRecipes.stream().

//        System.out.println(allRecipes);
//        return recipeRepo.findAll();
        return new ResponseEntity<List<ProcessedData>>(processedData, HttpStatus.OK);
    }

    //    public void certainManipulateData(String id) {
    public ResponseEntity<List<ProcessedData>> certainManipulateData(String id) {

        log.info("Successfully imported the item from MYSQL server");

        RecipeModel allRecipes = recipeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("RecipeModel"));
        List<ProcessedData> processedData = new ArrayList<ProcessedData>();
        System.out.println(allRecipes);
        RecipeModel r1  = allRecipes;
        ProcessedData p = new ProcessedData();
        p.setRecipeModel(r1);
        String [] name = r1.getName_of_ingredient().split(",");
        String [] qty = r1.getAmount_of_ing().split(",");
        List<Ingrident> in = new ArrayList<>();
        for(int i=0;i<qty.length;i++){
            Ingrident t = new Ingrident();
            t.setRecipeName(name[i]);
            t.setQty(qty[i]);
            in.add(t);

        }
        p.setIngrident(in);
        processedData.add(p);


        //processedData = allRecipes.stream().

//        System.out.println(allRecipes);
//        return recipeRepo.findAll();
        return new ResponseEntity<List<ProcessedData>>(processedData, HttpStatus.OK);
    }


}