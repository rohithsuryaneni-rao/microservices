package com.example.wallet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.wallet.model.CertificateDetail;
@Repository
public interface CertificateRepository extends JpaRepository<CertificateDetail,Integer>{
}