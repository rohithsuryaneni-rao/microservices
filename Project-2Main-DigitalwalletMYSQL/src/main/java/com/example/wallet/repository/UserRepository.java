package com.example.wallet.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.wallet.model.UserDetail;
@Repository
public interface UserRepository extends JpaRepository<UserDetail,Integer>{
	List<UserDetail> findByName(String name);
}