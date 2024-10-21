package com.example.wallet.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wallet.model.CertificateDetail;
import com.example.wallet.model.UserDetail;
import com.example.wallet.repository.CertificateRepository;
//import com.example.wallet.repository.UserDetailsRepository;
import com.example.wallet.repository.UserRepository;
@Service
public class WalletService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CertificateRepository certificateRepository;
	public UserDetail registerUser(UserDetail user)
	{
		return userRepository.save(user);
	}
	public List<UserDetail> findByName(String name)
	{
		return userRepository.findByName(name);
	}
	public List<UserDetail> findAll() {
        return userRepository.findAll();
    }
	public UserDetail findById(int num) {
        return userRepository.findById(num).orElse(null);
    }
	public UserDetail saveUser(UserDetail user) 
	{
        return userRepository.save(user);
    }
	public CertificateDetail saveCer(CertificateDetail cert) 
	{
        return certificateRepository.save(cert);
    }
}