package com.awesome.fraud;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Builder
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(name = "fraud-id-sequence" , sequenceName = "fraud-id-sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "fraud-id-sequence")
    private Integer id ;
    private Integer customerId ;
    private Boolean isFraud ;
    private LocalDateTime createdAt ;

}
