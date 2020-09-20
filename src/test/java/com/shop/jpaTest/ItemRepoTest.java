package com.shop.jpaTest;


import com.shop.domain.Item;
import com.shop.repos.ItemRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepoTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ItemRepo itemRepo;

    @Test
    public void whenFindByName_thenReturnItem() {
        Item item = new Item();
        item.setName("testItem");
        item.setPrice(101);
        item.setStockQuantity(10);
        entityManager.persist(item);
        Item found = itemRepo.findByName(item.getName());
        assert (found.getName().equals(item.getName()));

    }


}
