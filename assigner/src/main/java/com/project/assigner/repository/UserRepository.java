package com.project.assigner.repository;

import com.project.assigner.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query(value = "select * from user left join role on user.role_id=role.role_id where role.name=\"DEV\" ", nativeQuery = true)
    List<User> findAllDevs();
}
