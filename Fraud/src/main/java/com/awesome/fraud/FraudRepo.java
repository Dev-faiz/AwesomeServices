package com.awesome.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepo extends JpaRepository<FraudCheckHistory , Integer> {
}
