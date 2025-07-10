//
//package com.apostle.services;
//
//import com.apostle.data.model.AccountType;
//import com.apostle.data.model.BankAccount;
//import com.apostle.data.repositories.BankAccountRepository;
//import jakarta.annotation.PostConstruct;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//
//
//@Component
//@RequiredArgsConstructor
//public class SystemAccountInitializer {
//    private final BankAccountRepository bankAccountRepository;
//    private final Logger logger = LoggerFactory.getLogger(SystemAccountInitializer.class);
//
//    @Transactional
//    @PostConstruct
//    public void createSystemAccountIfNotExists() {
//        try {
//            if (!bankAccountRepository.existsByAccountNumber("SYSTEM")) {
//                logger.info("Creating system account...");
//                BankAccount systemAccount = BankAccount.builder()
//                        .accountNumber("SYSTEM")
//                        .balance(BigDecimal.ZERO)
//                        .accountType(AccountType.SYSTEM)
//                        .name("System Account")
//                        .user(null)
//                        .build();
//
//                logger.info("Attempting to save system account with type: {}", systemAccount.getAccountType());
//                logger.info("System account details: {}", systemAccount);
//
//                bankAccountRepository.save(systemAccount);
//                logger.info("System account created successfully");
//            } else {
//                logger.info("System account already exists");
//            }
//        } catch (Exception e) {
//            logger.error("Error creating system account: " + e.getMessage(), e);
//            if (e.getCause() != null) {
//                logger.error("Cause: " + e.getCause().getMessage());
//            }
//            throw e;
//        }
//    }
//}