package com.apostle.data.repositories;

import com.apostle.data.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    @Query("""
        SELECT COALESCE(
            SUM(
                CASE
                    WHEN t.sender.id   = :accountId THEN 0 - t.amount
                    WHEN t.receiver.id = :accountId THEN  t.amount
                    ELSE 0
                END
            ), 0
        )
        FROM Transaction t
        WHERE t.sender.id   = :accountId
           OR t.receiver.id = :accountId
    """)
    BigDecimal computeBalance(@Param("accountId") Long accountId);
}
