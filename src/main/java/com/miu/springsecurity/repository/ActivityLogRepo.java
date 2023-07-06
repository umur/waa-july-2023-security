package com.miu.springsecurity.repository;


import com.miu.springsecurity.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ActivityLogRepo extends CrudRepository<ActivityLog,Integer> {

}
