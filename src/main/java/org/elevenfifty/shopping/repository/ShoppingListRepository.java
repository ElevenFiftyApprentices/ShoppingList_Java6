package org.elevenfifty.shopping.repository;


import org.elevenfifty.shopping.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer>{

}
