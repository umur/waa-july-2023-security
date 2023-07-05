package cs545.DAO;

import cs545.Domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
    Address getAddressById(Integer id);
}
