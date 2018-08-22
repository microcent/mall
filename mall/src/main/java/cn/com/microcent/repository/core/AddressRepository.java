package cn.com.microcent.repository.core;

import cn.com.microcent.domain.core.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(long userId);

}
