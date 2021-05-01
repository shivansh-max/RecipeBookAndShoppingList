package com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.controllers;


import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models.ShoppingListModel;
import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.repos.ShoppingListRepo;
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
@RequestMapping(value = "/shopping-list", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ShoppingListController {
    @Autowired
    ShoppingListRepo shoppingListRepo;

    @GetMapping("/shoppinglist")
    public List<ShoppingListModel> getAllItems() {
        log.info("Successfully imported the list from MYSQL server");
        return shoppingListRepo.findAll();
    }
//
//    @GetMapping("/shoppingitem/{id}")
//    public ShoppingListModel getCertainItem(@PathVariable(value = "id") String itemId) {
//        log.info("Successfully imported the item from MYSQL server");
//        return shoppingListRepo.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("ShoppingListModel"));
//    }
//
//    @DeleteMapping("/deleteitem/{id}")
//    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") String itemId) {
//        log.info("Deleted safely");
//        ShoppingListModel item = shoppingListRepo.findById(itemId)
//                .orElseThrow(() -> new ResourceNotFoundException("ShoppingListModel"));
//
//        shoppingListRepo.delete(item);
//
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/additem")
//    public ShoppingListModel addItem(@RequestBody ShoppingListModel shoppinglistmodel) {
//        log.info("Added post to MYSQL database");
//        return shoppingListRepo.save(shoppinglistmodel);
//    }
//
//    @PutMapping("/changeitem/{id}")
//    public ShoppingListModel updateNameItem(@PathVariable(value = "id") String bookId,
//                                            @RequestBody ShoppingListModel shoppingList) {
//
//        log.info("Changed Item");
//        ShoppingListModel shoppinglist = shoppingListRepo.findById(bookId)
//                .orElseThrow(() -> new ResourceNotFoundException("ShoppingListModel"));
//
//        shoppinglist.setName(shoppingList.getName());
////        book.setId(bookDetails.getId());
////        book.setIsbn(bookDetails.getIsbn());
//
//        ShoppingListModel updatedItem = shoppingListRepo.save(shoppinglist);
//        return updatedItem;
//    }
}