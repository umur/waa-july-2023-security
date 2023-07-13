package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import product.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{
}
