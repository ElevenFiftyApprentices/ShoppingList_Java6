package org.elevenfifty.shopping.repository;


import org.elevenfifty.shopping.beans.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends CrudRepository<List, Integer>{

}
