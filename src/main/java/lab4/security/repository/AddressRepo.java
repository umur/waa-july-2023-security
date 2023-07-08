package lab4.security.repository;

import lab4.security.entity.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends ListCrudRepository<Address, Long> {
//    List<Product> findAllByPriceGreaterThan(int price);
}