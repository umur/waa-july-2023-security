package Demo1.demo.repository;

import Demo1.demo.entity.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepository extends ListCrudRepository<Address, Long>{

}
