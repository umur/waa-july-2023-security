package w1d5.springsecurity.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import w1d5.springsecurity.entity.Address;

@Repository
public interface AddressRepository extends ListCrudRepository<Address, Long> {
}
