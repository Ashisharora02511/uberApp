package com.java.uber.uberApp.dto;

import java.util.List;

import com.java.uber.uberApp.entities.User;


import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class WalletDto {
	
	  private Long id;

	    @OneToOne(fetch = FetchType.LAZY)
	    private UserDto user;
	    
	    private Double balance;

	    @OneToMany(mappedBy = "wallet",fetch=FetchType.LAZY)
	    private List<WalletTransactionDto> transactions;
	}



